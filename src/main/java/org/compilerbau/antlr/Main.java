package org.compilerbau.antlr;

import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
  public static void main(String... args) throws Exception {
    if (args.length > 0) {
      compile(new FileReader(args[0]));
    }

  }

  public static Integer compile(String skript) throws Exception {
    return compile(new StringReader(skript));
  }

  public static Integer compile(Reader skript) throws Exception {
    var lexer = new GrLexer(CharStreams.fromReader(skript));
    var parser = new GrParser(new CommonTokenStream(lexer));

    var antlrTree = parser.start();
    var ast = new BuildTree().visit(antlrTree);

    return 0;
  }
}
