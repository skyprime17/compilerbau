package org.compilerbau.antlr.ast;

public interface AST {

  Attributes attributes();

  <R> R welcome(Visitor<R> vis);

}
