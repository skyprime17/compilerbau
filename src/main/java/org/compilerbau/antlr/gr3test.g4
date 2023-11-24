grammar gr3test;

start: 'package' IDENT (item)* EOF;

item: visbility? (function_ | struct_);

visbility: 'pub'?;


function_
    : 'fn' IDENT '(' functionParams? ')' functionReturnType? blockExpression
    ;

identifier: IDENT;

functionParams: functionParam (',' functionParam)*;
functionParam: identifier ':' type;
functionReturnType: '->' type;

blockExpression: '{' expression* '}';


IDENT: [a-zA-Z_] [a-zA-Z_0-9]*;