package org.compilerbau.ast;

public record TheVisibility(Attributes attributes, Visibility visibility) implements AST {

  public TheVisibility(Visibility visibility) {
    this(new Attributes(), visibility);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}