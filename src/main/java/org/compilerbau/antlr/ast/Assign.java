package org.compilerbau.antlr.ast;

public record Assign(Attributes attributes, String var, AST rhs) implements AST {
  Assign(String var, AST rhs) {
    this(new Attributes(), var, rhs);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}