package org.compilerbau.antlr.ast;

public record Null(Attributes attributes) implements AST {
  public Null() {
    this(new Attributes());
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}