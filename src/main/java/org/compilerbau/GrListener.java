// Generated from D:/IdeaProjects/compilerbau/compilerbau/src/main/java/org/compilerbau/Gr.g4 by ANTLR 4.13.1
package org.compilerbau;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrParser}.
 */
public interface GrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(GrParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(GrParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#fundef}.
	 * @param ctx the parse tree
	 */
	void enterFundef(GrParser.FundefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#fundef}.
	 * @param ctx the parse tree
	 */
	void exitFundef(GrParser.FundefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#structdef}.
	 * @param ctx the parse tree
	 */
	void enterStructdef(GrParser.StructdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#structdef}.
	 * @param ctx the parse tree
	 */
	void exitStructdef(GrParser.StructdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#structfield}.
	 * @param ctx the parse tree
	 */
	void enterStructfield(GrParser.StructfieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#structfield}.
	 * @param ctx the parse tree
	 */
	void exitStructfield(GrParser.StructfieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#visbility}.
	 * @param ctx the parse tree
	 */
	void enterVisbility(GrParser.VisbilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#visbility}.
	 * @param ctx the parse tree
	 */
	void exitVisbility(GrParser.VisbilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(GrParser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(GrParser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(GrParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(GrParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(GrParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(GrParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionWithBlock_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithBlock_(GrParser.ExpressionWithBlock_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionWithBlock_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithBlock_(GrParser.ExpressionWithBlock_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(GrParser.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(GrParser.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(GrParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(GrParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBreakExpression(GrParser.BreakExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBreakExpression(GrParser.BreakExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticOrLogicalExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOrLogicalExpression(GrParser.ArithmeticOrLogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticOrLogicalExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOrLogicalExpression(GrParser.ArithmeticOrLogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFieldExpression(GrParser.FieldExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFieldExpression(GrParser.FieldExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(GrParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(GrParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(GrParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(GrParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterContinueExpression(GrParser.ContinueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitContinueExpression(GrParser.ContinueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(GrParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(GrParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignmentExpression(GrParser.CompoundAssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignmentExpression(GrParser.CompoundAssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression_(GrParser.LiteralExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression_(GrParser.LiteralExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(GrParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(GrParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStructExpression_(GrParser.StructExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code StructExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStructExpression_(GrParser.StructExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(GrParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(GrParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(GrParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(GrParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LazyBooleanExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLazyBooleanExpression(GrParser.LazyBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LazyBooleanExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLazyBooleanExpression(GrParser.LazyBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(GrParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(GrParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#compoundAssignOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignOperator(GrParser.CompoundAssignOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#compoundAssignOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignOperator(GrParser.CompoundAssignOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#expressionWithBlock}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithBlock(GrParser.ExpressionWithBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#expressionWithBlock}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithBlock(GrParser.ExpressionWithBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#blockExpression}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpression(GrParser.BlockExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#blockExpression}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpression(GrParser.BlockExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(GrParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(GrParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#arrayElements}.
	 * @param ctx the parse tree
	 */
	void enterArrayElements(GrParser.ArrayElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#arrayElements}.
	 * @param ctx the parse tree
	 */
	void exitArrayElements(GrParser.ArrayElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#structExprStruct}.
	 * @param ctx the parse tree
	 */
	void enterStructExprStruct(GrParser.StructExprStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#structExprStruct}.
	 * @param ctx the parse tree
	 */
	void exitStructExprStruct(GrParser.StructExprStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#structExprFields}.
	 * @param ctx the parse tree
	 */
	void enterStructExprFields(GrParser.StructExprFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#structExprFields}.
	 * @param ctx the parse tree
	 */
	void exitStructExprFields(GrParser.StructExprFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#structExprField}.
	 * @param ctx the parse tree
	 */
	void enterStructExprField(GrParser.StructExprFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#structExprField}.
	 * @param ctx the parse tree
	 */
	void exitStructExprField(GrParser.StructExprFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#callParams}.
	 * @param ctx the parse tree
	 */
	void enterCallParams(GrParser.CallParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#callParams}.
	 * @param ctx the parse tree
	 */
	void exitCallParams(GrParser.CallParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpression(GrParser.LoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpression(GrParser.LoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#predicateLoopExpression}.
	 * @param ctx the parse tree
	 */
	void enterPredicateLoopExpression(GrParser.PredicateLoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#predicateLoopExpression}.
	 * @param ctx the parse tree
	 */
	void exitPredicateLoopExpression(GrParser.PredicateLoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(GrParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(GrParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GrParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GrParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#argconvention}.
	 * @param ctx the parse tree
	 */
	void enterArgconvention(GrParser.ArgconventionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#argconvention}.
	 * @param ctx the parse tree
	 */
	void exitArgconvention(GrParser.ArgconventionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void enterArraytype(GrParser.ArraytypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void exitArraytype(GrParser.ArraytypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#slicetype}.
	 * @param ctx the parse tree
	 */
	void enterSlicetype(GrParser.SlicetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#slicetype}.
	 * @param ctx the parse tree
	 */
	void exitSlicetype(GrParser.SlicetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(GrParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(GrParser.LiteralExpressionContext ctx);
}