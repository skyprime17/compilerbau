package org.compilerbau.antlr.ast;

public record Variable(Attributes attributes, String name) implements AST {
  public Variable(String name) {
    this(new Attributes(), name);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}