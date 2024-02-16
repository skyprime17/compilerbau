package org.compilerbau;

import static org.compilerbau.ast.Typ.BOXED_VOID;

import java.util.HashMap;
import java.util.Map;

import org.compilerbau.ast.AST;
import org.compilerbau.ast.Arg;
import org.compilerbau.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.ast.ArrayExpression;
import org.compilerbau.ast.Assign;
import org.compilerbau.ast.Block;
import org.compilerbau.ast.BooleanBoolean;
import org.compilerbau.ast.BreakExpression;
import org.compilerbau.ast.ComparisonExpression;
import org.compilerbau.ast.ContinueExpression;
import org.compilerbau.ast.FieldExpression;
import org.compilerbau.ast.FunCall;
import org.compilerbau.ast.FunDef;
import org.compilerbau.ast.GroupedExpression;
import org.compilerbau.ast.IfExpression;
import org.compilerbau.ast.IndexVariable;
import org.compilerbau.ast.IntegerInteger;
import org.compilerbau.ast.Item;
import org.compilerbau.ast.LoopExpression;
import org.compilerbau.ast.NegationExpression;
import org.compilerbau.ast.Null;
import org.compilerbau.ast.Program;
import org.compilerbau.ast.ReturnExpression;
import org.compilerbau.ast.StringLit;
import org.compilerbau.ast.StructCall;
import org.compilerbau.ast.StructDeclaration;
import org.compilerbau.ast.TheTyp;
import org.compilerbau.ast.TheVisibility;
import org.compilerbau.ast.Typ;
import org.compilerbau.ast.Variable;
import org.compilerbau.ast.Visitor;

public class TypCheck implements Visitor<Boolean> {
  private Map<String, Typ> env = new HashMap<>();
  private final Map<String, Item> funs = new HashMap<>();


  //private final static Map<String, FunDef> standardLibFuns = new HashMap<>();
  private FunDef currentFunctionResult;

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
      result &= fun.welcome(this);
    }
    return result;
  }

  @Override
  public Boolean visit(FunDef ast) {
    env = new HashMap<>();
    currentFunctionResult = ast;
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
      throw new RuntimeException("Type not resolved");
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
      Boolean welcome = st.welcome(this);
      r &= welcome;
    }

    ast.attributes().typ = BOXED_VOID;
    return r;
  }

  @Override
  public Boolean visit(Assign ast) {
    var r = ast.rhs().welcome(this);
    if (!r) {
      return false;
    }

    switch (ast.var()) {
      case Variable var -> {
        if (var.init() && env.get(var.name()) != null) {
          System.out.println("Variable already defined in this scope: " + var.name());
          return false;
        } else if (!var.init()) {
          var oldTyp = env.get(var.name());
          if (oldTyp == null) {
            System.out.println("Cannot resolve symbol: " + var.name());
            return false;
          }
          boolean mutable = ast.var().attributes().mutable;
          // check if variable is mutable
          //if (!mutable) {
          //  System.out.println("Variable is not mutable: " + var.name());
          //  return false;
          // }
        }

        var rtAttr = ast.rhs().attributes();
        var rt = rtAttr.typ;
        var oldTyp = env.get(var.name());
        if (oldTyp != null && !oldTyp.equals(rt)) {
          System.out.println("Variable type does not match rhs type");
          return false;
        }

        var typeHint = var.attributes().typ;
        var typeHintNullable = var.attributes().nullable;

        if (ast.rhs() instanceof Null) {
          if (typeHint == null || typeHint instanceof Typ.Unknown) {
            System.out.println("Variable with null needs type hint as it cannot be inferred");
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

        if (!typeHintNullable && rtAttr.nullable) {
          System.out.println("Variable is nullable but rhs is not");
          return false;
        }


      }
      case IndexVariable iv -> {
        var indexExpr = iv.index().welcome(this);
        if (!indexExpr) {
          return false;
        }
        var rt = ast.rhs().attributes().typ;
        iv.name().welcome(this);
        Typ oldTyp = null;
        if (iv.name() instanceof Variable v) {
          oldTyp = env.get(v.name());
        } else if (iv.name() instanceof FunCall f) {
          oldTyp = f.attributes().typ;
        }

        if (oldTyp == null) {
          return false;
        }
        var oldIndexTyp = ((Typ.Array) oldTyp).typ();
        if (!oldIndexTyp.equals(rt)) {
          return false;
        }
        iv.attributes().typ = rt;
        //env.put(iv.name(), rt);
      }
      case FieldExpression fieldExpression -> {
        var field = fieldExpression.welcome(this);
        if (!field) {
          return false;
        }
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
      }
      case null, default -> {
      }
    }

    return true;
  }

  @Override
  public Boolean visit(IntegerInteger ast) {
    if (ast.attributes().typ.equals(Typ.BOXED_INT)) {
      return true;
    }
    ast.attributes().typ = Typ.BOXED_INT;
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
    if (ast.expr() != null) {
      ast.expr().welcome(this);
    }
    Typ currentFunctionResult = this.currentFunctionResult.typ();

    if (ast.expr() == null && !currentFunctionResult.equals(Typ.BOXED_VOID)) {
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
      return false;
    }
    ast.attributes().typ = currentFunctionResult;

    if (ast.expr() instanceof Null) {
      if (!this.currentFunctionResult.attributes().nullable && !this.currentFunctionResult.typ().equals(Typ.BOXED_VOID)) {
        System.out.println("Invalid return type. Expected non-nullable type");
        return false;
      }
    }
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
      ast.attributes().nullable = fun.attributes().nullable;

      // compare types
      for (int i = 0; i < ast.args().size(); i++) {
        var arg = ast.args().get(i);
        var argTyp = arg.attributes().typ;
        var funArg = fun.args().get(i);
        var funArgTyp = funArg.typ();

        if (funArg.attributes().mutable != arg.attributes().mutable) {
          System.out.println("Argument mutability does not match function argument mutability. Expected: " + funArg.attributes().mutable + " but got: " + arg.attributes().mutable);
          return false;
        }

        // check if null is an argument
        if (arg instanceof Null s) {
          if (!funArg.attributes().nullable) {
            System.out.println("Arg: " + funArg.name() + " is not nullable");
            return false;
          }
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
          ast.attributes().typ = Typ.BOXED_INT;
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
    ast.attributes().typ = BOXED_VOID;
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
    Typ typ = null;
    if (ast.name() instanceof  Variable var) {
      typ = env.get(var.name());
    } else if (ast.name() instanceof FunCall fc) {
      fc.welcome(this);
      typ = fc.attributes().typ;
    }
    boolean r = ast.index().welcome(this);
    if (!r) {
      return false;
    }
    if (typ instanceof Typ.Array) {
      ast.attributes().typ = ((Typ.Array) typ).typ();
      ast.index().attributes().needsBoxing = false;
      return true;
    }
    System.out.println("Variable is not an array");
    return false;
  }

  @Override
  public Boolean visit(Null nil) {
    nil.attributes().nullable = true;
    return true;
  }

  @Override
  public Boolean visit(GroupedExpression groupedExpression) {
    return groupedExpression.expr().welcome(this);
  }

  @Override
  public Boolean visit(BooleanBoolean booleanBoolean) {
    return true;
  }
}
