package org.compilerbau.antlr.ast;

public record IndexVariable(Attributes attributes, String name, AST index) implements AST {
  public IndexVariable(String name, AST index) {
    this(new Attributes(), name, index);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}