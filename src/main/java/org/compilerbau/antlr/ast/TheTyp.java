package org.compilerbau.antlr.ast;

public record TheTyp(Attributes attributes, Typ typ, boolean nullable) implements AST {

  public TheTyp(Typ typ, boolean nullable) {
    this(new Attributes(), typ, nullable);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}