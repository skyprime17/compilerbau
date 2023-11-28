package org.compilerbau.antlr.ast;

public record StringLit(Attributes attributes, String s) implements AST {
  StringLit(String s) {
    this(new Attributes(), s);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}