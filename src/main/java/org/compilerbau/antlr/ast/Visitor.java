package org.compilerbau.antlr.ast;

public interface Visitor<R> {

  R visit(Program ast);

  R visit(FunDef ast);

  R visit(Variable ast);

  R visit(Arg ast);

  R visit(TheTyp ast);

  R visit(TheVisibility ast);

  R visit(Block ast);

  R visit(Assign ast);

  R visit(LongInteger ast);

  R visit(StringLit ast);

  R visit(BinOp ast);

  R visit(UnaryOp ast);
  R visit(ReturnExpression ast);
}
