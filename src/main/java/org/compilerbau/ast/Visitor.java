package org.compilerbau.ast;

public interface Visitor<R> {

  R visit(Program ast);

  R visit(FunDef ast);

  R visit(Variable ast);

  R visit(Arg ast);

  R visit(TheTyp ast);

  R visit(TheVisibility ast);

  R visit(Block ast);

  R visit(Assign ast);

  R visit(IntegerInteger ast);

  R visit(StringLit ast);

  R visit(ArithmeticOrLogicalExpression ast);

  R visit(NegationExpression ast);

  R visit(ReturnExpression ast);

  R visit(FunCall ast);

  R visit(StructDeclaration ast);

  R visit(FieldExpression ast);

  R visit(IfExpression ast);

  R visit(LoopExpression ast);

  R visit(BreakExpression ast);

  R visit(ContinueExpression ast);

  R visit(ComparisonExpression ast);

  R visit(StructCall ast);
  R visit(ArrayExpression ast);
  R visit(IndexVariable ast);

  R visit(Null nil);

  R visit(GroupedExpression groupedExpression);

  R visit(BooleanBoolean booleanBoolean);
}
