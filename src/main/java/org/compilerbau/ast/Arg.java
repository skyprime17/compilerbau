package org.compilerbau.ast;

public record Arg(Attributes attributes, String name, Typ typ) implements AST {

  public Arg(String name, Typ typ) {
    this(new Attributes(), name, typ);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

}