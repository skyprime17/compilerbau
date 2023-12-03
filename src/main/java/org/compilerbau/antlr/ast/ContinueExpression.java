package org.compilerbau.antlr.ast;

public record ContinueExpression(Attributes attributes) implements AST {

  public ContinueExpression() {
    this(new Attributes());
  }



  @Override
  public boolean isStructured() {
    return false;
  }

  @Override
  public <R> R welcome(Visitor<R> vis) {
    return null;
  }
}
