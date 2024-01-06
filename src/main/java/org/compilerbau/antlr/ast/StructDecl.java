package org.compilerbau.antlr.ast;

import java.util.List;

public record StructDecl(Attributes attributes, Visibility visibility, String name, List<Arg> args, Typ typ) implements AST, Item {


  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}
