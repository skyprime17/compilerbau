package org.compilerbau.ast;

public record CompoundAssignmentExpression(Attributes attributes, AST var, Operator op, AST right) implements AST {

  public CompoundAssignmentExpression(AST left, Operator op, AST right) {
    this(new Attributes(), left, op, right);
  }


  @Override
  public <R> R welcome(Visitor<R> vis) {
    return null;
  }
}
