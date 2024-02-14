package org.compilerbau.ast;

public record Variable(Attributes attributes, String name, boolean init) implements AST {
  public Variable(String name) {
    this(new Attributes(), name, false);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}