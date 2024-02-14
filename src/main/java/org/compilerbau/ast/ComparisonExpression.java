package org.compilerbau.ast;

public record ComparisonExpression(Attributes attributes, AST left, Operator op, AST right) implements AST {

  public ComparisonExpression(AST left, Operator op, AST right) {
    this(new Attributes(), left, op, right);
  }


  @Override
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }
}
