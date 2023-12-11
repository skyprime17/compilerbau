package org.compilerbau.antlr;

import static org.compilerbau.antlr.ast.Typ.VOID;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.compilerbau.antlr.ast.Item;
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
import org.compilerbau.antlr.ast.Typ;
import org.compilerbau.antlr.ast.Variable;
import org.compilerbau.antlr.ast.Visitor;

public class TypCheck implements Visitor<Boolean> {
  private Map<String, Typ> env = new HashMap<>();
  private final Map<String, Typ.FunTyp> funs = new HashMap<>();
  private Typ currentFunctionResult;

  @Override
  public Boolean visit(Program ast) {
    var result = true;
    for (Item item : ast.items()) {
      funs.put(item.name(), new Typ.FunTyp(item.args().stream().map(Arg::typ).collect(Collectors.toList()),
          item.typ()));
    }
    for (var fun : ast.items()) {
      result = fun.welcome(this);
    }
    return result;
  }

  @Override
  public Boolean visit(FunDef ast) {
    env = new HashMap<>();
    currentFunctionResult = ast.typ();
    ast.args().forEach(arg -> env.put(arg.name(), arg.typ()));
    return ast.body().welcome(this);
  }

  @Override
  public Boolean visit(Variable ast) {
    var typ = env.get(ast.name());
    if (null == typ) {
      return false;
    }
    if (typ instanceof Typ.Unknown) {
      //TODO
    }
    ast.attributes().typ = typ;
    return true;
  }

  @Override
  public Boolean visit(Arg ast) {
    return true;
  }

  @Override
  public Boolean visit(TheTyp ast) {
    return true;
  }

  @Override
  public Boolean visit(TheVisibility ast) {
    return true;
  }

  @Override
  public Boolean visit(Block ast) {
    boolean r = true;
    for (var st : ast.statements()) {
      r = r && st.welcome(this);
    }

    ast.attributes().typ = VOID;
    return r;
  }

  @Override
  public Boolean visit(Assign ast) {
    var r = ast.rhs().welcome(this);
    var rt = ast.rhs().attributes().typ;
    var oldTyp = env.get(ast.var());
    if (oldTyp != null && !oldTyp.equals(rt)) {
      return false;
    }
    env.put(ast.var(), rt);
    return r;
  }

  @Override
  public Boolean visit(LongInteger ast) {
    ast.attributes().typ = Typ.INT;
    return true;
  }

  @Override
  public Boolean visit(StringLit ast) {
    return true;
  }

  @Override
  public Boolean visit(ArithmeticOrLogicalExpression ast) {
    var lr = ast.left().welcome(this);
    var rr = ast.right().welcome(this);
    ast.attributes().typ = ast.op().typ.typ();
    return lr && rr;
  }

  @Override
  public Boolean visit(NegationExpression ast) {
    return true;
  }

  @Override
  public Boolean visit(ReturnExpression ast) {
    if (ast.expr() == null && !currentFunctionResult.equals(Typ.VOID)) {
      System.out.println("Return type does not match function type");
      return false;
    }
    if (ast.expr() == null) {
      ast.attributes().typ = currentFunctionResult;
      return true;
    }

    var r = ast.expr().welcome(this);
    if (!ast.expr().attributes().typ.equals(currentFunctionResult)) {
      System.out.println("Return type does not match function type");
    }
    ast.attributes().typ = currentFunctionResult;
    return r;
  }

  @Override
  public Boolean visit(FunCall ast) {
    Typ.FunTyp fun = funs.get(ast.name());
    ast.args().forEach(p -> p.welcome(this));
    if (fun == null) {
      System.out.println("Unknown function: " + ast.name());
      return false;
    }
    ast.attributes().typ = fun.typ();
    if (fun.args().size() != ast.args().size()) {
      System.out.println("Wrong number of arguments for function: " + ast.name());
      return false;
    }
    return true;
  }

  @Override
  public Boolean visit(StructDecl ast) {
    return true;
  }

  @Override
  public Boolean visit(StructField ast) {
    return true;
  }

  @Override
  public Boolean visit(IfExpression ast) {
    var r1 = ast.cond().welcome(this);
    var r2 = ast.trueCase().welcome(this);
    var r3 = true;
    var elseCase = ast.elseCase().orElse(null);
    if (elseCase != null) {
      r3 = elseCase.welcome(this);
    }
    var r4 = true;
    if (elseCase != null) {
      r4 = ast.trueCase().attributes().typ.equals(elseCase.attributes().typ);
    }
    ast.attributes().typ = ast.trueCase().attributes().typ;
    return r1 && r2 && r3 && r4;
  }

  @Override
  public Boolean visit(LoopExpression ast) {
    var cr = ast.cond().welcome(this);
    var br = ast.body().welcome(this);
    ast.attributes().typ = VOID;
    return cr && br;
  }

  @Override
  public Boolean visit(BreakExpression ast) {
    return true;
  }

  @Override
  public Boolean visit(ContinueExpression ast) {
    return true;
  }

  @Override
  public Boolean visit(ComparisonExpression ast) {
    var lr = ast.left().welcome(this);
    var rr = ast.right().welcome(this);
    ast.attributes().typ = ast.op().typ.typ();
    return lr && rr;
  }

  @Override
  public Boolean visit(StructCall ast) {
    return true;
  }
}
