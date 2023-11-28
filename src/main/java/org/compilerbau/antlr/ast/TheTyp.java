package org.compilerbau.antlr.ast;

public record TheTyp(Attributes attributes, Typ typ) implements AST {
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}