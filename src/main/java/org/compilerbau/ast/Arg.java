package org.compilerbau.ast;

public record Arg(Attributes attributes, String name, Typ typ, ArgConvention argConvention) implements AST {

  public Arg(String name, Typ typ) {
    this(new Attributes(), name, typ, ArgConvention.INOUT);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

}