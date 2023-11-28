package org.compilerbau.antlr.ast;

import static org.compilerbau.antlr.ast.Typ.ARITH;
import static org.compilerbau.antlr.ast.Typ.CMP;
import static org.compilerbau.antlr.ast.Typ.LOGIC;

public enum Operator {
  add(ARITH, "+", false),
  sub(ARITH, "-", false),
  mul(ARITH, "*", false),
  div(ARITH, "/", false),
  caret(ARITH, "^", false),
  mod(ARITH, "%", false),
  gt(CMP, ">", true),
  lt(CMP, "<", true),
  ge(CMP, ">=", true),
  le(CMP, "<=", true),
  eq(CMP, "==", true),
  neq(CMP, "!=", true),
  pow(ARITH, "^", false),
  and(LOGIC, "&&", false),
  or(LOGIC, "||", false),
  not(LOGIC, "!", false);

  final Typ.FunTyp typ;
  final String symbol;
  final boolean compare;

  Operator(Typ.FunTyp typ, String symbol, boolean compare) {
    this.typ = typ;
    this.symbol = symbol;
    this.compare = compare;
  }

  @Override
  public String toString() {
    return symbol;
  }
}