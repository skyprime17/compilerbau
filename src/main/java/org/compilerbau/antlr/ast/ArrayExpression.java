package org.compilerbau.antlr.ast;

import java.util.List;

public record ArrayExpression(Attributes attributes, List<AST> items) implements AST {
  @Override
  public boolean isStructured() {
    return false;
  }

  @Override
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }
}
