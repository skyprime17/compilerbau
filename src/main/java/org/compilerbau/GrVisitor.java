// Generated from D:/IdeaProjects/compilerbau/compilerbau/src/main/java/org/compilerbau/antlr/Gr.g4 by ANTLR 4.13.1
package org.compilerbau;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(GrParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#fundef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFundef(GrParser.FundefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#structdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructdef(GrParser.StructdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#structfield}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructfield(GrParser.StructfieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#visbility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisbility(GrParser.VisbilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GrParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(GrParser.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(GrParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionWithBlock_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithBlock_(GrParser.ExpressionWithBlock_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpression(GrParser.IndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(GrParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakExpression(GrParser.BreakExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticOrLogicalExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOrLogicalExpression(GrParser.ArithmeticOrLogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldExpression(GrParser.FieldExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(GrParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(GrParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueExpression(GrParser.ContinueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(GrParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundAssignmentExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAssignmentExpression(GrParser.CompoundAssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression_(GrParser.LiteralExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(GrParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructExpression_}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExpression_(GrParser.StructExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpression(GrParser.NegationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(GrParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LazyBooleanExpression}
	 * labeled alternative in {@link GrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLazyBooleanExpression(GrParser.LazyBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(GrParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#compoundAssignOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAssignOperator(GrParser.CompoundAssignOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#expressionWithBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithBlock(GrParser.ExpressionWithBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#blockExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpression(GrParser.BlockExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(GrParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#arrayElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElements(GrParser.ArrayElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#structExprStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExprStruct(GrParser.StructExprStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#structExprFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExprFields(GrParser.StructExprFieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#structExprField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExprField(GrParser.StructExprFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#callParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParams(GrParser.CallParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#loopExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopExpression(GrParser.LoopExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#predicateLoopExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateLoopExpression(GrParser.PredicateLoopExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(GrParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(GrParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GrParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(GrParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#slicetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlicetype(GrParser.SlicetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(GrParser.LiteralExpressionContext ctx);
}