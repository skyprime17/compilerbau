package org.compilerbau.antlr.ast;

import java.util.List;

public sealed interface Item permits FunDef, Struct {
  String name();

  List<Arg> args();

  Typ typ();

  <R> R welcome(Visitor<R> vis);
}