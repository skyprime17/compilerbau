package org.compilerbau.ast;

import java.util.List;

public record ArrayExpression(Attributes attributes, List<AST> items) implements AST {

  public ArrayExpression(List<AST> items) {
    this(new Attributes(), items);
  }


  @Override
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }
}
