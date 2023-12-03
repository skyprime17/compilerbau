package org.compilerbau.antlr;

import org.compilerbau.antlr.ast.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.compilerbau.antlr.ast.Typ.BOOLEAN;
import static org.compilerbau.antlr.ast.Typ.VOID;

public class TypCheck implements Visitor<Boolean> {
    private Map<String, Typ> env = new HashMap<>();
    private final Map<String, Typ.FunTyp> funs = new HashMap<>();
    private Typ currentFunctionResult;

    @Override
    public Boolean visit(Program ast) {
        var result = true;
        for (Item item : ast.items()) {
            funs.put(item.name(), new Typ.FunTyp(item.args().stream().map(Arg::typ).collect(Collectors.toList()), item.typ()));
        }
        for (var fun : ast.items()) {
            result = fun.welcome(this);
        }
        return result;
    }

    @Override
    public Boolean visit(FunDef ast) {
        env = new HashMap<>();
        currentFunctionResult = ast.typ();
        ast.args().forEach(arg -> env.put(arg.name(), arg.typ()));
        return ast.body().welcome(this);
    }

    @Override
    public Boolean visit(Variable ast) {
        return true;
    }

    @Override
    public Boolean visit(Arg ast) {
        return true;
    }

    @Override
    public Boolean visit(TheTyp ast) {
        return true;
    }

    @Override
    public Boolean visit(TheVisibility ast) {
        return true;
    }

    @Override
    public Boolean visit(Block ast) {
        boolean r = true;
        for (var st : ast.statements()) {
            r = r && st.welcome(this);
        }

        ast.attributes().typ = VOID;
        return r;
    }

    @Override
    public Boolean visit(Assign ast) {
        return true;
    }

    @Override
    public Boolean visit(LongInteger ast) {
        return true;
    }

    @Override
    public Boolean visit(StringLit ast) {
        return true;
    }

    @Override
    public Boolean visit(BinOp ast) {
        return true;
    }

    @Override
    public Boolean visit(UnaryOp ast) {
        return true;
    }

    @Override
    public Boolean visit(ReturnExpression ast) {
        var r = ast.expr().welcome(this);
        if (!ast.expr().attributes().typ.equals(currentFunctionResult)) {
            System.out.println("Return type does not match function type");
        }
        ast.attributes().typ = currentFunctionResult;
        return r;
    }

    @Override
    public Boolean visit(FunCall ast) {
        return true;
    }

    @Override
    public Boolean visit(Struct ast) {
        return true;
    }

    @Override
    public Boolean visit(StructField ast) {
        return true;
    }

    @Override
    public Boolean visit(IfExpression ast) {
        return true;
    }

    @Override
    public Boolean visit(LoopExpression ast) {
        return true;
    }

    @Override
    public Boolean visit(BreakExpression ast) {
        return true;
    }

    @Override
    public Boolean visit(ContinueExpression ast) {
        return true;
    }
}
