package org.compilerbau.antlr.ast;

import java.util.List;

public sealed interface Item permits FunDef, StructDeclaration {
  String name();

  List<Arg> args();

  Typ typ();

  <R> R welcome(Visitor<R> vis);
}