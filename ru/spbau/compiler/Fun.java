package ru.spbau.compiler;

public class Fun extends BinaryOperation {
    public Fun(Name var, SyntaxTreeItem expr) {
        super(var, expr);
    }

    @Override
    public SyntaxTreeItem evaluateItem() {
        return this;
    }

    @Override
    public String stringRepresentation() {
        return "{" + leftStr() + "->" + rightStr() + "}";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        if (!left().equals(oldName)) {
            return new Fun((Name)left(), rightSubst(oldName, newVal));
        }
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fun) {
            Fun fun = (Fun)obj;
            return left().equals(fun.left()) && right().equals(fun.right());
        }
        return false;
    }
}
