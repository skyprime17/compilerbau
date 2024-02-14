package org.compilerbau.ast;

public interface AST {

  Attributes attributes();

  <R> R welcome(Visitor<R> vis);

}
