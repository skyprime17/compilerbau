package org.compilerbau.antlr.ast;

public record IntegerInteger(Attributes attributes, int n) implements AST {
  public IntegerInteger(int n) {
    this(new Attributes(), n);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}