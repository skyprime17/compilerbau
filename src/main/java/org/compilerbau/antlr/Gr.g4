grammar Gr;

// program starts with package declaration, then optionally import declarations, struct declarations, function declarations, identifier declarations

program: item* EOF;

item: visbility? (functionDeclaration | structDeclaration);

functionDeclaration:
    'fn' identifier '(' parameterList ')' functionReturnType? blockStatement;

functionReturnType: '->' type;


blockStatement: '{' semicolonStatement* '}';


semicolonStatement: statement ';';



visbility: 'pub'?;