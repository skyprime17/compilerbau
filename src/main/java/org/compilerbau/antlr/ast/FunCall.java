package org.compilerbau.antlr.ast;

import java.util.List;

public record FunCall(Attributes attributes, AST lhs, List<AST> args) implements AST {
  public FunCall(AST lhs, List<AST> args) {
    this(new Attributes(), lhs, args);
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }


}
