package org.compilerbau.antlr.ast;

public record Assign(Attributes attributes, AST var, AST rhs) implements AST {
  public Assign(AST var, AST rhs) {
    this(new Attributes(), var, rhs);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

}