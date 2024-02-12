package org.compilerbau.antlr.ast;


public record BooleanBoolean(Attributes attributes, Boolean n) implements AST {
  public BooleanBoolean(Boolean n) {
    this(new Attributes(), n);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}