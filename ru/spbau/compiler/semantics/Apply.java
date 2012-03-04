package ru.spbau.compiler.semantics;

import java.util.Map;

/**
 * Class implements application of a function
 */
public class Apply extends BinaryOperation {
    /**
     * Constructs application from a function and actual argument
     * 
     * @param fun function (or expression that can be evaluated to function)
     * @param arg actual argument (abstract syntax tree)
     */
    public Apply(SyntaxTreeItem fun, SyntaxTreeItem arg) {
        super(fun, arg);
    }

    /**
     * Substitutes an actual rgument instead formal argument of a function
     * 
     * @param context context of evaluation
     * @return evaluted value
     */
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
