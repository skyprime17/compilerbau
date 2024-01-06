package org.compilerbau.antlr.ast;

public record TheTyp(Attributes attributes, Typ typ) implements AST {

  public TheTyp(Typ typ) {
    this(new Attributes(), typ);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}