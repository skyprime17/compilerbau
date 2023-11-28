package org.compilerbau.antlr.ast;

public record TheVisibility(Attributes attributes, Visibility visibility) implements AST {
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}