grammar E;

start : (definition) +  EOF;

definition:
  fundef|condef
;
condef :
  CON ident LPAR (param (COMMA param)* )?  RPAR ( COLON typ)?
;


fundef :
  FUN ident LPAR (param (COMMA param)* )?  RPAR COLON typ semicolonStat
;

param :
  ident COLON typ
;

typ:
  ident
;

structuredStat:
    blockStat
  | whileStat
  | ifStat
  | returnStat
  ;
  
semicolonStat:
   structuredStat
  | expr SEMICOLON
  ;

returnStat:
  RETURN expr SEMICOLON;

blockStat:
  LBRC  (semicolonStat)* RBRC
;

whileStat:
  WHILE expr DO semicolonStat
;

ifStat:
  IF expr THEN semicolonStat  (ELSE semicolonStat)?
;
  

expr:
   | matchExpr
   | expr POW expr
   | expr (TIMES | DIV| MOD)  expr
   | expr (PLUS | MINUS) expr
   | expr (EQEQ | NE | GT | LT | LE | GE) expr   
   | expr AND expr   
   | expr OR expr   
   | ident EQ expr
   | (PLUS | MINUS)+ expr //Not Yet Implemented
   | atom
   ;

atom 
   : number
   | ident (LPAR expr (COMMA expr)* RPAR)?
   | LPAR expr RPAR
   ;

matchExpr:
    MATCH expr (patternCase)+
    ;

patternCase:
   CASE ident LPAR (ident (COMMA ident)* )? RPAR ARROW expr
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


FUN: 'fun';
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

ident: Alpha (Digit|Alpha)*;

LPAR : '(';
RPAR : ')';
LBRC : '{';
RBRC : '}';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';

Alpha: [a-z,A-Z];

number: Digits|'0';


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