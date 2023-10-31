package org.compilerbau;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.compilerbau.antlr.ExprLexer;
import org.compilerbau.antlr.ExprParser;

public class Main {
  public static void main(String[] args) throws IOException {
    var reader = new StringReader("1+2+3\n");
    var lexer = new ExprLexer(CharStreams.fromReader(reader));
    var parser = new ExprParser(new CommonTokenStream(lexer));
    var tree = parser.stat();
    var result = new ExprEval().visit(tree);
    System.out.println(result);
  }
}