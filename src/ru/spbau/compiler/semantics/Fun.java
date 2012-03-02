package ru.spbau.compiler.semantics;

import java.util.Map;

public class Fun extends BinaryOperation {
    public Fun(Name var, SyntaxTreeItem expr) {
        super(var, expr);
    }

    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        return this;
    }

    @Override
    public String str() {
        return "{" + leftStr() + "->" + rightStr() + "}";
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        if (!left().equals(oldName)) {
            return new Fun((Name)left(), rightSubst(oldName, newVal));
        }
        return this;
    }

}
