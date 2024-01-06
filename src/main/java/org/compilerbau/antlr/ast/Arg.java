package org.compilerbau.antlr.ast;

public record Arg(Attributes attributes, String name, Typ typ) implements AST {
  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

}