package org.compilerbau.ast;

import static org.compilerbau.ast.Typ.ARITH;
import static org.compilerbau.ast.Typ.CMP;
import static org.compilerbau.ast.Typ.LOGIC;

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

  public final Typ.FunTyp typ;
  public final String symbol;
  public final boolean compare;

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