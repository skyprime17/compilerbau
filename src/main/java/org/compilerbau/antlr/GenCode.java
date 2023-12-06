package org.compilerbau.antlr;

import static org.compilerbau.antlr.ast.Typ.BOOLEAN;
import static org.compilerbau.antlr.ast.Typ.INT;
import static org.compilerbau.antlr.ast.Typ.STRING;
import static org.compilerbau.antlr.ast.Typ.VOID;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.compilerbau.antlr.ast.Arg;
import org.compilerbau.antlr.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.antlr.ast.Assign;
import org.compilerbau.antlr.ast.Block;
import org.compilerbau.antlr.ast.BreakExpression;
import org.compilerbau.antlr.ast.ComparisonExpression;
import org.compilerbau.antlr.ast.ContinueExpression;
import org.compilerbau.antlr.ast.FunCall;
import org.compilerbau.antlr.ast.FunDef;
import org.compilerbau.antlr.ast.IfExpression;
import org.compilerbau.antlr.ast.LongInteger;
import org.compilerbau.antlr.ast.LoopExpression;
import org.compilerbau.antlr.ast.NegationExpression;
import org.compilerbau.antlr.ast.Operator;
import org.compilerbau.antlr.ast.Program;
import org.compilerbau.antlr.ast.ReturnExpression;
import org.compilerbau.antlr.ast.StringLit;
import org.compilerbau.antlr.ast.Struct;
import org.compilerbau.antlr.ast.StructField;
import org.compilerbau.antlr.ast.TheTyp;
import org.compilerbau.antlr.ast.TheVisibility;
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
    var gencode = new GenCode(resultPath);
    ast.welcome(gencode);
  }

  private ClassWriter cw;
  private String module;
  private MethodVisitor mv;
  private java.util.Map<String, Integer> env;

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
    env = new HashMap<>();
    int i = 0;
    for (Arg arg : ast.args()) {
      env.put(arg.name(), i);
      i += arg.typ().stackPos();
    }
    ast.body().welcome(this);
    mv.visitMaxs(1, 1);
    mv.visitEnd();
    return null;
  }

  @Override
  public Void visit(Variable ast) {
    mv.visitVarInsn(Opcodes.LLOAD, env.get(ast.name()));
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
    return null;
  }

  @Override
  public Void visit(LongInteger ast) {
    mv.visitLdcInsn(ast.n());
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
    return null;
  }

  @Override
  public Void visit(NegationExpression ast) {
    return null;
  }

  @Override
  public Void visit(ReturnExpression ast) {
    ast.expr().welcome(this);
    // TODO currently returns a long
    if (ast.expr().attributes().typ == INT) {
      mv.visitInsn(Opcodes.LRETURN);
    } else if (ast.expr().attributes().typ == VOID) {
      mv.visitInsn(Opcodes.RETURN);
    } else if (ast.expr().attributes().typ == STRING) {
      mv.visitInsn(Opcodes.ARETURN);
    } else if (ast.expr().attributes().typ == BOOLEAN) {
      mv.visitInsn(Opcodes.IRETURN);
    } else {
      mv.visitInsn(Opcodes.LRETURN);
      //throw new RuntimeException("Unknown return type");
    }
    return null;
  }

  @Override
  public Void visit(FunCall ast) {
    ast.args().forEach(arg -> arg.welcome(this));
    StringBuilder jvmArgs = new StringBuilder("(");
    for (var arg : ast.args()) {
      jvmArgs.append(arg.attributes().typ.jvmType());
    }
    jvmArgs.append(")");
    jvmArgs.append(ast.attributes().typ.jvmType());
    mv.visitMethodInsn(Opcodes.INVOKESTATIC, module, ast.name(), jvmArgs.toString(), false);
    return null;
  }

  @Override
  public Void visit(Struct ast) {
    // create a static inner class
    return null;
  }

  @Override
  public Void visit(StructField ast) {
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
    return null;
  }

  @Override
  public Void visit(BreakExpression ast) {
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
}
