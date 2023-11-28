package org.compilerbau.antlr.ast;

public record UnaryOp(Attributes attributes, Operator op, AST expr) implements AST {
  public UnaryOp(Operator op, AST expr) {
    this(new Attributes(), op, expr);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}