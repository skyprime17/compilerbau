package org.compilerbau.antlr.ast;

import java.util.List;

public record FunCall(Attributes attributes, String name, List<AST> args) implements AST {
  public FunCall(String name, List<AST> args) {
    this(new Attributes(), name, args);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}
