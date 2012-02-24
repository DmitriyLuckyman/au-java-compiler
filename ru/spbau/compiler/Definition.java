package ru.spbau.compiler;

public class Definition extends BinaryOperation{
    public Definition(Name name, SyntaxTreeItem expr) {
        super(name, expr);
        name.define(expr);
    }
    
    @Override
    public SyntaxTreeItem evaluateItem() {
        return rightEval();
    }

    @Override
    public String stringRepresentation() {
        return leftStr() + "::= " + rightStr();
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        if (!oldName.equals(left())) {
            return new Definition((Name)left(), rightSubst(oldName, newVal));
        }
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Definition) {
            Definition def = (Definition)obj;
            return left().equals(def.left()) && right().equals(def.right());
        }
        return false;
    }
}
