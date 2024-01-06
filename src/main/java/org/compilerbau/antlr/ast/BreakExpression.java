package org.compilerbau.antlr.ast;

public record BreakExpression(Attributes attributes) implements AST {

  public BreakExpression() {
    this(new Attributes());
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}
