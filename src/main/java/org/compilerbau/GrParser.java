// Generated from D:/IdeaProjects/compilerbau/compilerbau/src/main/java/org/compilerbau/Gr.g4 by ANTLR 4.13.1
package org.compilerbau;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING_LITERAL=1, INTEGER_LITERAL=2, DEC_LITERAL=3, HEX_LITERAL=4, OCT_LITERAL=5, 
		BIN_LITERAL=6, PLUS=7, MINUS=8, TIMES=9, DIV=10, MOD=11, NE=12, GTE=13, 
		GT=14, LTE=15, LT=16, EQEQ=17, CARET=18, EQ=19, ANDAND=20, OROR=21, OR=22, 
		AND=23, NOT=24, DOT=25, PLUSEQ=26, MINUSEQ=27, STAREQ=28, SLASHEQ=29, 
		PERCENTEQ=30, CARETEQ=31, ANDEQ=32, OREQ=33, LPAR=34, RPAR=35, LBRC=36, 
		RBRC=37, LSQB=38, RSQB=39, COLON=40, SEMICOLON=41, COMMA=42, ARROW=43, 
		KW_PACKAGE=44, KW_BREAK=45, KW_CONTINUE=46, KW_FN=47, KW_IF=48, KW_ELSE=49, 
		KW_WHILE=50, KW_DO=51, KW_THEN=52, KW_RETURN=53, KW_MATCH=54, KW_CASE=55, 
		KW_LET=56, KW_PUBLIC=57, KW_STRUCT=58, KW_TRUE=59, KW_FALSE=60, KW_INOUT=61, 
		KW_BORROWED=62, KW_NULL=63, KW_NULLABLE=64, IDENT=65, NUMBER=66, Alpha=67, 
		Digits=68, WS=69, COMMENT=70, LINE_COMMENT=71;
	public static final int
		RULE_start = 0, RULE_item = 1, RULE_fundef = 2, RULE_fundefReturnType = 3, 
		RULE_structdef = 4, RULE_structfield = 5, RULE_visbility = 6, RULE_receiver = 7, 
		RULE_statement = 8, RULE_letStatement = 9, RULE_expressionStatement = 10, 
		RULE_expression = 11, RULE_comparisonOperator = 12, RULE_compoundAssignOperator = 13, 
		RULE_expressionWithBlock = 14, RULE_blockExpression = 15, RULE_statements = 16, 
		RULE_arrayElements = 17, RULE_structExprStruct = 18, RULE_structExprFields = 19, 
		RULE_structExprField = 20, RULE_callParams = 21, RULE_loopExpression = 22, 
		RULE_predicateLoopExpression = 23, RULE_ifExpression = 24, RULE_identifier = 25, 
		RULE_param = 26, RULE_argconvention = 27, RULE_arraytype = 28, RULE_slicetype = 29, 
		RULE_type = 30, RULE_literalExpression = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "item", "fundef", "fundefReturnType", "structdef", "structfield", 
			"visbility", "receiver", "statement", "letStatement", "expressionStatement", 
			"expression", "comparisonOperator", "compoundAssignOperator", "expressionWithBlock", 
			"blockExpression", "statements", "arrayElements", "structExprStruct", 
			"structExprFields", "structExprField", "callParams", "loopExpression", 
			"predicateLoopExpression", "ifExpression", "identifier", "param", "argconvention", 
			"arraytype", "slicetype", "type", "literalExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'!='", "'>='", "'>'", "'<='", "'<'", "'=='", "'^'", "'='", "'&&'", 
			"'||'", "'|'", "'&'", "'!'", "'.'", "'+='", "'-='", "'*='", "'/='", "'%='", 
			"'^='", "'&='", "'|='", "'('", "')'", "'{'", "'}'", "'['", "']'", "':'", 
			"';'", "','", "'->'", "'package'", "'break'", "'continue'", "'fn'", "'if'", 
			"'else'", "'while'", "'do'", "'then'", "'return'", "'match'", "'case'", 
			"'let'", "'pub'", "'struct'", "'true'", "'false'", "'inout'", "'borrowed'", 
			"'null'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STRING_LITERAL", "INTEGER_LITERAL", "DEC_LITERAL", "HEX_LITERAL", 
			"OCT_LITERAL", "BIN_LITERAL", "PLUS", "MINUS", "TIMES", "DIV", "MOD", 
			"NE", "GTE", "GT", "LTE", "LT", "EQEQ", "CARET", "EQ", "ANDAND", "OROR", 
			"OR", "AND", "NOT", "DOT", "PLUSEQ", "MINUSEQ", "STAREQ", "SLASHEQ", 
			"PERCENTEQ", "CARETEQ", "ANDEQ", "OREQ", "LPAR", "RPAR", "LBRC", "RBRC", 
			"LSQB", "RSQB", "COLON", "SEMICOLON", "COMMA", "ARROW", "KW_PACKAGE", 
			"KW_BREAK", "KW_CONTINUE", "KW_FN", "KW_IF", "KW_ELSE", "KW_WHILE", "KW_DO", 
			"KW_THEN", "KW_RETURN", "KW_MATCH", "KW_CASE", "KW_LET", "KW_PUBLIC", 
			"KW_STRUCT", "KW_TRUE", "KW_FALSE", "KW_INOUT", "KW_BORROWED", "KW_NULL", 
			"KW_NULLABLE", "IDENT", "NUMBER", "Alpha", "Digits", "WS", "COMMENT", 
			"LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Gr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode KW_PACKAGE() { return getToken(GrParser.KW_PACKAGE, 0); }
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(GrParser.EOF, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(KW_PACKAGE);
			setState(65);
			match(IDENT);
			setState(66);
			match(SEMICOLON);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 432486301715922944L) != 0)) {
				{
				{
				setState(67);
				item();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemContext extends ParserRuleContext {
		public FundefContext fundef() {
			return getRuleContext(FundefContext.class,0);
		}
		public StructdefContext structdef() {
			return getRuleContext(StructdefContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				fundef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				structdef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FundefContext extends ParserRuleContext {
		public TerminalNode KW_FN() { return getToken(GrParser.KW_FN, 0); }
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode LPAR() { return getToken(GrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(GrParser.RPAR, 0); }
		public BlockExpressionContext blockExpression() {
			return getRuleContext(BlockExpressionContext.class,0);
		}
		public VisbilityContext visbility() {
			return getRuleContext(VisbilityContext.class,0);
		}
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public FundefReturnTypeContext fundefReturnType() {
			return getRuleContext(FundefReturnTypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrParser.COMMA, i);
		}
		public FundefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fundef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterFundef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitFundef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitFundef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FundefContext fundef() throws RecognitionException {
		FundefContext _localctx = new FundefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fundef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PUBLIC) {
				{
				setState(79);
				visbility();
				}
			}

			setState(82);
			match(KW_FN);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(83);
				receiver();
				}
			}

			setState(86);
			match(IDENT);
			setState(87);
			match(LPAR);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 19L) != 0)) {
				{
				setState(88);
				param();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(89);
					match(COMMA);
					setState(90);
					param();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(98);
			match(RPAR);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(99);
				fundefReturnType();
				}
			}

			setState(102);
			blockExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FundefReturnTypeContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(GrParser.ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FundefReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fundefReturnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterFundefReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitFundefReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitFundefReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FundefReturnTypeContext fundefReturnType() throws RecognitionException {
		FundefReturnTypeContext _localctx = new FundefReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fundefReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ARROW);
			setState(105);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructdefContext extends ParserRuleContext {
		public TerminalNode KW_STRUCT() { return getToken(GrParser.KW_STRUCT, 0); }
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode LBRC() { return getToken(GrParser.LBRC, 0); }
		public List<StructfieldContext> structfield() {
			return getRuleContexts(StructfieldContext.class);
		}
		public StructfieldContext structfield(int i) {
			return getRuleContext(StructfieldContext.class,i);
		}
		public TerminalNode RBRC() { return getToken(GrParser.RBRC, 0); }
		public VisbilityContext visbility() {
			return getRuleContext(VisbilityContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrParser.COMMA, i);
		}
		public StructdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructdefContext structdef() throws RecognitionException {
		StructdefContext _localctx = new StructdefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PUBLIC) {
				{
				setState(107);
				visbility();
				}
			}

			setState(110);
			match(KW_STRUCT);
			setState(111);
			match(IDENT);
			setState(112);
			match(LBRC);
			setState(113);
			structfield();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(114);
				match(COMMA);
				setState(115);
				structfield();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(RBRC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructfieldContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(GrParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VisbilityContext visbility() {
			return getRuleContext(VisbilityContext.class,0);
		}
		public StructfieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structfield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructfield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructfield(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructfield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructfieldContext structfield() throws RecognitionException {
		StructfieldContext _localctx = new StructfieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structfield);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PUBLIC) {
				{
				setState(123);
				visbility();
				}
			}

			setState(126);
			match(IDENT);
			setState(127);
			match(COLON);
			setState(128);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VisbilityContext extends ParserRuleContext {
		public TerminalNode KW_PUBLIC() { return getToken(GrParser.KW_PUBLIC, 0); }
		public VisbilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visbility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterVisbility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitVisbility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitVisbility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisbilityContext visbility() throws RecognitionException {
		VisbilityContext _localctx = new VisbilityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_visbility);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(KW_PUBLIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(GrParser.LPAR, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrParser.RPAR, 0); }
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitReceiver(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitReceiver(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_receiver);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(132);
			match(LPAR);
			setState(133);
			param();
			setState(134);
			match(RPAR);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(SEMICOLON);
				}
				break;
			case KW_FN:
			case KW_PUBLIC:
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				item();
				}
				break;
			case KW_LET:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				letStatement();
				}
				break;
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case MINUS:
			case NOT:
			case LPAR:
			case LBRC:
			case LSQB:
			case KW_BREAK:
			case KW_CONTINUE:
			case KW_IF:
			case KW_WHILE:
			case KW_RETURN:
			case KW_TRUE:
			case KW_FALSE:
			case KW_NULL:
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				expressionStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends ParserRuleContext {
		public TerminalNode KW_LET() { return getToken(GrParser.KW_LET, 0); }
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode EQ() { return getToken(GrParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(GrParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterLetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitLetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_letStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(KW_LET);
			setState(143);
			match(IDENT);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(144);
				match(COLON);
				setState(145);
				type();
				}
			}

			setState(148);
			match(EQ);
			setState(149);
			expression(0);
			setState(150);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public ExpressionWithBlockContext expressionWithBlock() {
			return getRuleContext(ExpressionWithBlockContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressionStatement);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				expression(0);
				setState(153);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				expressionWithBlock();
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(156);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionWithBlock_Context extends ExpressionContext {
		public ExpressionWithBlockContext expressionWithBlock() {
			return getRuleContext(ExpressionWithBlockContext.class,0);
		}
		public ExpressionWithBlock_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterExpressionWithBlock_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitExpressionWithBlock_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitExpressionWithBlock_(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LSQB() { return getToken(GrParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(GrParser.RSQB, 0); }
		public IndexExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterIndexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitIndexExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitIndexExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupedExpressionContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(GrParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrParser.RPAR, 0); }
		public GroupedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterGroupedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitGroupedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitGroupedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakExpressionContext extends ExpressionContext {
		public TerminalNode KW_BREAK() { return getToken(GrParser.KW_BREAK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BreakExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterBreakExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitBreakExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitBreakExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticOrLogicalExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(GrParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(GrParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GrParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(GrParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrParser.MINUS, 0); }
		public TerminalNode AND() { return getToken(GrParser.AND, 0); }
		public TerminalNode CARET() { return getToken(GrParser.CARET, 0); }
		public TerminalNode OR() { return getToken(GrParser.OR, 0); }
		public TerminalNode ANDAND() { return getToken(GrParser.ANDAND, 0); }
		public TerminalNode OROR() { return getToken(GrParser.OROR, 0); }
		public ArithmeticOrLogicalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterArithmeticOrLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitArithmeticOrLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitArithmeticOrLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GrParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FieldExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterFieldExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitFieldExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitFieldExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnExpressionContext extends ExpressionContext {
		public TerminalNode KW_RETURN() { return getToken(GrParser.KW_RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitReturnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitReturnExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueExpressionContext extends ExpressionContext {
		public TerminalNode KW_CONTINUE() { return getToken(GrParser.KW_CONTINUE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ContinueExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterContinueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitContinueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitContinueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(GrParser.EQ, 0); }
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAssignmentExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompoundAssignOperatorContext compoundAssignOperator() {
			return getRuleContext(CompoundAssignOperatorContext.class,0);
		}
		public CompoundAssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterCompoundAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitCompoundAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitCompoundAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExpression_Context extends ExpressionContext {
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public LiteralExpression_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterLiteralExpression_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitLiteralExpression_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitLiteralExpression_(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayExpressionContext extends ExpressionContext {
		public TerminalNode LSQB() { return getToken(GrParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(GrParser.RSQB, 0); }
		public ArrayElementsContext arrayElements() {
			return getRuleContext(ArrayElementsContext.class,0);
		}
		public ArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructExpression_Context extends ExpressionContext {
		public StructExprStructContext structExprStruct() {
			return getRuleContext(StructExprStructContext.class,0);
		}
		public StructExpression_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructExpression_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructExpression_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructExpression_(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(GrParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(GrParser.NOT, 0); }
		public NegationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitNegationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitNegationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(GrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(GrParser.RPAR, 0); }
		public CallParamsContext callParams() {
			return getRuleContext(CallParamsContext.class,0);
		}
		public CallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralExpression_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				literalExpression();
				}
				break;
			case 2:
				{
				_localctx = new NegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(164);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ContinueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(KW_CONTINUE);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(166);
					expression(0);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new BreakExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(KW_BREAK);
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(170);
					expression(0);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new ReturnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(KW_RETURN);
				setState(175);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(174);
					expression(0);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(LPAR);
				setState(178);
				expression(0);
				setState(179);
				match(RPAR);
				}
				break;
			case 7:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(LSQB);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7483469291895914234L) != 0) || _la==IDENT) {
					{
					setState(182);
					arrayElements();
					}
				}

				setState(185);
				match(RSQB);
				}
				break;
			case 8:
				{
				_localctx = new StructExpression_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				structExprStruct();
				}
				break;
			case 9:
				{
				_localctx = new ExpressionWithBlock_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				expressionWithBlock();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(236);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(190);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(191);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(192);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(193);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(194);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(197);
						match(AND);
						setState(198);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(200);
						match(CARET);
						setState(201);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(203);
						match(OR);
						setState(204);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(206);
						comparisonOperator();
						setState(207);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(210);
						match(ANDAND);
						setState(211);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new ArithmeticOrLogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(213);
						match(OROR);
						setState(214);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new AssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(216);
						match(EQ);
						setState(217);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new CompoundAssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(219);
						compoundAssignOperator();
						setState(220);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new FieldExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(223);
						match(DOT);
						setState(224);
						identifier();
						}
						break;
					case 12:
						{
						_localctx = new CallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(226);
						match(LPAR);
						setState(228);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7483469291895914234L) != 0) || _la==IDENT) {
							{
							setState(227);
							callParams();
							}
						}

						setState(230);
						match(RPAR);
						}
						break;
					case 13:
						{
						_localctx = new IndexExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(232);
						match(LSQB);
						setState(233);
						expression(0);
						setState(234);
						match(RSQB);
						}
						break;
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQEQ() { return getToken(GrParser.EQEQ, 0); }
		public TerminalNode NE() { return getToken(GrParser.NE, 0); }
		public TerminalNode GT() { return getToken(GrParser.GT, 0); }
		public TerminalNode LT() { return getToken(GrParser.LT, 0); }
		public TerminalNode GTE() { return getToken(GrParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(GrParser.LTE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAssignOperatorContext extends ParserRuleContext {
		public TerminalNode PLUSEQ() { return getToken(GrParser.PLUSEQ, 0); }
		public TerminalNode MINUSEQ() { return getToken(GrParser.MINUSEQ, 0); }
		public TerminalNode STAREQ() { return getToken(GrParser.STAREQ, 0); }
		public TerminalNode SLASHEQ() { return getToken(GrParser.SLASHEQ, 0); }
		public TerminalNode PERCENTEQ() { return getToken(GrParser.PERCENTEQ, 0); }
		public TerminalNode ANDEQ() { return getToken(GrParser.ANDEQ, 0); }
		public TerminalNode OREQ() { return getToken(GrParser.OREQ, 0); }
		public TerminalNode CARETEQ() { return getToken(GrParser.CARETEQ, 0); }
		public CompoundAssignOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundAssignOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterCompoundAssignOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitCompoundAssignOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitCompoundAssignOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundAssignOperatorContext compoundAssignOperator() throws RecognitionException {
		CompoundAssignOperatorContext _localctx = new CompoundAssignOperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compoundAssignOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17112760320L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionWithBlockContext extends ParserRuleContext {
		public BlockExpressionContext blockExpression() {
			return getRuleContext(BlockExpressionContext.class,0);
		}
		public LoopExpressionContext loopExpression() {
			return getRuleContext(LoopExpressionContext.class,0);
		}
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public ExpressionWithBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionWithBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterExpressionWithBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitExpressionWithBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitExpressionWithBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionWithBlockContext expressionWithBlock() throws RecognitionException {
		ExpressionWithBlockContext _localctx = new ExpressionWithBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionWithBlock);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRC:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				blockExpression();
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				loopExpression();
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				ifExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockExpressionContext extends ParserRuleContext {
		public TerminalNode LBRC() { return getToken(GrParser.LBRC, 0); }
		public TerminalNode RBRC() { return getToken(GrParser.RBRC, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public BlockExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitBlockExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitBlockExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockExpressionContext blockExpression() throws RecognitionException {
		BlockExpressionContext _localctx = new BlockExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(LBRC);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6978923197118807802L) != 0) || _la==IDENT) {
				{
				setState(251);
				statements();
				}
			}

			setState(254);
			match(RBRC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statements);
		int _la;
		try {
			int _alt;
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(256);
						statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7483469291895914234L) != 0) || _la==IDENT) {
					{
					setState(261);
					expression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayElementsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public ArrayElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterArrayElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitArrayElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitArrayElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElementsContext arrayElements() throws RecognitionException {
		ArrayElementsContext _localctx = new ArrayElementsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayElements);
		int _la;
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				expression(0);
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(268);
						match(COMMA);
						setState(269);
						expression(0);
						}
						} 
					}
					setState(274);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(275);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				expression(0);
				setState(279);
				match(SEMICOLON);
				setState(280);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructExprStructContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRC() { return getToken(GrParser.LBRC, 0); }
		public TerminalNode RBRC() { return getToken(GrParser.RBRC, 0); }
		public StructExprFieldsContext structExprFields() {
			return getRuleContext(StructExprFieldsContext.class,0);
		}
		public StructExprStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structExprStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructExprStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructExprStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructExprStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExprStructContext structExprStruct() throws RecognitionException {
		StructExprStructContext _localctx = new StructExprStructContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_structExprStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			identifier();
			setState(285);
			match(LBRC);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(286);
				structExprFields();
				}
			}

			setState(289);
			match(RBRC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructExprFieldsContext extends ParserRuleContext {
		public List<StructExprFieldContext> structExprField() {
			return getRuleContexts(StructExprFieldContext.class);
		}
		public StructExprFieldContext structExprField(int i) {
			return getRuleContext(StructExprFieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrParser.COMMA, i);
		}
		public StructExprFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structExprFields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructExprFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructExprFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructExprFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExprFieldsContext structExprFields() throws RecognitionException {
		StructExprFieldsContext _localctx = new StructExprFieldsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_structExprFields);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			structExprField();
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(292);
					match(COMMA);
					setState(293);
					structExprField();
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			{
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(299);
				match(COMMA);
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructExprFieldContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GrParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructExprFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structExprField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterStructExprField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitStructExprField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitStructExprField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExprFieldContext structExprField() throws RecognitionException {
		StructExprFieldContext _localctx = new StructExprFieldContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_structExprField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(302);
				identifier();
				}
				break;
			case 2:
				{
				{
				setState(303);
				identifier();
				}
				setState(304);
				match(COLON);
				setState(305);
				expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallParamsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrParser.COMMA, i);
		}
		public CallParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterCallParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitCallParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitCallParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallParamsContext callParams() throws RecognitionException {
		CallParamsContext _localctx = new CallParamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_callParams);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			expression(0);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(310);
					match(COMMA);
					setState(311);
					expression(0);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(317);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopExpressionContext extends ParserRuleContext {
		public PredicateLoopExpressionContext predicateLoopExpression() {
			return getRuleContext(PredicateLoopExpressionContext.class,0);
		}
		public LoopExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterLoopExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitLoopExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitLoopExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopExpressionContext loopExpression() throws RecognitionException {
		LoopExpressionContext _localctx = new LoopExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loopExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(320);
			predicateLoopExpression();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateLoopExpressionContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(GrParser.KW_WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockExpressionContext blockExpression() {
			return getRuleContext(BlockExpressionContext.class,0);
		}
		public PredicateLoopExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateLoopExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterPredicateLoopExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitPredicateLoopExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitPredicateLoopExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateLoopExpressionContext predicateLoopExpression() throws RecognitionException {
		PredicateLoopExpressionContext _localctx = new PredicateLoopExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predicateLoopExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(KW_WHILE);
			setState(323);
			expression(0);
			setState(324);
			blockExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExpressionContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(GrParser.KW_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockExpressionContext> blockExpression() {
			return getRuleContexts(BlockExpressionContext.class);
		}
		public BlockExpressionContext blockExpression(int i) {
			return getRuleContext(BlockExpressionContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(GrParser.KW_ELSE, 0); }
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitIfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitIfExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(KW_IF);
			setState(327);
			expression(0);
			setState(328);
			blockExpression();
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(329);
				match(KW_ELSE);
				setState(332);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRC:
					{
					setState(330);
					blockExpression();
					}
					break;
				case KW_IF:
					{
					setState(331);
					ifExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(GrParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgconventionContext argconvention() {
			return getRuleContext(ArgconventionContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INOUT || _la==KW_BORROWED) {
				{
				setState(338);
				argconvention();
				}
			}

			setState(341);
			match(IDENT);
			setState(342);
			match(COLON);
			setState(343);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgconventionContext extends ParserRuleContext {
		public TerminalNode KW_INOUT() { return getToken(GrParser.KW_INOUT, 0); }
		public TerminalNode KW_BORROWED() { return getToken(GrParser.KW_BORROWED, 0); }
		public ArgconventionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argconvention; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterArgconvention(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitArgconvention(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitArgconvention(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgconventionContext argconvention() throws RecognitionException {
		ArgconventionContext _localctx = new ArgconventionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_argconvention);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !(_la==KW_INOUT || _la==KW_BORROWED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArraytypeContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(GrParser.LSQB, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GrParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(GrParser.RSQB, 0); }
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterArraytype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitArraytype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitArraytype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraytypeContext arraytype() throws RecognitionException {
		ArraytypeContext _localctx = new ArraytypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arraytype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(LSQB);
			setState(348);
			type();
			setState(349);
			match(SEMICOLON);
			setState(350);
			expression(0);
			setState(351);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SlicetypeContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(GrParser.LSQB, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(GrParser.RSQB, 0); }
		public SlicetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slicetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterSlicetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitSlicetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitSlicetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlicetypeContext slicetype() throws RecognitionException {
		SlicetypeContext _localctx = new SlicetypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_slicetype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(LSQB);
			setState(354);
			type();
			setState(355);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public SlicetypeContext slicetype() {
			return getRuleContext(SlicetypeContext.class,0);
		}
		public TerminalNode KW_NULLABLE() { return getToken(GrParser.KW_NULLABLE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(357);
				identifier();
				}
				break;
			case 2:
				{
				setState(358);
				arraytype();
				}
				break;
			case 3:
				{
				setState(359);
				slicetype();
				}
				break;
			}
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_NULLABLE) {
				{
				setState(362);
				match(KW_NULLABLE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExpressionContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(GrParser.STRING_LITERAL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(GrParser.INTEGER_LITERAL, 0); }
		public TerminalNode KW_TRUE() { return getToken(GrParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(GrParser.KW_FALSE, 0); }
		public TerminalNode KW_NULL() { return getToken(GrParser.KW_NULL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrListener ) ((GrListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrVisitor ) return ((GrVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literalExpression);
		try {
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				match(STRING_LITERAL);
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				match(INTEGER_LITERAL);
				}
				break;
			case KW_TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				match(KW_TRUE);
				}
				break;
			case KW_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(368);
				match(KW_FALSE);
				}
				break;
			case KW_NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(369);
				match(KW_NULL);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(370);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 21);
		case 11:
			return precpred(_ctx, 20);
		case 12:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001G\u0176\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000E\b\u0000\n\u0000\f\u0000H\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002\u0003\u0002"+
		"Q\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002U\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\\\b\u0002\n\u0002"+
		"\f\u0002_\t\u0002\u0003\u0002a\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"e\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0003\u0004m\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004u\b\u0004\n\u0004\f\u0004"+
		"x\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005}\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u008d\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0093\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u009e\b\n\u0003\n\u00a0\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a8\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00ac\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00b0\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00b8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00bd\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e5\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00ed\b\u000b\n\u000b\f\u000b\u00f0\t\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00f9"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00fd\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0004\u0010\u0102\b\u0010\u000b\u0010\f\u0010"+
		"\u0103\u0001\u0010\u0003\u0010\u0107\b\u0010\u0001\u0010\u0003\u0010\u010a"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u010f\b\u0011"+
		"\n\u0011\f\u0011\u0112\t\u0011\u0001\u0011\u0003\u0011\u0115\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u011b\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0120\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0127\b\u0013\n"+
		"\u0013\f\u0013\u012a\t\u0013\u0001\u0013\u0003\u0013\u012d\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0134"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0139\b\u0015"+
		"\n\u0015\f\u0015\u013c\t\u0015\u0001\u0015\u0003\u0015\u013f\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u014d\b\u0018\u0003\u0018\u014f\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0003\u001a\u0154\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0169\b\u001e"+
		"\u0001\u001e\u0003\u001e\u016c\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0174\b\u001f\u0001\u001f"+
		"\u0000\u0001\u0016 \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0006\u0002\u0000"+
		"\b\b\u0018\u0018\u0001\u0000\t\u000b\u0001\u0000\u0007\b\u0001\u0000\f"+
		"\u0011\u0001\u0000\u001a!\u0001\u0000=>\u0199\u0000@\u0001\u0000\u0000"+
		"\u0000\u0002M\u0001\u0000\u0000\u0000\u0004P\u0001\u0000\u0000\u0000\u0006"+
		"h\u0001\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000\n|\u0001\u0000\u0000"+
		"\u0000\f\u0082\u0001\u0000\u0000\u0000\u000e\u0084\u0001\u0000\u0000\u0000"+
		"\u0010\u008c\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000"+
		"\u0014\u009f\u0001\u0000\u0000\u0000\u0016\u00bc\u0001\u0000\u0000\u0000"+
		"\u0018\u00f1\u0001\u0000\u0000\u0000\u001a\u00f3\u0001\u0000\u0000\u0000"+
		"\u001c\u00f8\u0001\u0000\u0000\u0000\u001e\u00fa\u0001\u0000\u0000\u0000"+
		" \u0109\u0001\u0000\u0000\u0000\"\u011a\u0001\u0000\u0000\u0000$\u011c"+
		"\u0001\u0000\u0000\u0000&\u0123\u0001\u0000\u0000\u0000(\u0133\u0001\u0000"+
		"\u0000\u0000*\u0135\u0001\u0000\u0000\u0000,\u0140\u0001\u0000\u0000\u0000"+
		".\u0142\u0001\u0000\u0000\u00000\u0146\u0001\u0000\u0000\u00002\u0150"+
		"\u0001\u0000\u0000\u00004\u0153\u0001\u0000\u0000\u00006\u0159\u0001\u0000"+
		"\u0000\u00008\u015b\u0001\u0000\u0000\u0000:\u0161\u0001\u0000\u0000\u0000"+
		"<\u0168\u0001\u0000\u0000\u0000>\u0173\u0001\u0000\u0000\u0000@A\u0005"+
		",\u0000\u0000AB\u0005A\u0000\u0000BF\u0005)\u0000\u0000CE\u0003\u0002"+
		"\u0001\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000IJ\u0005\u0000\u0000\u0001J\u0001\u0001\u0000"+
		"\u0000\u0000KN\u0003\u0004\u0002\u0000LN\u0003\b\u0004\u0000MK\u0001\u0000"+
		"\u0000\u0000ML\u0001\u0000\u0000\u0000N\u0003\u0001\u0000\u0000\u0000"+
		"OQ\u0003\f\u0006\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RT\u0005/\u0000\u0000SU\u0003\u000e\u0007\u0000"+
		"TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VW\u0005A\u0000\u0000W`\u0005\"\u0000\u0000X]\u00034\u001a\u0000"+
		"YZ\u0005*\u0000\u0000Z\\\u00034\u001a\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`X\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0005"+
		"#\u0000\u0000ce\u0003\u0006\u0003\u0000dc\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0003\u001e\u000f\u0000"+
		"g\u0005\u0001\u0000\u0000\u0000hi\u0005+\u0000\u0000ij\u0003<\u001e\u0000"+
		"j\u0007\u0001\u0000\u0000\u0000km\u0003\f\u0006\u0000lk\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005:\u0000"+
		"\u0000op\u0005A\u0000\u0000pq\u0005$\u0000\u0000qv\u0003\n\u0005\u0000"+
		"rs\u0005*\u0000\u0000su\u0003\n\u0005\u0000tr\u0001\u0000\u0000\u0000"+
		"ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wy\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0005%\u0000"+
		"\u0000z\t\u0001\u0000\u0000\u0000{}\u0003\f\u0006\u0000|{\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005A\u0000\u0000\u007f\u0080\u0005(\u0000\u0000\u0080\u0081\u0003<"+
		"\u001e\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082\u0083\u00059\u0000"+
		"\u0000\u0083\r\u0001\u0000\u0000\u0000\u0084\u0085\u0005\"\u0000\u0000"+
		"\u0085\u0086\u00034\u001a\u0000\u0086\u0087\u0005#\u0000\u0000\u0087\u000f"+
		"\u0001\u0000\u0000\u0000\u0088\u008d\u0005)\u0000\u0000\u0089\u008d\u0003"+
		"\u0002\u0001\u0000\u008a\u008d\u0003\u0012\t\u0000\u008b\u008d\u0003\u0014"+
		"\n\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008c\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008f\u00058\u0000\u0000"+
		"\u008f\u0092\u0005A\u0000\u0000\u0090\u0091\u0005(\u0000\u0000\u0091\u0093"+
		"\u0003<\u001e\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u0013\u0000\u0000\u0095\u0096\u0003\u0016\u000b\u0000\u0096\u0097\u0005"+
		")\u0000\u0000\u0097\u0013\u0001\u0000\u0000\u0000\u0098\u0099\u0003\u0016"+
		"\u000b\u0000\u0099\u009a\u0005)\u0000\u0000\u009a\u00a0\u0001\u0000\u0000"+
		"\u0000\u009b\u009d\u0003\u001c\u000e\u0000\u009c\u009e\u0005)\u0000\u0000"+
		"\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u0098\u0001\u0000\u0000\u0000"+
		"\u009f\u009b\u0001\u0000\u0000\u0000\u00a0\u0015\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0006\u000b\uffff\uffff\u0000\u00a2\u00bd\u0003>\u001f\u0000"+
		"\u00a3\u00a4\u0007\u0000\u0000\u0000\u00a4\u00bd\u0003\u0016\u000b\u0012"+
		"\u00a5\u00a7\u0005.\u0000\u0000\u00a6\u00a8\u0003\u0016\u000b\u0000\u00a7"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00bd\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005-\u0000\u0000\u00aa\u00ac"+
		"\u0003\u0016\u000b\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00bd\u0001\u0000\u0000\u0000\u00ad\u00af"+
		"\u00055\u0000\u0000\u00ae\u00b0\u0003\u0016\u000b\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00bd\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0005\"\u0000\u0000\u00b2\u00b3\u0003\u0016"+
		"\u000b\u0000\u00b3\u00b4\u0005#\u0000\u0000\u00b4\u00bd\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b7\u0005&\u0000\u0000\u00b6\u00b8\u0003\"\u0011\u0000"+
		"\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bd\u0005\'\u0000\u0000\u00ba"+
		"\u00bd\u0003$\u0012\u0000\u00bb\u00bd\u0003\u001c\u000e\u0000\u00bc\u00a1"+
		"\u0001\u0000\u0000\u0000\u00bc\u00a3\u0001\u0000\u0000\u0000\u00bc\u00a5"+
		"\u0001\u0000\u0000\u0000\u00bc\u00a9\u0001\u0000\u0000\u0000\u00bc\u00ad"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b1\u0001\u0000\u0000\u0000\u00bc\u00b5"+
		"\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00ee\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\n\u0011\u0000\u0000\u00bf\u00c0\u0007\u0001\u0000\u0000\u00c0\u00ed\u0003"+
		"\u0016\u000b\u0012\u00c1\u00c2\n\u0010\u0000\u0000\u00c2\u00c3\u0007\u0002"+
		"\u0000\u0000\u00c3\u00ed\u0003\u0016\u000b\u0011\u00c4\u00c5\n\u000f\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0017\u0000\u0000\u00c6\u00ed\u0003\u0016\u000b"+
		"\u0010\u00c7\u00c8\n\u000e\u0000\u0000\u00c8\u00c9\u0005\u0012\u0000\u0000"+
		"\u00c9\u00ed\u0003\u0016\u000b\u000f\u00ca\u00cb\n\r\u0000\u0000\u00cb"+
		"\u00cc\u0005\u0016\u0000\u0000\u00cc\u00ed\u0003\u0016\u000b\u000e\u00cd"+
		"\u00ce\n\f\u0000\u0000\u00ce\u00cf\u0003\u0018\f\u0000\u00cf\u00d0\u0003"+
		"\u0016\u000b\r\u00d0\u00ed\u0001\u0000\u0000\u0000\u00d1\u00d2\n\u000b"+
		"\u0000\u0000\u00d2\u00d3\u0005\u0014\u0000\u0000\u00d3\u00ed\u0003\u0016"+
		"\u000b\f\u00d4\u00d5\n\n\u0000\u0000\u00d5\u00d6\u0005\u0015\u0000\u0000"+
		"\u00d6\u00ed\u0003\u0016\u000b\u000b\u00d7\u00d8\n\t\u0000\u0000\u00d8"+
		"\u00d9\u0005\u0013\u0000\u0000\u00d9\u00ed\u0003\u0016\u000b\n\u00da\u00db"+
		"\n\b\u0000\u0000\u00db\u00dc\u0003\u001a\r\u0000\u00dc\u00dd\u0003\u0016"+
		"\u000b\t\u00dd\u00ed\u0001\u0000\u0000\u0000\u00de\u00df\n\u0015\u0000"+
		"\u0000\u00df\u00e0\u0005\u0019\u0000\u0000\u00e0\u00ed\u00032\u0019\u0000"+
		"\u00e1\u00e2\n\u0014\u0000\u0000\u00e2\u00e4\u0005\"\u0000\u0000\u00e3"+
		"\u00e5\u0003*\u0015\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00ed"+
		"\u0005#\u0000\u0000\u00e7\u00e8\n\u0013\u0000\u0000\u00e8\u00e9\u0005"+
		"&\u0000\u0000\u00e9\u00ea\u0003\u0016\u000b\u0000\u00ea\u00eb\u0005\'"+
		"\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00be\u0001\u0000"+
		"\u0000\u0000\u00ec\u00c1\u0001\u0000\u0000\u0000\u00ec\u00c4\u0001\u0000"+
		"\u0000\u0000\u00ec\u00c7\u0001\u0000\u0000\u0000\u00ec\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ec\u00cd\u0001\u0000\u0000\u0000\u00ec\u00d1\u0001\u0000"+
		"\u0000\u0000\u00ec\u00d4\u0001\u0000\u0000\u0000\u00ec\u00d7\u0001\u0000"+
		"\u0000\u0000\u00ec\u00da\u0001\u0000\u0000\u0000\u00ec\u00de\u0001\u0000"+
		"\u0000\u0000\u00ec\u00e1\u0001\u0000\u0000\u0000\u00ec\u00e7\u0001\u0000"+
		"\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u0017\u0001\u0000"+
		"\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0007\u0003"+
		"\u0000\u0000\u00f2\u0019\u0001\u0000\u0000\u0000\u00f3\u00f4\u0007\u0004"+
		"\u0000\u0000\u00f4\u001b\u0001\u0000\u0000\u0000\u00f5\u00f9\u0003\u001e"+
		"\u000f\u0000\u00f6\u00f9\u0003,\u0016\u0000\u00f7\u00f9\u00030\u0018\u0000"+
		"\u00f8\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u001d\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fc\u0005$\u0000\u0000\u00fb\u00fd\u0003 \u0010\u0000\u00fc\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005%\u0000\u0000\u00ff\u001f\u0001"+
		"\u0000\u0000\u0000\u0100\u0102\u0003\u0010\b\u0000\u0101\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000"+
		"\u0000\u0000\u0105\u0107\u0003\u0016\u000b\u0000\u0106\u0105\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000"+
		"\u0000\u0000\u0108\u010a\u0003\u0016\u000b\u0000\u0109\u0101\u0001\u0000"+
		"\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a!\u0001\u0000\u0000"+
		"\u0000\u010b\u0110\u0003\u0016\u000b\u0000\u010c\u010d\u0005*\u0000\u0000"+
		"\u010d\u010f\u0003\u0016\u000b\u0000\u010e\u010c\u0001\u0000\u0000\u0000"+
		"\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000"+
		"\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0115\u0005*\u0000\u0000\u0114"+
		"\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115"+
		"\u011b\u0001\u0000\u0000\u0000\u0116\u0117\u0003\u0016\u000b\u0000\u0117"+
		"\u0118\u0005)\u0000\u0000\u0118\u0119\u0003\u0016\u000b\u0000\u0119\u011b"+
		"\u0001\u0000\u0000\u0000\u011a\u010b\u0001\u0000\u0000\u0000\u011a\u0116"+
		"\u0001\u0000\u0000\u0000\u011b#\u0001\u0000\u0000\u0000\u011c\u011d\u0003"+
		"2\u0019\u0000\u011d\u011f\u0005$\u0000\u0000\u011e\u0120\u0003&\u0013"+
		"\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000"+
		"\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0005%\u0000\u0000"+
		"\u0122%\u0001\u0000\u0000\u0000\u0123\u0128\u0003(\u0014\u0000\u0124\u0125"+
		"\u0005*\u0000\u0000\u0125\u0127\u0003(\u0014\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000"+
		"\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012d\u0005*\u0000"+
		"\u0000\u012c\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012d\'\u0001\u0000\u0000\u0000\u012e\u0134\u00032\u0019\u0000"+
		"\u012f\u0130\u00032\u0019\u0000\u0130\u0131\u0005(\u0000\u0000\u0131\u0132"+
		"\u0003\u0016\u000b\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u012e"+
		"\u0001\u0000\u0000\u0000\u0133\u012f\u0001\u0000\u0000\u0000\u0134)\u0001"+
		"\u0000\u0000\u0000\u0135\u013a\u0003\u0016\u000b\u0000\u0136\u0137\u0005"+
		"*\u0000\u0000\u0137\u0139\u0003\u0016\u000b\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000"+
		"\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u013f\u0005*\u0000"+
		"\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000"+
		"\u0000\u013f+\u0001\u0000\u0000\u0000\u0140\u0141\u0003.\u0017\u0000\u0141"+
		"-\u0001\u0000\u0000\u0000\u0142\u0143\u00052\u0000\u0000\u0143\u0144\u0003"+
		"\u0016\u000b\u0000\u0144\u0145\u0003\u001e\u000f\u0000\u0145/\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u00050\u0000\u0000\u0147\u0148\u0003\u0016\u000b"+
		"\u0000\u0148\u014e\u0003\u001e\u000f\u0000\u0149\u014c\u00051\u0000\u0000"+
		"\u014a\u014d\u0003\u001e\u000f\u0000\u014b\u014d\u00030\u0018\u0000\u014c"+
		"\u014a\u0001\u0000\u0000\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014d"+
		"\u014f\u0001\u0000\u0000\u0000\u014e\u0149\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0001\u0000\u0000\u0000\u014f1\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0005A\u0000\u0000\u01513\u0001\u0000\u0000\u0000\u0152\u0154\u00036"+
		"\u001b\u0000\u0153\u0152\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000"+
		"\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0005A\u0000"+
		"\u0000\u0156\u0157\u0005(\u0000\u0000\u0157\u0158\u0003<\u001e\u0000\u0158"+
		"5\u0001\u0000\u0000\u0000\u0159\u015a\u0007\u0005\u0000\u0000\u015a7\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0005&\u0000\u0000\u015c\u015d\u0003<\u001e"+
		"\u0000\u015d\u015e\u0005)\u0000\u0000\u015e\u015f\u0003\u0016\u000b\u0000"+
		"\u015f\u0160\u0005\'\u0000\u0000\u01609\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u0005&\u0000\u0000\u0162\u0163\u0003<\u001e\u0000\u0163\u0164\u0005"+
		"\'\u0000\u0000\u0164;\u0001\u0000\u0000\u0000\u0165\u0169\u00032\u0019"+
		"\u0000\u0166\u0169\u00038\u001c\u0000\u0167\u0169\u0003:\u001d\u0000\u0168"+
		"\u0165\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0168"+
		"\u0167\u0001\u0000\u0000\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a"+
		"\u016c\u0005@\u0000\u0000\u016b\u016a\u0001\u0000\u0000\u0000\u016b\u016c"+
		"\u0001\u0000\u0000\u0000\u016c=\u0001\u0000\u0000\u0000\u016d\u0174\u0005"+
		"\u0001\u0000\u0000\u016e\u0174\u0005\u0002\u0000\u0000\u016f\u0174\u0005"+
		";\u0000\u0000\u0170\u0174\u0005<\u0000\u0000\u0171\u0174\u0005?\u0000"+
		"\u0000\u0172\u0174\u00032\u0019\u0000\u0173\u016d\u0001\u0000\u0000\u0000"+
		"\u0173\u016e\u0001\u0000\u0000\u0000\u0173\u016f\u0001\u0000\u0000\u0000"+
		"\u0173\u0170\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000"+
		"\u0173\u0172\u0001\u0000\u0000\u0000\u0174?\u0001\u0000\u0000\u0000*F"+
		"MPT]`dlv|\u008c\u0092\u009d\u009f\u00a7\u00ab\u00af\u00b7\u00bc\u00e4"+
		"\u00ec\u00ee\u00f8\u00fc\u0103\u0106\u0109\u0110\u0114\u011a\u011f\u0128"+
		"\u012c\u0133\u013a\u013e\u014c\u014e\u0153\u0168\u016b\u0173";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}