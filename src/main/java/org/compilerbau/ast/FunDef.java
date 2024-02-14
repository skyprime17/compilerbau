package org.compilerbau.ast;

import java.util.List;

public record FunDef(Attributes attributes, Visibility visibility, String name, List<Arg> args, Typ typ,
                     AST body) implements AST, Item {

  public FunDef(Visibility visibility, String name, List<Arg> args, Typ typ, AST body) {
    this(new Attributes(), visibility, name, args, typ, body);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}