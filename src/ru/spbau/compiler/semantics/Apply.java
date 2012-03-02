package ru.spbau.compiler.semantics;

import java.util.Map;

public class Apply extends BinaryOperation {
    public Apply(SyntaxTreeItem fun, SyntaxTreeItem arg) {
        super(fun, arg);
    }

    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        Fun fun = (Fun)leftEval(context);
        return fun.rightSubst((Name)fun.left(), rightEval(context)).eval(context);
    }

    @Override
    public String str() {
        return "(" + leftStr() + " " + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem fun = leftSubst(oldName, newVal);
        SyntaxTreeItem arg = rightSubst(oldName, newVal);
        return new Apply(fun, arg);
    }

}
