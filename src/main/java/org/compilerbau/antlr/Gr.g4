grammar Gr;

start : KW_PACKAGE IDENT SEMICOLON (item)*  EOF;

item:
  visbility? (fundef|structdef)
;

visbility: KW_PUBLIC;

fundef:
  KW_FN IDENT LPAR (param (COMMA param)* )? RPAR ARROW type blockExpression
;

structdef:
  KW_STRUCT IDENT LBRC structfields RBRC
;

structfields:
    structfield (COMMA structfield)*
;

structfield:
    visbility? IDENT COLON type
;


statement
   : SEMICOLON
   | item
   | letStatement
   | expressionStatement
   ;

letStatement:
  KW_LET IDENT (COLON type)? EQ expression SEMICOLON
 ;


expressionStatement
   : expression SEMICOLON
   | expressionWithBlock SEMICOLON?
   ;


expression
   : literalExpression                                  # LiteralExpression_
   | expression DOT identifier                          # FieldExpression
   | expression LPAR callParams? RPAR                   # CallExpression
   | expression LSQB expression RSQB                    # IndexExpression
   | (MINUS | NOT) expression                           # NegationExpression
   | expression (TIMES | DIV | MOD) expression          # ArithmeticOrLogicalExpression
   | expression (PLUS | MINUS) expression               # ArithmeticOrLogicalExpression
   | expression AND expression                          # ArithmeticOrLogicalExpression
   | expression CARET expression                        # ArithmeticOrLogicalExpression
   | expression OR expression                           # ArithmeticOrLogicalExpression
   | expression comparisonOperator expression           # ComparisonExpression
   | expression ANDAND expression                       # LazyBooleanExpression
   | expression OROR expression                         # LazyBooleanExpression
   | expression EQ expression                           # AssignmentExpression
   | expression compoundAssignOperator expression       # CompoundAssignmentExpression
   | KW_CONTINUE expression?                            # ContinueExpression
   | KW_BREAK expression?                               # BreakExpression
   | KW_RETURN expression?                              # ReturnExpression
   | LPAR expression RPAR                               # GroupedExpression
   | LSQB arrayElements? RSQB                           # ArrayExpression
   | structExprStruct                                   # StructExpression_
   | expressionWithBlock                                # ExpressionWithBlock_
   ;

comparisonOperator
   : EQEQ
   | NE
   | GT
   | LT
   | GTE
   | LTE
   ;

compoundAssignOperator
   : PLUSEQ
   | MINUSEQ
   | STAREQ
   | SLASHEQ
   | PERCENTEQ
   | ANDEQ
   | OREQ
   | CARETEQ
   ;



expressionWithBlock
   : blockExpression
   | loopExpression
   | ifExpression
   ;

blockExpression:
  LBRC  (statements)? RBRC
;

statements
   : statement+ expression?
   | expression
   ;

arrayElements
    : expression (COMMA expression)* COMMA?
    | expression SEMICOLON expression
;

structExprStruct
   : identifier LBRC (structExprFields)? RBRC
   ;

structExprFields
   : structExprField (COMMA structExprField)* (COMMA?)
   ;

structExprField
   : (identifier | (identifier) COLON expression)
   ;

callParams
   : expression (COMMA expression)* COMMA?
   ;

loopExpression
   : (predicateLoopExpression)
   ;

predicateLoopExpression
   : KW_WHILE expression blockExpression
   ;


ifExpression
   : KW_IF expression blockExpression
   (
      KW_ELSE (blockExpression | ifExpression)
   )?
   ;

identifier:
    IDENT
;

param:
  IDENT COLON type
;


arraytype
   : LSQB type SEMICOLON expression RSQB
   ;

slicetype
   : LSQB type RSQB
   ;


type
   : IDENT
   | arraytype
   | slicetype
;

literalExpression:
    STRING_LITERAL
    | INTEGER_LITERAL
    | KW_TRUE
    | KW_FALSE
    | identifier
;

STRING_LITERAL
   : '"'
   (
      ~["]
      | QUOTE_ESCAPE
      | ASCII_ESCAPE
      | ESC_NEWLINE
   )* '"'
   ;

fragment ASCII_ESCAPE: '\\x' OCT_DIGIT HEX_DIGIT | COMMON_ESCAPE;
fragment COMMON_ESCAPE: '\\' [nrt\\0];
fragment QUOTE_ESCAPE: '\\' ['"];
fragment ESC_NEWLINE: '\\' '\n';
fragment OCT_DIGIT: [0-7];
fragment DEC_DIGIT: [0-9];
fragment HEX_DIGIT: [0-9a-fA-F];


INTEGER_LITERAL
   :
   (
      DEC_LITERAL
      | BIN_LITERAL
      | OCT_LITERAL
      | HEX_LITERAL
   )
   ;

DEC_LITERAL: DEC_DIGIT (DEC_DIGIT | '_')*;
HEX_LITERAL: '0x' '_'* HEX_DIGIT (HEX_DIGIT | '_')*;
OCT_LITERAL: '0o' '_'* OCT_DIGIT (OCT_DIGIT | '_')*;
BIN_LITERAL: '0b' '_'* [01] [01_]*;


PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
MOD: '%';
NE: '!=';
GTE : '>=';
GT : '>';
LTE : '<=';
LT : '<';
EQEQ : '==';
CARET: '^';
EQ: '=';
ANDAND: '&&';
OROR: '||';
OR : '|';
AND: '&';
NOT: '!';
DOT: '.';

PLUSEQ: '+=';
MINUSEQ: '-=';
STAREQ: '*=';
SLASHEQ: '/=';
PERCENTEQ: '%=';
CARETEQ: '^=';
ANDEQ: '&=';
OREQ: '|=';

LPAR : '(';
RPAR : ')';
LBRC : '{';
RBRC : '}';
LSQB : '[';
RSQB : ']';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';
ARROW: '->';

KW_PACKAGE: 'package';
KW_BREAK: 'break';
KW_CONTINUE: 'continue';
KW_FN: 'fn';
KW_IF: 'if';
KW_ELSE:'else';
KW_WHILE: 'while';
KW_DO: 'do';
KW_THEN:'then';
KW_RETURN: 'return';
KW_MATCH: 'match';
KW_CASE: 'case';
KW_LET: 'let';
KW_PUBLIC: 'pub';
KW_STRUCT: 'struct';
KW_TRUE: 'true';
KW_FALSE: 'false';

IDENT: Alpha (Digit|Alpha)*;

NUMBER: Digits|'0';

Alpha: [a-zA-Z_];


Digits
	:	NonZeroDigit Digit*
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
    	;

WS : [ \r\n\t] + -> skip;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;