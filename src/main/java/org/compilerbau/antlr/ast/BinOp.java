package org.compilerbau.antlr.ast;

public record BinOp(Attributes attributes, AST left, Operator op, AST right) implements AST {
  public BinOp(AST left, Operator op, AST right) {
    this(new Attributes(), left, op, right);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}