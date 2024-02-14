package org.compilerbau.ast;

public record ArithmeticOrLogicalExpression(Attributes attributes, AST left, Operator op, AST right) implements AST {
  public ArithmeticOrLogicalExpression(AST left, Operator op, AST right) {
    this(new Attributes(), left, op, right);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

}