package org.compilerbau.antlr;

import static org.compilerbau.antlr.ast.Typ.VOID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.compilerbau.antlr.ast.AST;
import org.compilerbau.antlr.ast.Arg;
import org.compilerbau.antlr.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.antlr.ast.ArrayExpression;
import org.compilerbau.antlr.ast.Assign;
import org.compilerbau.antlr.ast.Block;
import org.compilerbau.antlr.ast.BreakExpression;
import org.compilerbau.antlr.ast.ComparisonExpression;
import org.compilerbau.antlr.ast.ContinueExpression;
import org.compilerbau.antlr.ast.FieldExpression;
import org.compilerbau.antlr.ast.FunCall;
import org.compilerbau.antlr.ast.FunDef;
import org.compilerbau.antlr.ast.IfExpression;
import org.compilerbau.antlr.ast.IndexVariable;
import org.compilerbau.antlr.ast.IntegerInteger;
import org.compilerbau.antlr.ast.Item;
import org.compilerbau.antlr.ast.LoopExpression;
import org.compilerbau.antlr.ast.NegationExpression;
import org.compilerbau.antlr.ast.Null;
import org.compilerbau.antlr.ast.Program;
import org.compilerbau.antlr.ast.ReturnExpression;
import org.compilerbau.antlr.ast.StringLit;
import org.compilerbau.antlr.ast.StructCall;
import org.compilerbau.antlr.ast.StructDeclaration;
import org.compilerbau.antlr.ast.TheTyp;
import org.compilerbau.antlr.ast.TheVisibility;
import org.compilerbau.antlr.ast.Typ;
import org.compilerbau.antlr.ast.Variable;
import org.compilerbau.antlr.ast.Visitor;

public class TypCheck implements Visitor<Boolean> {
  private Map<String, Typ> env = new HashMap<>();
  private final Map<String, Item> funs = new HashMap<>();


  //private final static Map<String, FunDef> standardLibFuns = new HashMap<>();
  private Typ currentFunctionResult;

  /*
  static {
   /standardLibFuns.put("println", new Typ.FunTyp(List.of(Typ.INT), Typ.VOID));
  }
   */

  @Override
  public Boolean visit(Program ast) {
    var result = true;
    ast.items().forEach(item -> funs.put(item.name(), item));
    for (var fun : ast.items()) {
      result = fun.welcome(this);
    }
    return result;
  }

  @Override
  public Boolean visit(FunDef ast) {
    env = new HashMap<>();
    currentFunctionResult = ast.typ();
    ast.args().forEach(arg -> {
      arg.welcome(this);
      env.put(arg.name(), arg.typ());
    });
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
    switch (ast.var()) {
      case Variable var -> {
        var r = ast.rhs().welcome(this);
        var rt = ast.rhs().attributes().typ;
        var oldTyp = env.get(var.name());
        if (oldTyp != null && !oldTyp.equals(rt)) {
          return false;
        }
        var typeHint = var.attributes().typ;
        if (ast.rhs() instanceof Null) {
          if (typeHint == null || !typeHint.nullable()) {
            System.out.println("Type=" + typeHint + " is not nullable");
            return false;
          }
          ast.rhs().attributes().typ = typeHint;
          rt = typeHint;
        } else if (!(typeHint instanceof Typ.Unknown) && !typeHint.equals(rt)) {
          System.out.println("Type Hint = " + typeHint + " does not match type of rhs = " + rt);
          return false;
        }
        env.put(var.name(), rt);
        ast.attributes().typ = rt;
        return r;
      }
      case IndexVariable iv -> {
        var indexExpr = iv.index().welcome(this);
        if (!indexExpr) {
          return false;
        }
        var r = ast.rhs().welcome(this);
        var rt = ast.rhs().attributes().typ;
        var oldTyp = env.get(iv.name());
        if (oldTyp == null) {
          return false;
        }
        var oldIndexTyp = ((Typ.Array) oldTyp).typ();
        if (!oldIndexTyp.equals(rt)) {
          return false;
        }
        iv.attributes().typ = rt;
        //env.put(iv.name(), rt);
        return r;
      }
      case FieldExpression fieldExpression -> {
        var field = fieldExpression.welcome(this);
        if (!field) {
          return false;
        }
        var r = ast.rhs().welcome(this);
        var fieldType = ast.rhs().attributes().typ;
        var newType = fieldExpression.attributes().typ;
        if (!fieldType.equals(newType)) {
          System.out.println("Field type does not match");
          return false;
        }
        var oldTyp = env.get(fieldExpression.fieldName());
        if (oldTyp != null && !oldTyp.equals(fieldType)) {
          return false;
        }
        //env.put(fieldExpression.fieldName(), rt);
        ast.attributes().typ = fieldType;
        return r;
      }
      case null, default -> {
      }
    }

    return true;
  }

  @Override
  public Boolean visit(IntegerInteger ast) {
    if (ast.attributes().typ instanceof Typ.PrimBool) {
      return true;
    }
    ast.attributes().typ = Typ.INT;
    return true;
  }

  @Override
  public Boolean visit(StringLit ast) {
    ast.attributes().typ = Typ.BOXED_STRING;
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
    var expr = ast.expr().welcome(this);
    ast.attributes().typ = ast.expr().attributes().typ;
    return expr;
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
    if (ast.expr() instanceof Null n) {
      n.attributes().typ = currentFunctionResult;
    }

    if (!ast.expr().attributes().typ.equals(currentFunctionResult)) {
      System.out.println("Return type does not match function type");
    }
    ast.attributes().typ = currentFunctionResult;
    return r;
  }

  @Override
  public Boolean visit(FunCall ast) {
    if (ast.lhs() instanceof Variable var) {
      var fun = funs.get(var.name());
      if (fun == null) {
        System.out.println("Function notfound: " + var.name());
        return false;
      }
      ast.args().forEach(p -> p.welcome(this));
      ast.attributes().typ = fun.typ();
      if (fun.args().size() != ast.args().size()) {
        System.out.println("Wrong number of arguments for function: " + var.name());
        return false;
      }

      // compare types
      for (int i = 0; i < ast.args().size(); i++) {
        var arg = ast.args().get(i);
        var argTyp = arg.attributes().typ;
        var funArg = fun.args().get(i);
        var funArgTyp = funArg.typ();
        // check if null is an argument
        if (arg instanceof Null s) {
          s.attributes().typ = funArgTyp;
          continue;
        }
        if (!argTyp.equals(funArgTyp)) {
          System.out.println("Argument type does not match function argument type");
          return false;
        }
      }

      return true;
    }

    if (ast.lhs() instanceof FieldExpression fieldExpression) {
      var r = fieldExpression.welcome(this);
      if (!r) {
        return false;
      }
      AST expression = fieldExpression.expression();
      if (expression instanceof Variable var) {
        Boolean visit = visit(var);
        if (!visit) {
          return false;
        }
        var variable = env.get(var.name());
        if (variable == null) {
          System.out.println("Variable not found: " + var.name());
          return false;
        }
        String fieldMethodCallName = fieldExpression.fieldName();
        if (expression.attributes().typ instanceof Typ.Array e && fieldMethodCallName.equals("len")) {
          ast.attributes().typ = Typ.INT;
          return true;
        }
      }
      return true;
    }
    return false;
  }

  @Override
  public Boolean visit(StructDeclaration ast) {
    ast.args().forEach(p -> p.welcome(this));
    return true;
  }

  @Override
  public Boolean visit(FieldExpression ast) {
    // TODO ONLY VARIABLE SUPPORTED RN
    var ok = ast.expression().welcome(this);
    if (!ok) {
      return false;
    }
    if (ast.expression() instanceof Variable var) {
      var variable = env.get(var.name());
      if (variable == null) {
        System.out.println("Variable not found: " + var.name());
        return false;
      }
      if (variable instanceof Typ.Ref ref) {
        var structDecl = (StructDeclaration) funs.get(ref.name());
        if (structDecl == null) {
          System.out.println("Struct not found: " + ref.name());
          return false;
        }
        var field = structDecl.args().stream().filter(p -> p.name().equals(ast.fieldName())).findFirst().orElse(null);
        if (field == null) {
          System.out.println("Field not found: " + ast.fieldName());
          return false;
        }
        ast.attributes().typ = field.typ();
      }
    }
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
    ast.args().forEach(p -> p.welcome(this));
    if (!funs.containsKey(ast.name())) {
      System.out.println("Unknown fundef or structdef: " + ast.name());
      return false;
    }

    // compare types
    for (int i = 0; i < ast.args().size(); i++) {
      var arg = ast.args().get(i);
      var argTyp = arg.attributes().typ;
      var funArg = funs.get(ast.name()).args().get(i);
      var funArgTyp = funArg.typ();
      // check if null is an argument
      if (arg instanceof Null s) {
        s.attributes().typ = funArgTyp;
        continue;
      }
      if (!argTyp.equals(funArgTyp)) {
        System.out.println("Argument type does not match function argument type");
        return false;
      }
    }

    ast.attributes().typ = funs.get(ast.name()).typ();
    return true;
  }

  @Override
  public Boolean visit(ArrayExpression ast) {
    Typ t = null;
    for (AST i : ast.items()) {
      i.welcome(this);
      if (t == null) {
        t = i.attributes().typ;
      } else if (!t.equals(i.attributes().typ)) {
        System.out.println("Array items must have the same type");
      }
    }
    ast.attributes().typ = new Typ.Array(t);
    return true;
  }

  @Override
  public Boolean visit(IndexVariable ast) {
    Typ typ = env.get(ast.name());
    boolean r = ast.index().welcome(this);
    if (!r) {
      return false;
    }
    if (typ instanceof Typ.Array) {
      ast.attributes().typ = ((Typ.Array) typ).typ();
      return true;
    }
    System.out.println("Variable is not an array");
    return false;
  }

  @Override
  public Boolean visit(Null nil) {
    return true;
  }
}
