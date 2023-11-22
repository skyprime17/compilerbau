grammar Gr;

// program starts with package declaration, then optionally import declarations, struct declarations, function declarations, identifier declarations

program: item* EOF;



item: visbility? (function_ | struct_);

visbility: 'pub'?;

/*
function example
parameter: x (optional mutability) and type
pub fn main(mut x: int) -> int {
    x = 5;
    return x;
}
*/
function_
    : 'fn' identifier '(' functionParams? ')' functionReturnType? blockExpression
    ;

functionParams
    : functionParam (',' functionParam)*
    ;

functionParam
    : 'mut'? identifier ':' type
    ;



functionReturnType
   : '->' type
   ;

blockExpression
   : '{' statements? '}'
   ;

statements
   : statement+ expression?
   | expression
   ;

statement
   : ';'
   | item
   | letStatement
   | expressionStatement
   ;


letStatement
   : 'let' patternNoTopAlt (':' type_)? ('=' expression)? ';'
   ;

expressionStatement
   : expression ';'
   | expressionWithBlock ';'?
   ;
/*
struct example:
struct Point {
    x: int,
    y: int,
}
*/
struct_
   : 'struct' identifier ('{' structFields? '}' | ';')
   ;

structFields
    : structField (',' structField)*
    ;

structField
    : identifier ':' type
    ;

type: NON_KEYWORD_IDENTIFIER;
identifier: NON_KEYWORD_IDENTIFIER;



NON_KEYWORD_IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Hidden tokens
WS                     : [ \t]+             -> channel(HIDDEN);
COMMENT                : '/*' .*? '*/'      -> channel(HIDDEN);
TERMINATOR             : [\r\n]+            -> channel(HIDDEN);
LINE_COMMENT           : '//' ~[\r\n]*      -> channel(HIDDEN);
