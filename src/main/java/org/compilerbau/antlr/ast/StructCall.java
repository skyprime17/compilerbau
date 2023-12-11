package org.compilerbau.antlr.ast;

import java.util.List;

public record StructCall(Attributes attributes, String name, List<AST> args) implements AST {
  public StructCall(String name, List<AST> args) {
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