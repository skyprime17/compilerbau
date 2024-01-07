package org.compilerbau.antlr;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.compilerbau.antlr.ast.AST;
import org.compilerbau.antlr.ast.Arg;
import org.compilerbau.antlr.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.antlr.ast.ArrayExpression;
import org.compilerbau.antlr.ast.Assign;
import org.compilerbau.antlr.ast.Block;
import org.compilerbau.antlr.ast.BreakExpression;
import org.compilerbau.antlr.ast.ComparisonExpression;
import org.compilerbau.antlr.ast.ContinueExpression;
import org.compilerbau.antlr.ast.FieldExpression;
import org.compilerbau.antlr.ast.FunCall;
import org.compilerbau.antlr.ast.FunDef;
import org.compilerbau.antlr.ast.IfExpression;
import org.compilerbau.antlr.ast.IndexVariable;
import org.compilerbau.antlr.ast.LongInteger;
import org.compilerbau.antlr.ast.LoopExpression;
import org.compilerbau.antlr.ast.NegationExpression;
import org.compilerbau.antlr.ast.Operator;
import org.compilerbau.antlr.ast.Program;
import org.compilerbau.antlr.ast.ReturnExpression;
import org.compilerbau.antlr.ast.StringLit;
import org.compilerbau.antlr.ast.StructCall;
import org.compilerbau.antlr.ast.StructDeclaration;
import org.compilerbau.antlr.ast.TheTyp;
import org.compilerbau.antlr.ast.TheVisibility;
import org.compilerbau.antlr.ast.Typ;
import org.compilerbau.antlr.ast.Variable;
import org.compilerbau.antlr.ast.Visibility;
import org.compilerbau.antlr.ast.Visitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class GenCode implements Visitor<Void> {

  private final String resultPath;

  public GenCode(String resultPath) {
    this.resultPath = resultPath;
  }

  public static void main(String... args) throws IOException {
    for (var arg : args) {
      compile("D:\\IdeaProjects\\compilerbau\\compilerbau\\gencode", new FileReader(arg));
    }
  }

  static void compile(String resultPath, Reader skript) throws IOException {
    var lexer = new GrLexer(CharStreams.fromReader(skript));
    var parser = new GrParser(new CommonTokenStream(lexer));
    var antlrTree = parser.start();
    var ast = new BuildTree().visit(antlrTree);
    var typ = ast.welcome(new TypCheck());
    if (!typ) {
      throw new RuntimeException("Typcheck failed");
    }
    var gencode = new GenCode(resultPath);
    ast.welcome(gencode);
  }

  private ClassWriter cw;
  private String module;
  private MethodVisitor mv;
  private Map<String, Integer> env;

  private Label end;
  private Label start;

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
    mv.visitVarInsn(loadCode(ast.attributes().typ), env.get(ast.name()));
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
    ast.statements().forEach(s -> s.welcome(this));
    return null;
  }

  @Override
  public Void visit(Assign ast) {
    switch (ast.var()) {
      case Variable var -> {
        ast.rhs().welcome(this);
        mv.visitVarInsn(storeCode(ast.rhs().attributes().typ), env.get(var.name()));
      }
      case IndexVariable iv -> {
        mv.visitVarInsn(Opcodes.ALOAD, env.get(iv.name()));
        iv.index().welcome(this);
        mv.visitInsn(Opcodes.L2I);
        ast.rhs().welcome(this);
        mv.visitInsn(storeArrayCode(iv.attributes().typ));
      }
      case FieldExpression fieldExpression -> {
        if (fieldExpression.expression() instanceof Variable v) {
          mv.visitVarInsn(Opcodes.ALOAD, env.get(v.name()));
          ast.rhs().welcome(this);
          var owner = ((Typ.Ref) v.attributes().typ).name();
          mv.visitFieldInsn(Opcodes.PUTFIELD, owner, fieldExpression.fieldName(), fieldExpression.attributes().typ.jvmType());
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
    ast.left().welcome(this);
    ast.right().welcome(this);
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
    }
    return null;
  }

  @Override
  public Void visit(NegationExpression ast) {
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

    switch (ast.expr().attributes().typ) {
      case Typ.PrimInt p -> mv.visitInsn(Opcodes.LRETURN);
      case Typ.PrimBool b -> mv.visitInsn(Opcodes.IRETURN);
      case Typ.PrimString s -> mv.visitInsn(Opcodes.ARETURN);
      case Typ.Ref r -> mv.visitInsn(Opcodes.ARETURN);
      case Typ.Array a -> mv.visitInsn(Opcodes.ARETURN);
      default -> throw new RuntimeException("Unknown type");
    }
    return null;
  }

  @Override
  public Void visit(FunCall ast) {
    if (ast.lhs() instanceof Variable variable) {
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
        mv.visitInsn(Opcodes.I2L);
        return null;
      }
    }

    return null;
  }

  @Override
  public Void visit(StructDeclaration ast) {
    var conw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    conw.visit(Opcodes.V20, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, ast.name(), null, "java/lang/Object", null);
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
      constr.visitVarInsn(loadCode(arg.typ()), i);
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
    Variable var = (Variable) ast.expression();
    mv.visitVarInsn(Opcodes.ALOAD, env.get(var.name()));
    mv.visitFieldInsn(Opcodes.GETFIELD, var.name(), ast.fieldName(), ast.attributes().typ.jvmType());
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
    end = new Label();
    start = new Label();
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
    mv.visitJumpInsn(Opcodes.GOTO, end);
    return null;
  }

  @Override
  public Void visit(ContinueExpression ast) {
    return null;
  }

  @Override
  public Void visit(ComparisonExpression ast) {
    ast.left().welcome(this);
    ast.right().welcome(this);
    mv.visitInsn(jvmOp(ast.op()));
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
    var opCode = ast.items().size() < 127 ? Opcodes.BIPUSH : Opcodes.SIPUSH;

    mv.visitIntInsn(opCode, ast.items().size());

    Typ typ = ((Typ.Array) ast.attributes().typ).typ();
    if (typ instanceof Typ.Ref ref) {
      mv.visitTypeInsn(Opcodes.ANEWARRAY, ref.name());
    } else {
      mv.visitIntInsn(Opcodes.NEWARRAY, arrayType(typ));
    }

    int s = 0;
    for (AST item : ast.items()) {
      mv.visitInsn(Opcodes.DUP);
      mv.visitIntInsn(opCode, s++);
      item.welcome(this);
      mv.visitInsn(storeArrayCode(item.attributes().typ));
    }

    return null;
  }

  @Override
  public Void visit(IndexVariable ast) {
    mv.visitVarInsn(Opcodes.ALOAD, env.get(ast.name()));
    ast.index().welcome(this);
    mv.visitInsn(Opcodes.L2I);
    mv.visitInsn(loadArrayCode(ast.attributes().typ));
    return null;
  }

  @Override
  public Void visit(LongInteger ast) {
    mv.visitLdcInsn(ast.n());
    return null;
  }


  private static int jvmOp(Operator op) {
    return switch (op) {
      case mul -> Opcodes.LMUL;
      case add -> Opcodes.LADD;
      case sub -> Opcodes.LSUB;
      case div -> Opcodes.LDIV;
      case mod -> Opcodes.LREM;
      case lt, le, ge, gt, eq, neq -> Opcodes.LCMP;
      default -> 0;
    };
  }

  private static int loadCode(Typ t) {
    return switch (t) {
      case Typ.PrimInt p -> Opcodes.LLOAD;
      case Typ.PrimBool b -> Opcodes.ILOAD;
      default -> Opcodes.ALOAD;
    };
  }

  private static int loadArrayCode(Typ t) {
    return switch (t) {
      case Typ.PrimInt p -> Opcodes.LALOAD;
      case Typ.PrimBool b -> Opcodes.IALOAD;
      default -> Opcodes.AALOAD;
    };
  }


  private static int storeArrayCode(Typ t) {
    return switch (t) {
      case Typ.PrimInt p -> Opcodes.LASTORE;
      case Typ.PrimBool b -> Opcodes.IASTORE;
      default -> Opcodes.AASTORE;
    };
  }

  private static int storeCode(Typ t) {
    return switch (t) {
      case Typ.PrimInt p -> Opcodes.LSTORE;
      case Typ.PrimBool b -> Opcodes.ISTORE;
      case Typ.Array a -> Opcodes.ASTORE;
      default -> Opcodes.ASTORE;
    };
  }


  private static int arrayType(Typ t) {
    return switch (t) {
      case Typ.PrimInt p -> Opcodes.T_LONG;
      case Typ.PrimBool b -> Opcodes.T_BOOLEAN;
      default -> throw new IllegalStateException("Unexpected value: " + t);
    };
  }


}
