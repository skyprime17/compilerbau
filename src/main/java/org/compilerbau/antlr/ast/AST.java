package org.compilerbau.antlr.ast;

public interface AST {

  Attributes attributes();

  boolean isStructured();

  <R> R welcome(Visitor<R> vis);

}
