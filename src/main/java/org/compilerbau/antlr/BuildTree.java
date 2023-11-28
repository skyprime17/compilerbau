package org.compilerbau.antlr;


import org.compilerbau.antlr.ast.AST;
import org.compilerbau.antlr.ast.Arg;
import org.compilerbau.antlr.ast.Assign;
import org.compilerbau.antlr.ast.Attributes;
import org.compilerbau.antlr.ast.BinOp;
import org.compilerbau.antlr.ast.Block;
import org.compilerbau.antlr.ast.FunDef;
import org.compilerbau.antlr.ast.Item;
import org.compilerbau.antlr.ast.LongInteger;
import org.compilerbau.antlr.ast.Operator;
import org.compilerbau.antlr.ast.Program;
import org.compilerbau.antlr.ast.StringLit;
import org.compilerbau.antlr.ast.TheTyp;
import org.compilerbau.antlr.ast.TheVisibility;
import org.compilerbau.antlr.ast.Typ;
import org.compilerbau.antlr.ast.UnaryOp;
import org.compilerbau.antlr.ast.Variable;
import org.compilerbau.antlr.ast.Visibility;

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
    return null;
  }

  @Override
  public AST visitVisbility(GrParser.VisbilityContext ctx) {
    var visibility = ctx.getText();
    if (visibility.equals("pub")) {
      return new TheVisibility(new Attributes(), Visibility.PUBLIC);
    }
    return new TheVisibility(new Attributes(), Visibility.PRIVATE);
  }

  @Override
  public AST visitStatement(GrParser.StatementContext ctx) {
    if (ctx.expressionStatement() != null) {
      return visit(ctx.expressionStatement());
    }

    if (ctx.letStatement() != null) {
      GrParser.LetStatementContext letStatementContext = ctx.letStatement();
      var rhs = visit(letStatementContext.expression());
      return new Assign(new Attributes(), letStatementContext.IDENT().getText(), rhs);
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
  public AST visitArithmeticOrLogicalExpression(GrParser.ArithmeticOrLogicalExpressionContext ctx) {

    Operator op = null;
    if (ctx.TIMES() != null) {
      op = Operator.mul;
    } else if(ctx.DIV() != null) {
      op = Operator.div;
    } else if (ctx.MOD() != null){
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

    return new BinOp(new Attributes(), left, op, right);
  }

  @Override
  public AST visitNegationExpression(GrParser.NegationExpressionContext ctx) {
    var op = ctx.NOT() != null ? Operator.not : Operator.sub;
    var right = visit(ctx.expression());
    return new UnaryOp(new Attributes(), op, right);
  }

  @Override
  public AST visitLiteralExpression_(GrParser.LiteralExpression_Context ctx) {
    GrParser.LiteralExpressionContext literalExpressionContext = ctx.literalExpression();
    if (literalExpressionContext == null) {
      return null;
    }
    if (literalExpressionContext.INTEGER_LITERAL() != null) {
      return new LongInteger(Long.parseLong(literalExpressionContext.INTEGER_LITERAL().getText()));
    }

    if (literalExpressionContext.STRING_LITERAL() != null) {
      return new StringLit(new Attributes(), literalExpressionContext.STRING_LITERAL().getText());
    }

    if (literalExpressionContext.identifier() != null) {
      return new Variable(new Attributes(), literalExpressionContext.identifier().getText());
    }


    // KW TRUE / FALSE

    return null;
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
    return new Block(ctx.statements().statement().stream().map(this::visit).toList());
  }

  @Override
  public AST visitLoopExpression(GrParser.LoopExpressionContext ctx) {
    return null;
  }

  @Override
  public AST visitIfExpression(GrParser.IfExpressionContext ctx) {
    return null;
  }

  @Override
  public AST visitParam(GrParser.ParamContext ctx) {
    return new Arg(new Attributes(), ctx.IDENT().getText(), ((TheTyp) visit(ctx.type())).typ());
  }


  @Override
  public AST visitFundef(GrParser.FundefContext ctx) {
    var funcName = ctx.IDENT().getText();
    var visibility = ((TheVisibility) visit(ctx.visbility())).visibility();
    var params = ctx.param().stream().map(p -> (Arg) visit(p)).toList();
    var returnType = ((TheTyp) visit(ctx.type())).typ();
    var body = visit(ctx.blockExpression());
    return new FunDef(new Attributes(), visibility, funcName, params, returnType, body);
  }

  @Override
  public AST visitType(GrParser.TypeContext ctx) {
    var t = ctx.identifier().getText();
    return switch (t) {
      case "int" -> new TheTyp(new Attributes(), new Typ.PrimInt());
      case "boolean" -> new TheTyp(new Attributes(), new Typ.PrimBool());
      default -> new TheTyp(new Attributes(), new Typ.Ref(t));
    };
  }


}
