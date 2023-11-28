package org.compilerbau.antlr.ast;

import java.util.List;

public record Block(Attributes attributes, List<AST> statements) implements AST {
  public Block(List<AST> statements) {
    this(new Attributes(), statements);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return true;
  }
}