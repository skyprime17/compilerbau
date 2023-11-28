package org.compilerbau.antlr.ast;

public record ReturnExpression(Attributes attributes, AST expr) implements AST {
  public ReturnExpression(AST expr) {
    this(new Attributes(), expr);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return true;
  }
}