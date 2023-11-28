package org.compilerbau.antlr;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MainMethodGenerator {

  public static byte[] generateMainMethod() {
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V21, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, "YourClass", null, "java/lang/Object", null);

    MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null
        , null);
    mv.visitCode();

    mv.visitInsn(Opcodes.RETURN);
    mv.visitMaxs(0, 0);
    mv.visitEnd();

    cw.visitEnd();

    return cw.toByteArray();
  }

  public static void main(String[] args) throws Exception {
    byte[] bytecode = generateMainMethod();
    java.nio.file.Files.write(java.nio.file.Paths.get("YourClass.class"), bytecode);
  }
}