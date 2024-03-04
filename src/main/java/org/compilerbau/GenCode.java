package org.compilerbau;

import static org.compilerbau.ast.Operator.eq;
import static org.compilerbau.ast.Operator.neq;
import static org.compilerbau.ast.Typ.BOXED_BOOLEAN;
import static org.compilerbau.ast.Typ.BOXED_INT;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;

import org.compilerbau.ast.AST;
import org.compilerbau.ast.Arg;
import org.compilerbau.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.ast.ArrayExpression;
import org.compilerbau.ast.Assign;
import org.compilerbau.ast.Block;
import org.compilerbau.ast.BooleanBoolean;
import org.compilerbau.ast.BreakExpression;
import org.compilerbau.ast.ComparisonExpression;
import org.compilerbau.ast.ContinueExpression;
import org.compilerbau.ast.FieldExpression;
import org.compilerbau.ast.FunCall;
import org.compilerbau.ast.FunDef;
import org.compilerbau.ast.GroupedExpression;
import org.compilerbau.ast.IfExpression;
import org.compilerbau.ast.IndexVariable;
import org.compilerbau.ast.IntegerInteger;
import org.compilerbau.ast.LoopExpression;
import org.compilerbau.ast.NegationExpression;
import org.compilerbau.ast.Null;
import org.compilerbau.ast.Operator;
import org.compilerbau.ast.Program;
import org.compilerbau.ast.ReturnExpression;
import org.compilerbau.ast.StringLit;
import org.compilerbau.ast.StructCall;
import org.compilerbau.ast.StructDeclaration;
import org.compilerbau.ast.TheTyp;
import org.compilerbau.ast.TheVisibility;
import org.compilerbau.ast.Typ;
import org.compilerbau.ast.Variable;
import org.compilerbau.ast.Visibility;
import org.compilerbau.ast.Visitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class GenCode implements Visitor<Void> {

  private final String resultPath;
  private ClassWriter cw;
  private String module;
  private MethodVisitor mv;
  private Map<String, Integer> env;

  private final Stack<Label> endLabels = new Stack<>();
  private final Stack<Label> startLabels = new Stack<>();


  public GenCode(String resultPath) {
    this.resultPath = resultPath;
  }

  @Override
  public Void visit(Program ast) {
    module = ast.name();
    cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    cw.visit(Opcodes.V21, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, ast.name(), null, "java/lang/Object", null);
    cw.visitSource(ast.name() + ".gr", null);
    ast.funDefs().forEach((n, fun) -> fun.welcome(this));
    ast.structDefs().forEach((n, struct) -> struct.welcome(this));
    cw.visitEnd();
    try {
      var out = new FileOutputStream(resultPath + "/" + ast.name() + ".class");
      out.write(cw.toByteArray());
      out.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public Void visit(FunDef ast) {
    String s =
        "(" + ast.args().stream().map(arg -> arg.typ().jvmType()).reduce("", String::concat) + ")" + ast.typ().jvmType();

    var publicCode = ast.visibility() == Visibility.PUBLIC ? Opcodes.ACC_PUBLIC : Opcodes.ACC_PRIVATE;
    mv = cw.visitMethod(publicCode | Opcodes.ACC_STATIC, ast.name(), s, null, null);
    env = new MkStackEnv().visit(ast);
    ast.body().welcome(this);
    mv.visitMaxs(1, 1);
    mv.visitEnd();
    return null;
  }

  @Override
  public Void visit(Variable ast) {
    mv.visitVarInsn(Opcodes.ALOAD, env.get(ast.name()));
    return null;
  }

  @Override
  public Void visit(Arg ast) {
    return null;
  }

  @Override
  public Void visit(TheTyp ast) {
    return null;
  }

  @Override
  public Void visit(TheVisibility ast) {
    return null;
  }

  @Override
  public Void visit(Block ast) {
    for (AST s : ast.statements()) {
      s.welcome(this);
      // if node is a straight fun call, we need to pop the result of the stack
      if (s.attributes().typ != Typ.VOID && s instanceof FunCall) {
        mv.visitInsn(Opcodes.POP);
      }
    }
    return null;
  }

  @Override
  public Void visit(Assign ast) {
    switch (ast.var()) {
      case Variable var -> {
        ast.rhs().welcome(this);
        mv.visitVarInsn(Opcodes.ASTORE, env.get(var.name()));
      }
      case IndexVariable iv -> {
        if (iv.name() instanceof Variable v) {
          mv.visitVarInsn(Opcodes.ALOAD, env.get(v.name()));
        } else if (iv.name() instanceof FunCall funCall) {
          funCall.welcome(this);
        }
        iv.index().welcome(this);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
        ast.rhs().welcome(this);
        mv.visitInsn(Opcodes.AASTORE);
      }
      case FieldExpression fieldExpression -> {
        if (fieldExpression.expression() instanceof Variable v) {
          mv.visitVarInsn(Opcodes.ALOAD, env.get(v.name()));
          ast.rhs().welcome(this);
          var owner = ((Typ.Ref) v.attributes().typ).name();
          mv.visitFieldInsn(Opcodes.PUTFIELD, owner, fieldExpression.fieldName(),
              fieldExpression.attributes().typ.jvmType());
        } else {
          throw new RuntimeException("Unsuported field expression");
        }
      }
      case null, default -> throw new RuntimeException("internal error");
    }
    return null;
  }


  @Override
  public Void visit(StringLit ast) {
    mv.visitLdcInsn(ast.s());
    return null;
  }

  @Override
  public Void visit(ArithmeticOrLogicalExpression ast) {
    if (ast.op() == Operator.and) {
      var pos = new Label();
      var neg = new Label();
      ast.left().welcome(this);
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
      mv.visitJumpInsn(Opcodes.IFEQ, neg);
      ast.right().welcome(this);
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
      mv.visitJumpInsn(Opcodes.IFEQ, neg);
      mv.visitInsn(Opcodes.ICONST_1);
      mv.visitJumpInsn(Opcodes.GOTO, pos);
      mv.visitLabel(neg);
      mv.visitInsn(Opcodes.ICONST_0);
      mv.visitLabel(pos);
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
      return null;
    }

    if (ast.op() == Operator.or) {
      var pos = new Label();
      var neg = new Label();
      ast.left().welcome(this);
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
      mv.visitJumpInsn(Opcodes.IFNE, pos);
      ast.right().welcome(this);
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
      mv.visitJumpInsn(Opcodes.IFNE, pos);
      mv.visitInsn(Opcodes.ICONST_0);
      mv.visitJumpInsn(Opcodes.GOTO, neg);
      mv.visitLabel(pos);
      mv.visitInsn(Opcodes.ICONST_1);
      mv.visitLabel(neg);
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
      return null;
    }


    ast.left().welcome(this);
    if (ast.left().attributes().typ.equals(BOXED_INT)) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
    }
    ast.right().welcome(this);
    if (ast.right().attributes().typ.equals(BOXED_INT)) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
    }
    mv.visitInsn(jvmOp(ast.op()));

    if (ast.op().compare) {
      var end = new Label();
      var ifCase = new Label();
      mv.visitJumpInsn(switch (ast.op()) {
            case lt -> Opcodes.IFLT;
            case le -> Opcodes.IFLE;
            case ge -> Opcodes.IFGE;
            case gt -> Opcodes.IFGT;
            case eq -> Opcodes.IFEQ;
            case neq -> Opcodes.IFNE;
            default -> throw new RuntimeException("internal error");
          }
          , ifCase);
      mv.visitInsn(Opcodes.ICONST_0);
      mv.visitJumpInsn(Opcodes.GOTO, end);
      mv.visitLabel(ifCase);
      mv.visitInsn(Opcodes.ICONST_1);
      mv.visitLabel(end);
    } else {
      if (ast.left().attributes().typ.equals(BOXED_INT) && ast.right().attributes().typ.equals(BOXED_INT)) {
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
      } else if (ast.left().attributes().typ.equals(BOXED_BOOLEAN) && ast.right().attributes().typ.equals(BOXED_BOOLEAN)) {
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
      }
    }
    return null;
  }

  @Override
  public Void visit(NegationExpression ast) {
    ast.expr().welcome(this);
    if (ast.expr().attributes().typ.equals(BOXED_INT)) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
      mv.visitInsn(Opcodes.INEG);
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
    }
    if (ast.expr().attributes().typ.equals(BOXED_BOOLEAN)) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
      mv.visitInsn(Opcodes.ICONST_1);
      mv.visitInsn(Opcodes.IXOR);
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
    }
    return null;
  }

  @Override
  public Void visit(ReturnExpression ast) {
    if (ast.expr() != null) {
      ast.expr().welcome(this);
    }
    if (ast.expr() == null) {
      mv.visitInsn(Opcodes.RETURN);
      return null;
    }

    if (ast.expr().attributes().typ != null) {
      if (ast.expr() instanceof ComparisonExpression ce) {
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
      }
      mv.visitInsn(Opcodes.ARETURN);
    }
    return null;
  }

  @Override
  public Void visit(FunCall ast) {
    if (ast.lhs() instanceof Variable variable) {
      if (variable.name().equals("printf")) {
        generatePrintf(ast);
        return null;
      }
      ast.args().forEach(arg -> arg.welcome(this));
      StringBuilder jvmArgs = new StringBuilder("(");
      for (var arg : ast.args()) {
        jvmArgs.append(arg.attributes().typ.jvmType());
      }
      jvmArgs.append(")");
      jvmArgs.append(ast.attributes().typ.jvmType());
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, module, variable.name(), jvmArgs.toString(), false);
      return null;
    }

    if (ast.lhs() instanceof FieldExpression fieldExpression) {
      if (fieldExpression.expression().attributes().typ instanceof Typ.Array && fieldExpression.fieldName().equals(
          "len")) {
        fieldExpression.expression().welcome(this);
        mv.visitInsn(Opcodes.ARRAYLENGTH);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        return null;
      }
    }

    return null;
  }

  private void generatePrintf(FunCall ast) {
    mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    ast.args().get(0).welcome(this);
    getStaticPush(ast.args().size() - 1).accept(mv);
    mv.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object");
    if (ast.args().size() > 1) {
      int s = 0;
      for (AST item : ast.args().stream().skip(1).toList()) {
        mv.visitInsn(Opcodes.DUP);
        getStaticPush(s++).accept(mv);
        item.welcome(this);
        mv.visitInsn(Opcodes.AASTORE);
      }
    }
    mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "printf",
        "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;", false);
    mv.visitInsn(Opcodes.POP);
  }

  @Override
  public Void visit(StructDeclaration ast) {
    var conw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    conw.visit(Opcodes.V21, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, ast.name(), null, "java/lang/Object",
        new String[] {"java/io/Serializable"});
    conw.visitSource(module + ".gr", null);

    for (var arg : ast.args()) {
      conw.visitField(Opcodes.ACC_PUBLIC, arg.name(), arg.typ().jvmType(), null, null);
    }
    var argTypes = new StringBuilder("(");
    for (var arg : ast.args()) {
      argTypes.append(arg.typ().jvmType());
    }
    argTypes.append(")V");

    var constr = conw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", argTypes.toString(), null, null);
    constr.visitVarInsn(Opcodes.ALOAD, 0);
    constr.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    var i = 1;
    for (var arg : ast.args()) {
      constr.visitVarInsn(Opcodes.ALOAD, 0);
      constr.visitVarInsn(Opcodes.ALOAD, i);
      constr.visitFieldInsn(Opcodes.PUTFIELD, ast.name(), arg.name(), arg.typ().jvmType());
      i += arg.typ().stackPos();
    }
    constr.visitInsn(Opcodes.RETURN);
    constr.visitMaxs(1, 1);
    constr.visitEnd();


    conw.visitEnd();

    try {
      var out = new FileOutputStream(resultPath + "/" + ast.name() + ".class");
      out.write(conw.toByteArray());
      out.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return null;
  }

  @Override
  public Void visit(FieldExpression ast) {
    String owner = null;
    if (ast.expression() instanceof Variable v) {
      mv.visitVarInsn(Opcodes.ALOAD, env.get(v.name()));
      owner = ((Typ.Ref) v.attributes().typ).name();
    } else if (ast.expression() instanceof FunCall funCall) {
      funCall.welcome(this);
      owner = ((Typ.Ref) funCall.attributes().typ).name();
    }
    mv.visitFieldInsn(Opcodes.GETFIELD, owner, ast.fieldName(), ast.attributes().typ.jvmType());
    return null;
  }

  @Override
  public Void visit(IfExpression ast) {
    var end = new Label();
    var ifCase = new Label();
    ast.cond().welcome(this);
    mv.visitJumpInsn(Opcodes.IFNE, ifCase);
    ast.elseCase().ifPresent(ec -> ec.welcome(this));
    mv.visitJumpInsn(Opcodes.GOTO, end);
    mv.visitLabel(ifCase);
    ast.trueCase().welcome(this);
    mv.visitLabel(end);
    return null;
  }

  @Override
  public Void visit(LoopExpression ast) {
    var end = new Label();
    endLabels.push(end);
    var start = new Label();
    startLabels.push(start);
    mv.visitLabel(start);
    ast.cond().welcome(this);
    mv.visitJumpInsn(Opcodes.IFEQ, end);
    ast.body().welcome(this);
    mv.visitJumpInsn(Opcodes.GOTO, start);
    mv.visitLabel(end);
    return null;
  }

  @Override
  public Void visit(BreakExpression ast) {
    if (!endLabels.isEmpty()) {
      Label endLabel = endLabels.peek();
      mv.visitJumpInsn(Opcodes.GOTO, endLabel);
    } else {
      System.out.println("Error: break statement outside of loop");
    }
    return null;
  }

  @Override
  public Void visit(ContinueExpression ast) {
    if (!startLabels.isEmpty()) {
      Label startLabel = startLabels.peek();
      mv.visitJumpInsn(Opcodes.GOTO, startLabel);
    } else {
      System.out.println("Error: continue statement outside of loop");
    }
    return null;
  }

  @Override
  public Void visit(ComparisonExpression ast) {
    boolean leftNull = false;
    boolean rightNull = false;
    if (!(ast.left() instanceof Null)) {
      ast.left().welcome(this);
      if ((!ast.op().equals(eq) && !ast.op().equals(neq)) && ast.left().attributes().typ.equals(BOXED_INT)) {
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
      }
    } else {
      leftNull = true;
    }

    if (!(ast.right() instanceof Null)) {
      ast.right().welcome(this);
      if ((!ast.op().equals(eq) && !ast.op().equals(neq)) && ast.right().attributes().typ.equals(BOXED_INT)) {
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
      }
    } else {
      rightNull = true;
    }

    var end = new Label();
    var ifCase = new Label();
    if (ast.op().compare) {
      int i = (leftNull || rightNull) ? jvmOpNullCmp(ast.op()) : jvmOp(ast.op());
      mv.visitJumpInsn(i, ifCase);
    }

    mv.visitInsn(Opcodes.ICONST_0);
    mv.visitJumpInsn(Opcodes.GOTO, end);
    mv.visitLabel(ifCase);
    mv.visitInsn(Opcodes.ICONST_1);
    mv.visitLabel(end);
    //mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);

    return null;
  }

  @Override
  public Void visit(StructCall ast) {
    mv.visitTypeInsn(Opcodes.NEW, ast.name());
    mv.visitInsn(Opcodes.DUP);
    ast.args().forEach(arg -> arg.welcome(this));
    StringBuilder descriptor = new StringBuilder("(");
    for (var arg : ast.args()) {
      descriptor.append(arg.attributes().typ.jvmType());
    }
    descriptor.append(")V");
    mv.visitMethodInsn(Opcodes.INVOKESPECIAL, ast.name(), "<init>", descriptor.toString(), false);
    return null;
  }

  @Override
  public Void visit(ArrayExpression ast) {
    //int opCode = getStaticPushOpCode(ast.items().size());
    //var opCode = ast.items().size() < 127 ? Opcodes.BIPUSH : Opcodes.SIPUSH;
    getStaticPush(ast.items().size()).accept(mv);
    //mv.visitIntInsn(opCode, ast.items().size());

    Typ typ = ((Typ.Array) ast.attributes().typ).typ();
    if (typ instanceof Typ.Ref ref) {
      mv.visitTypeInsn(Opcodes.ANEWARRAY, ref.name());
    } else {
      mv.visitTypeInsn(Opcodes.ANEWARRAY, typ.jvmType());
    }

    int s = 0;
    for (AST item : ast.items()) {
      mv.visitInsn(Opcodes.DUP);
      //mv.visitIntInsn(opCode, s++);
      getStaticPush(s++).accept(mv);
      item.welcome(this);
      mv.visitInsn(Opcodes.AASTORE);
    }

    return null;
  }

  private Consumer<MethodVisitor> getStaticPush(Integer val) {
    return mv -> {
      switch (val) {
        case -1 -> mv.visitInsn(Opcodes.ICONST_M1);
        case 0 -> mv.visitInsn(Opcodes.ICONST_0);
        case 1 -> mv.visitInsn(Opcodes.ICONST_1);
        case 2 -> mv.visitInsn(Opcodes.ICONST_2);
        case 3 -> mv.visitInsn(Opcodes.ICONST_3);
        case 4 -> mv.visitInsn(Opcodes.ICONST_4);
        case 5 -> mv.visitInsn(Opcodes.ICONST_5);
        default -> {
          if (val >= -128 && val <= 127) {
            mv.visitIntInsn(Opcodes.BIPUSH, val);
          } else if (val >= -32768 && val <= 32767) {
            mv.visitIntInsn(Opcodes.SIPUSH, val);
          } else {
            mv.visitLdcInsn(val);
          }
        }
      }
    };
  }

  @Override
  public Void visit(IndexVariable ast) {
    if (ast.name() instanceof Variable v) {
      mv.visitVarInsn(Opcodes.ALOAD, env.get(v.name()));
    } else if (ast.name() instanceof FunCall funCall) {
      funCall.welcome(this);
    }
    ast.index().welcome(this);
    // TODO do attributes check instead maybe
    if (!(ast.index() instanceof IntegerInteger)) {
      mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
    }
    mv.visitInsn(Opcodes.AALOAD);
    return null;
  }

  @Override
  public Void visit(Null nil) {
    mv.visitInsn(Opcodes.ACONST_NULL);
    return null;
  }

  @Override
  public Void visit(GroupedExpression groupedExpression) {
    groupedExpression.expr().welcome(this);
    return null;
  }

  @Override
  public Void visit(BooleanBoolean booleanBoolean) {
    mv.visitInsn(booleanBoolean.n() ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
    mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
    return null;
  }

  @Override
  public Void visit(IntegerInteger ast) {
    if (ast.n() == null) {
      mv.visitInsn(Opcodes.ACONST_NULL);
      return null;
    }
    getStaticPush(ast.n()).accept(mv);
    if (ast.attributes().needsBoxing) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
    }
    return null;
  }


  private static int jvmOp(Operator op) {
    return switch (op) {
      case mul -> Opcodes.IMUL;
      case add -> Opcodes.IADD;
      case sub -> Opcodes.ISUB;
      case div -> Opcodes.IDIV;
      case mod -> Opcodes.IREM;
      case lt -> Opcodes.IF_ICMPLT;
      case le -> Opcodes.IF_ICMPLE;
      case ge -> Opcodes.IF_ICMPGE;
      case gt -> Opcodes.IF_ICMPGT;
      case eq -> Opcodes.IF_ACMPEQ;
      case neq -> Opcodes.IF_ACMPNE;
      default -> 0;
    };
  }

  private static int jvmOpNullCmp(Operator op) {
    return switch (op) {
      case eq -> Opcodes.IFNULL;
      case neq -> Opcodes.IFNONNULL;
      default -> 0;
    };
  }


}
