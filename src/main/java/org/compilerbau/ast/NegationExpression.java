package org.compilerbau.ast;

public record NegationExpression(Attributes attributes, Operator op, AST expr) implements AST {
  public NegationExpression(Operator op, AST expr) {
    this(new Attributes(), op, expr);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}