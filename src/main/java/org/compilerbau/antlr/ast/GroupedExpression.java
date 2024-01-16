package org.compilerbau.antlr.ast;

public record GroupedExpression(Attributes attributes, AST expr) implements AST {
  public GroupedExpression(AST expr) {
    this(new Attributes(), expr);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }
}
