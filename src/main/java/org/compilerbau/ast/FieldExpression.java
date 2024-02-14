package org.compilerbau.ast;

public record FieldExpression(Attributes attributes, AST expression, String fieldName) implements AST {

  public FieldExpression(AST expression, String fieldName) {
    this(new Attributes(), expression, fieldName);
  }



  @Override
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }
}
