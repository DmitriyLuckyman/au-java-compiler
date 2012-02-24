package ru.spbau.compiler;

public class Apply extends BinaryOperation {
    public Apply(SyntaxTreeItem fun, SyntaxTreeItem arg) {
        super(fun, arg);
    }

    @Override
    public SyntaxTreeItem evaluateItem() {
        Fun fun = (Fun)leftEval();
        return fun.rightSubst((Name)fun.left(), rightEval()).evaluateItem();
    }

    @Override
    public String stringRepresentation() {
        return "(" + leftStr() + ")(" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem fun = leftSubst(oldName, newVal);
        SyntaxTreeItem arg = rightSubst(oldName, newVal);
        return new Apply(fun, arg);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Apply) {
            Apply app = (Apply)obj;
            return left().equals(app) && right().equals(app);
        }
        return false;
    }
}
