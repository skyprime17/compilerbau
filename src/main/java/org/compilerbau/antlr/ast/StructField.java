package org.compilerbau.antlr.ast;

public record StructField(Attributes attributes, String fieldName, Typ type) implements AST {
    @Override
    public Attributes attributes() {
        return null;
    }

    @Override
    public boolean isStructured() {
        return false;
    }

    @Override
    public <R> R welcome(Visitor<R> vis) {
        return vis.visit(this);
    }
}
