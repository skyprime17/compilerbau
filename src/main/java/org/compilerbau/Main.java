package org.compilerbau;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;

public class Main {
  public static void main(String... args) throws Exception {
    if (args.length != 1) {
      throw new RuntimeException("Usage: Main <inputfile>");
    }
    compile(FileUtils.getFile(args[0]).getParent(), new FileReader(args[0]));
  }

  private static void compile(String resultPath, Reader script) throws IOException {
    var lexer = new GrLexer(CharStreams.fromReader(script));
    var parser = new GrParser(new CommonTokenStream(lexer));
    var antlrTree = parser.start();
    var ast = new BuildTree().visit(antlrTree);
    var typ = ast.welcome(new TypCheck());
    if (!typ) {
      System.out.println("Compilation failed due to type errors");
    }
    ast.welcome(new GenCode(resultPath));
  }

}
