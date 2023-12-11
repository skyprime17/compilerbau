package org.compilerbau.antlr;


import java.util.HashMap;
import java.util.Map;

import org.compilerbau.antlr.ast.Arg;
import org.compilerbau.antlr.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.antlr.ast.Assign;
import org.compilerbau.antlr.ast.Block;
import org.compilerbau.antlr.ast.BreakExpression;
import org.compilerbau.antlr.ast.ComparisonExpression;
import org.compilerbau.antlr.ast.ContinueExpression;
import org.compilerbau.antlr.ast.FunCall;
import org.compilerbau.antlr.ast.FunDef;
import org.compilerbau.antlr.ast.IfExpression;
import org.compilerbau.antlr.ast.LongInteger;
import org.compilerbau.antlr.ast.LoopExpression;
import org.compilerbau.antlr.ast.NegationExpression;
import org.compilerbau.antlr.ast.Program;
import org.compilerbau.antlr.ast.ReturnExpression;
import org.compilerbau.antlr.ast.StringLit;
import org.compilerbau.antlr.ast.StructCall;
import org.compilerbau.antlr.ast.StructDecl;
import org.compilerbau.antlr.ast.StructField;
import org.compilerbau.antlr.ast.TheTyp;
import org.compilerbau.antlr.ast.TheVisibility;
import org.compilerbau.antlr.ast.Variable;
import org.compilerbau.antlr.ast.Visitor;

public class MkStackEnv implements Visitor<Map<String, Integer>> {
  Map<String, Integer> env = new HashMap<>();
  int intervalVarNr;
  int offset = 0;

  @Override
  public Map<String, Integer> visit(Program ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(FunDef ast) {
    ast.args().forEach(arg -> {
      var entry = env.get(arg.name());
      if (null == entry) {
        env.put(arg.name(), offset);
        offset += arg.typ().stackPos();
      }
    });
    intervalVarNr = 0;
    ast.body().welcome(this);
    return env;
  }

  @Override
  public Map<String, Integer> visit(Variable ast) {
    var entry = env.get(ast.name());
    if (null == entry) {
      env.put(ast.name(), offset);
      offset += ast.attributes().typ.stackPos();
    }
    return env;
  }

  @Override
  public Map<String, Integer> visit(Arg ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(TheTyp ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(TheVisibility ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(Block ast) {
    ast.statements().forEach(st -> st.welcome(this));
    return env;
  }

  @Override
  public Map<String, Integer> visit(Assign ast) {
    var entry = env.get(ast.var());
    if (null == entry) {
      env.put(ast.var(), offset);
      offset += ast.attributes().typ.stackPos();
    }

    ast.rhs().welcome(this);
    return env;
  }

  @Override
  public Map<String, Integer> visit(LongInteger ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(StringLit ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(ArithmeticOrLogicalExpression ast) {
    ast.left().welcome(this);
    ast.right().welcome(this);
    return env;
  }

  @Override
  public Map<String, Integer> visit(NegationExpression ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(ReturnExpression ast) {
    if (ast.expr() != null) {
      ast.expr().welcome(this);
    }
    return env;
  }

  @Override
  public Map<String, Integer> visit(FunCall ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(StructDecl ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(StructField ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(IfExpression ast) {
    ast.cond().welcome(this);
    ast.trueCase().welcome(this);
    ast.elseCase().ifPresent(c -> c.welcome(this));
    return env;
  }

  @Override
  public Map<String, Integer> visit(LoopExpression ast) {
    ast.cond().welcome(this);
    ast.body().welcome(this);
    return env;
  }

  @Override
  public Map<String, Integer> visit(BreakExpression ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(ContinueExpression ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(ComparisonExpression ast) {
    return env;
  }

  @Override
  public Map<String, Integer> visit(StructCall ast) {
    return env;
  }
}