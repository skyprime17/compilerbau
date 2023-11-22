









/*
struct example:
struct Point {
    x: int,
    y: int,
}
*/
structDecl
   : 'struct' identifier ('{' structFields? '}' | ';')
   ;

structFields
    : structField (',' structField)*
    ;

structField
    : identifier ':' type
    ;

