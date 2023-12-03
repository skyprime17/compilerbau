package org.compilerbau.antlr.ast;

import java.util.Optional;

public record IfExpression(Attributes attributes, AST cond, AST trueCase, Optional<AST> elseCase) implements AST {
  public IfExpression(AST cond, AST trueCase, AST elseCase) {
    this(new Attributes(), cond, trueCase, Optional.of(elseCase));
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return true;
  }
}
