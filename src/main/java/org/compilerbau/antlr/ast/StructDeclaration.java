package org.compilerbau.antlr.ast;

import java.util.List;

public record StructDeclaration(Attributes attributes, Visibility visibility, String name, List<Arg> args,
                                Typ typ) implements AST, Item {

  public StructDeclaration(Visibility visibility, String name, List<Arg> args, Typ typ) {
    this(new Attributes(), visibility, name, args, typ);
  }


  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}
