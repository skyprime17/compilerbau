package org.compilerbau.ast;

public record IndexVariable(Attributes attributes, AST name, AST index) implements AST {
  public IndexVariable(AST name, AST index) {
    this(new Attributes(), name, index);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}