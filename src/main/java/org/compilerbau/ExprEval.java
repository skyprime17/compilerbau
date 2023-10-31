package org.compilerbau;

import org.compilerbau.antlr.ExprBaseVisitor;
import org.compilerbau.antlr.ExprParser;

public class ExprEval extends ExprBaseVisitor<Integer> {

  @Override
  public Integer visitParens(ExprParser.ParensContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public Integer visitAddSub(ExprParser.AddSubContext ctx) {
    int left = visit(ctx.expr(0));
    int right = visit(ctx.expr(1));
    if (ctx.op.getType() == ExprParser.ADD) {
      return left + right;
    }
    return left - right;
  }

  @Override
  public Integer visitInt(ExprParser.IntContext ctx) {
    return Integer.valueOf(ctx.INT().getText());
  }
}
