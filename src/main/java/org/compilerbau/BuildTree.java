package org.compilerbau;


import java.util.List;
import java.util.stream.IntStream;

import org.compilerbau.ast.AST;
import org.compilerbau.ast.Arg;
import org.compilerbau.ast.ArithmeticOrLogicalExpression;
import org.compilerbau.ast.ArrayExpression;
import org.compilerbau.ast.Assign;
import org.compilerbau.ast.Attributes;
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
import org.compilerbau.ast.Operator;
import org.compilerbau.ast.Program;
import org.compilerbau.ast.ReturnExpression;
import org.compilerbau.ast.StringLit;
import org.compilerbau.ast.StructCall;
import org.compilerbau.ast.StructDeclaration;
import org.compilerbau.ast.TheTyp;
import org.compilerbau.ast.TheVisibility;
import org.compilerbau.ast.Typ;
import org.compilerbau.ast.Variable;
import org.compilerbau.ast.Visibility;

class BuildTree extends GrBaseVisitor<AST> {

  @Override
  public AST visitStart(GrParser.StartContext ctx) {
    var packageName = ctx.IDENT().getText();
    var items = ctx.item().stream().map(fd -> (Item) visit(fd)).toList();
    return new Program(packageName, items);
  }

  @Override
  public AST visitItem(GrParser.ItemContext ctx) {
    return ctx.structdef() != null ? visit(ctx.structdef()) : visit(ctx.fundef());
  }

  @Override
  public AST visitStructdef(GrParser.StructdefContext ctx) {
    var structName = ctx.IDENT().getText();
    var params = ctx.structfield().stream().map(p -> (Arg) visit(p)).toList();
    var visibility = ctx.visbility() == null ? Visibility.PRIVATE :
        ((TheVisibility) visit(ctx.visbility())).visibility();
    return new StructDeclaration(visibility, structName, params, new Typ.Ref(structName));
  }

  @Override
  public AST visitStructfield(GrParser.StructfieldContext ctx) {
    var name = ctx.IDENT().getText();
    var typ = ((TheTyp) visit(ctx.type())).typ();
    return new Arg(name, typ);
  }


  @Override
  public AST visitVisbility(GrParser.VisbilityContext ctx) {
    var visibility = ctx.getText();
    if (visibility.equals("pub")) {
      return new TheVisibility(Visibility.PUBLIC);
    }
    return new TheVisibility(Visibility.PRIVATE);
  }

  @Override
  public AST visitStatement(GrParser.StatementContext ctx) {
    if (ctx.expressionStatement() != null) {
      return visit(ctx.expressionStatement());
    }

    if (ctx.letStatement() != null) {
      GrParser.LetStatementContext letStatementContext = ctx.letStatement();
      var rhs = visit(letStatementContext.expression());
      GrParser.TypeContext typeHint = letStatementContext.type();
      var attributes = new Attributes();
      if (typeHint != null) {
        TheTyp visit = (TheTyp) visit(typeHint);
        attributes.typ = visit.typ();
        attributes.nullable = visit.nullable();
      }
      attributes.mutable = letStatementContext.KW_MUT() != null;
      return new Assign(new Variable(attributes, letStatementContext.IDENT().getText(), true), rhs);
    }

    if (ctx.item() != null) {
      return visit(ctx.item());
    }

    throw new RuntimeException("Unknown statement");
  }


  @Override
  public AST visitExpressionStatement(GrParser.ExpressionStatementContext ctx) {
    return ctx.expression() != null ? visit(ctx.expression()) : visit(ctx.expressionWithBlock());
  }

  @Override
  public AST visitIndexExpression(GrParser.IndexExpressionContext ctx) {
    var arr = visit(ctx.expression(0));
    var index = visit(ctx.expression(1));
    return new IndexVariable(arr, index);
  }

  @Override
  public AST visitGroupedExpression(GrParser.GroupedExpressionContext ctx) {
    return new GroupedExpression(visit(ctx.expression()));
  }

  @Override
  public AST visitBreakExpression(GrParser.BreakExpressionContext ctx) {
    return new BreakExpression();
  }

  @Override
  public AST visitArithmeticOrLogicalExpression(GrParser.ArithmeticOrLogicalExpressionContext ctx) {

    Operator op = null;
    if (ctx.TIMES() != null) {
      op = Operator.mul;
    } else if (ctx.DIV() != null) {
      op = Operator.div;
    } else if (ctx.MOD() != null) {
      op = Operator.mod;
    } else if (ctx.PLUS() != null) {
      op = Operator.add;
    } else if (ctx.MINUS() != null) {
      op = Operator.sub;
    } else if (ctx.AND() != null) {
      op = Operator.and;
    } else if (ctx.CARET() != null) {
      op = Operator.caret;
    } else if (ctx.OR() != null) {
      op = Operator.or;
    }

    var left = visit(ctx.expression(0));
    var right = visit(ctx.expression(1));

    return new ArithmeticOrLogicalExpression(left, op, right);
  }

  @Override
  public AST visitFieldExpression(GrParser.FieldExpressionContext ctx) {
    var expr = visit(ctx.expression());
    var field = ctx.identifier().getText();
    return new FieldExpression(expr, field);
  }

  @Override
  public AST visitReturnExpression(GrParser.ReturnExpressionContext ctx) {
    if (ctx.expression() == null) {
      return new ReturnExpression(null);
    }
    return new ReturnExpression(visit(ctx.expression()));
  }

  @Override
  public AST visitComparisonExpression(GrParser.ComparisonExpressionContext ctx) {
    Operator op = switch (ctx.comparisonOperator().getText()) {
      case "<" -> Operator.lt;
      case "<=" -> Operator.le;
      case ">" -> Operator.gt;
      case ">=" -> Operator.ge;
      case "==" -> Operator.eq;
      case "!=" -> Operator.neq;
      default -> throw new RuntimeException("Unknown operator");
    };
    var left = visit(ctx.expression(0));
    var right = visit(ctx.expression(1));
    return new ComparisonExpression(left, op, right);
  }

  @Override
  public AST visitContinueExpression(GrParser.ContinueExpressionContext ctx) {
    return new ContinueExpression();
  }

  @Override
  public AST visitAssignmentExpression(GrParser.AssignmentExpressionContext ctx) {
    var lhs = visit(ctx.expression(0));
    var rhs = visit(ctx.expression(1));
    return new Assign(lhs, rhs);
  }

  @Override
  public AST visitCompoundAssignmentExpression(GrParser.CompoundAssignmentExpressionContext ctx) {
    var op = switch (ctx.compoundAssignOperator().getText()) {
      case "+=" -> Operator.add;
      case "-=" -> Operator.sub;
      case "*=" -> Operator.mul;
      case "/=" -> Operator.div;
      case "%=" -> Operator.mod;
      case "^=" -> Operator.caret;
      case "&=" -> Operator.and;
      case "|=" -> Operator.or;
      default -> throw new RuntimeException("Unknown operator");
    };
    var lhs = visit(ctx.expression(0));
    var rhs = visit(ctx.expression(1));
    return new Assign(lhs, new ArithmeticOrLogicalExpression(lhs, op, rhs));
  }

  @Override
  public AST visitNegationExpression(GrParser.NegationExpressionContext ctx) {
    var op = ctx.NOT() != null ? Operator.not : Operator.sub;
    var right = visit(ctx.expression());
    return new NegationExpression(op, right);
  }

  @Override
  public AST visitCallExpression(GrParser.CallExpressionContext ctx) {
    if (ctx.callParams() == null) {
      return new FunCall(visit(ctx.expression()), List.of());
    }

    var callParams = ctx.callParams().expression().stream().map(this::visit).toList();
    var left = visit(ctx.expression());
    return new FunCall(left, callParams);
  }

  @Override
  public AST visitLiteralExpression_(GrParser.LiteralExpression_Context ctx) {
    GrParser.LiteralExpressionContext literalExpressionContext = ctx.literalExpression();
    if (literalExpressionContext == null) {
      return null;
    }
    if (literalExpressionContext.INTEGER_LITERAL() != null) {
      return new IntegerInteger(Integer.parseInt(literalExpressionContext.INTEGER_LITERAL().getText()));
    }

    if (literalExpressionContext.STRING_LITERAL() != null) {
      String text = literalExpressionContext.STRING_LITERAL().getText();
      return new StringLit(text.substring(1, text.length() - 1));
    }

    if (literalExpressionContext.identifier() != null) {
      return new Variable(literalExpressionContext.identifier().getText());
    }

    if (literalExpressionContext.KW_TRUE() != null) {
      var trueKeyword = new BooleanBoolean(true);
      trueKeyword.attributes().typ = Typ.BOXED_BOOLEAN;
      return trueKeyword;
    }

    if (literalExpressionContext.KW_FALSE() != null) {
      var falseKeyword = new BooleanBoolean(false);
      falseKeyword.attributes().typ = Typ.BOXED_BOOLEAN;
      return falseKeyword;
    }

    if (literalExpressionContext.KW_NULL() != null) {
      return new Null();
    }

    return null;
  }

  @Override
  public AST visitStructExpression_(GrParser.StructExpression_Context ctx) {
    return super.visitStructExpression_(ctx);
  }


  @Override
  public AST visitExpressionWithBlock(GrParser.ExpressionWithBlockContext ctx) {
    if (ctx.blockExpression() != null) {
      return visit(ctx.blockExpression());
    }

    if (ctx.loopExpression() != null) {
      return visit(ctx.loopExpression());
    }

    if (ctx.ifExpression() != null) {
      return visit(ctx.ifExpression());
    }

    return null;
  }

  @Override
  public AST visitBlockExpression(GrParser.BlockExpressionContext ctx) {
    if (ctx.statements() == null) {
      return new Block(List.of());
    }
    if (!ctx.statements().statement().isEmpty()) {
      return new Block(ctx.statements().statement().stream().map(this::visit).toList());
    }
    // TODO expressions
    /*
    if (!ctx.statements().expression().isEmpty()) {
      return new Block(List.of(visit(ctx.statements().expression())));
    }
     */
    return new Block(List.of());
  }

  @Override
  public AST visitStructExprStruct(GrParser.StructExprStructContext ctx) {
    var structName = ctx.identifier().getText();
    if (ctx.structExprFields() == null) {
      return new StructCall(structName, List.of());
    }
    var fields = ctx.structExprFields().structExprField().stream().map(this::visit).toList();
    return new StructCall(structName, fields);
  }

 /*
  @Override
  public AST visitStructExprField(GrParser.StructExprFieldContext ctx) {
    //return new Assign( ctx.identifier().getText(), visit(ctx.expression()));
  }
  */

  @Override
  public AST visitPredicateLoopExpression(GrParser.PredicateLoopExpressionContext ctx) {
    return new LoopExpression(visit(ctx.expression()), visit(ctx.blockExpression()));
  }

  @Override
  public AST visitIfExpression(GrParser.IfExpressionContext ctx) {
    var cond = visit(ctx.expression());
    var trueCase = visit(ctx.blockExpression(0));
    var elseCase = ctx.blockExpression(1) != null ? visit(ctx.blockExpression(1)) : ctx.ifExpression() != null ?
        visit(ctx.ifExpression()) : null;
    return new IfExpression(cond, trueCase, elseCase);
  }

  @Override
  public AST visitParam(GrParser.ParamContext ctx) {
    TheTyp typ = ((TheTyp) visit(ctx.type()));
    Attributes attributes = new Attributes();
    attributes.nullable = typ.nullable();
    attributes.mutable = ctx.KW_MUT() != null;
    return new Arg(attributes, ctx.IDENT().getText(), typ.typ());
  }

  @Override
  public AST visitArraytype(GrParser.ArraytypeContext ctx) {
    return super.visitArraytype(ctx);
  }


  @Override
  public AST visitArrayElements(GrParser.ArrayElementsContext ctx) {
    return super.visitArrayElements(ctx);
  }


  @Override
  public AST visitArrayExpression(GrParser.ArrayExpressionContext ctx) {
    if (ctx.arrayElements() == null) {
      return new ArrayExpression(List.of());
    }
    boolean isNormalArray = !ctx.arrayElements().COMMA().isEmpty() || ctx.arrayElements().SEMICOLON() == null;
    if (isNormalArray) {
      var elements = ctx.arrayElements().expression().stream().map(this::visit).toList();
      return new ArrayExpression(elements);
    }
    if (ctx.arrayElements().SEMICOLON() != null) {
      var defaultVal = visit(ctx.arrayElements().expression(0));
      var size = (IntegerInteger) visit(ctx.arrayElements().expression(1));
      var elements = IntStream.range(0, size.n()).mapToObj(i -> defaultVal).toList();
      return new ArrayExpression(elements);
    }

    return null;
  }


  @Override
  public AST visitFundef(GrParser.FundefContext ctx) {
    var funcName = ctx.IDENT().getText();
    var visibility = ctx.visbility() == null ? Visibility.PRIVATE :
        ((TheVisibility) visit(ctx.visbility())).visibility();
    var params = ctx.param().stream().map(p -> (Arg) visit(p)).toList();
    var type = ((TheTyp) visit(ctx.type()));
    var returnType = type.typ();
    var body = visit(ctx.blockExpression());
    var attributes = new Attributes();
    attributes.nullable = type.nullable();
    return new FunDef(attributes, visibility, funcName, params, returnType, body);
  }

  @Override
  public AST visitType(GrParser.TypeContext ctx) {
    if (ctx.slicetype() != null) {
      return visit(ctx.slicetype());
    }
    if (ctx.arraytype() != null) {
      return visit(ctx.arraytype());
    }
    var t = ctx.identifier().getText();
    var nullable = ctx.KW_NULLABLE() != null;
    return switch (ctx.identifier().getText()) {
      case "Int" -> new TheTyp(Typ.BOXED_INT, nullable);
      case "String" -> new TheTyp(Typ.BOXED_STRING, nullable);
      case "Bool" -> new TheTyp(Typ.BOXED_BOOLEAN, nullable);
      case "Void" -> new TheTyp(Typ.BOXED_VOID, nullable);
      default -> new TheTyp(new Typ.Ref(t), nullable);
    };
  }

  @Override
  public AST visitSlicetype(GrParser.SlicetypeContext ctx) {
    if (ctx.type().identifier() != null) {
      var type = switch (ctx.type().identifier().getText()) {
        case "Int" -> Typ.BOXED_INT;
        case "String" -> Typ.BOXED_STRING;
        case "Boolean" -> Typ.BOXED_BOOLEAN;
        case "Void" -> Typ.BOXED_VOID;
        default -> new Typ.Ref(ctx.type().identifier().getText());
      };
      return new TheTyp(new Typ.Array(type), ctx.type().KW_NULLABLE() != null);
    }
    return visit(ctx.type());
  }


}
