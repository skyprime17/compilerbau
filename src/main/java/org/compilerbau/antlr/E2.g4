grammar E2;

start : PACKAGE IDENT (item)*  EOF;

item:
  visbility? (fundef|structdef)
;

visbility: PUBLIC;

fundef:
  FN IDENT LPAR (param (COMMA param)* )?  RPAR ARROW typ blockExpression
;

structdef:
  'struct' IDENT LBRC structfields RBRC
;

structfields:
    structfield (COMMA structfield)*
;

structfield:
    visbility? IDENT COLON typ
;


statement
   : ';'
   | item
   | letStatement
   | expressionStatement
   ;

letStatement:
  LET IDENT (COLON typ)? EQ expression SEMICOLON
 ;


expressionStatement
   : expression ';'
   | expressionWithBlock ';'?
   ;


// 8.2
expression
   : literalExpression                                  # LiteralExpression_  // 8.2.1
   | expression '.' identifier                          # FieldExpression  // 8.2.11
   | expression '(' callParams? ')'                     # CallExpression   // 8.2.9
   | expression '[' expression ']'                      # IndexExpression  // 8.2.6
   | ('-' | '!') expression                             # NegationExpression  // 8.2.4
   | expression ('*' | '/' | '%') expression            # ArithmeticOrLogicalExpression   // 8.2.4
   | expression ('+' | '-') expression                  # ArithmeticOrLogicalExpression   // 8.2.4
   | expression '&' expression                          # ArithmeticOrLogicalExpression   // 8.2.4
   | expression '^' expression                          # ArithmeticOrLogicalExpression   // 8.2.4
   | expression '|' expression                          # ArithmeticOrLogicalExpression   // 8.2.4
   | expression comparisonOperator expression           # ComparisonExpression   // 8.2.4
   | expression '&&' expression                         # LazyBooleanExpression  // 8.2.4
   | expression '||' expression                         # LazyBooleanExpression  // 8.2.4
   | expression '..' expression?                        # RangeExpression  // 8.2.14
   | expression '=' expression                          # AssignmentExpression   // 8.2.4
   | expression compoundAssignOperator expression       # CompoundAssignmentExpression // 8.2.4
   | 'continue' expression?                             # ContinueExpression  // 8.2.13
   | 'break' expression?                                # BreakExpression  // 8.2.13
   | 'return' expression?                               # ReturnExpression // 8.2.17
   | '(' expression ')'                                 # GroupedExpression   // 8.2.5
   | '[' arrayElements? ']'                             # ArrayExpression  // 8.2.6
   | structExprStruct                                   # StructExpression_   // 8.2.8
   | expressionWithBlock                                # ExpressionWithBlock_
   ;

comparisonOperator
   : '=='
   | '!='
   | '>'
   | '<'
   | '>='
   | '<='
   ;

compoundAssignOperator
   : '+='
   | '-='
   | '*='
   | '/='
   | '%='
   | '&='
   | '|='
   | '^='
   | '<<='
   | '>>='
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
    : expression (',' expression)* ','?
    | expression ';' expression
;

structExprStruct
   : identifier '{' (structExprFields)? '}'
   ;

structExprFields
   : structExprField (',' structExprField)* (','?)
   ;

structExprField
   : (identifier | (identifier) ':' expression)
   ;

callParams
   : expression (',' expression)* ','?
   ;

loopExpression
   : (predicateLoopExpression)
   ;

predicateLoopExpression
   : 'while' expression blockExpression
   ;


ifExpression
   : 'if' expression blockExpression
   (
      'else' (blockExpression | ifExpression)
   )?
   ;

identifier:
    IDENT
;

param:
  IDENT COLON typ
;

typ:
  IDENT
;

literalExpression:
    IDENT
;

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
MOD: '%';
GE : '>=';
GT : '>';
LE : '<=';
LT : '<';
NE : '/=';
EQEQ : '==';
POW: '^';
EQ: '=';
AND: '&&';
OR: '||';
NOT: '!';

LPAR : '(';
RPAR : ')';
LBRC : '{';
RBRC : '}';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';

PACKAGE: 'package';

FN: 'fn';
CON: 'con';
IF: 'if';
WHILE: 'while';
DO: 'do';
THEN:'then';
ELSE:'else';
RETURN: 'return';
MATCH: 'match';
CASE: 'case';
ARROW: '->';
LET: 'let';
PUBLIC: 'pub';

IDENT: Alpha (Digit|Alpha)*;

NUMBER: Digits|'0';

fragment
Alpha: [a-zA-Z];


fragment
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