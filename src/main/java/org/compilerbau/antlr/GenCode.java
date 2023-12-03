package org.compilerbau.antlr;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.Void;
import java.util.HashMap;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.compilerbau.antlr.ast.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.compilerbau.antlr.ast.Typ.*;

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
  public Void visit(BinOp ast) {
    ast.left().welcome(this);
    ast.right().welcome(this);
    mv.visitInsn(Opcodes.LADD);
    return null;
  }

  @Override
  public Void visit(UnaryOp ast) {
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
    } else {
      throw new RuntimeException("Unknown return type");
    }
    return null;
  }

  @Override
  public Void visit(FunCall ast) {
    ast.args().forEach(arg -> arg.welcome(this));
    // TOOD descriptor is hardcoded to be 2 integers that return an integer
    mv.visitMethodInsn(Opcodes.INVOKESTATIC, module, ast.name(), "(JJ)J", false);
    return null;
  }

  @Override
  public Void visit(Struct ast) {
    // create a static inner class
    cw.visitInnerClass(ast.name(), module, ast.name(), Opcodes.ACC_STATIC | Opcodes.ACC_PUBLIC);
    return null;
  }

  @Override
  public Void visit(StructField ast) {
    return null;
  }

  @Override
  public Void visit(IfExpression ast) {
    return null;
  }

  @Override
  public Void visit(LoopExpression ast) {
    return null;
  }
}
