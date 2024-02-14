package org.compilerbau.ast;

public record LoopExpression(Attributes attributes, AST cond, AST body) implements AST {

  public LoopExpression(AST cond, AST body) {
    this(new Attributes(), cond, body);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}
