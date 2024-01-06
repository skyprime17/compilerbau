package org.compilerbau.antlr.ast;

public record LongInteger(Attributes attributes, long n) implements AST {
  public LongInteger(long n) {
    this(new Attributes(), n);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}