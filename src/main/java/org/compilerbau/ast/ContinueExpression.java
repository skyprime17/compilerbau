package org.compilerbau.ast;

public record ContinueExpression(Attributes attributes) implements AST {

  public ContinueExpression() {
    this(new Attributes());
  }





  @Override
  public <R> R welcome(Visitor<R> vis) {
    return null;
  }
}
