package ru.spbau.compiler.semantics;

import java.util.Map;

/**
 * Class represent function in a abstract syntax tree
 */
public class Fun extends BinaryOperation {
    /**
     * Constructs function from a formal argument and implementation
     * 
     * @param var name of a formal argument
     * @param expr function implementation
     */
    public Fun(Name var, SyntaxTreeItem expr) {
        super(var, expr);
    }

    /**
     * This method does nothing, casue according semantics evaluation of a
     * function is a same function (really evaluation of a function can be
     * performed only with actiual arguments)
     * 
     * @param context
     * @return this
     * @see Apply
     */
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        return this;
    }

    @Override
    public String str() {
        return "{" + leftStr() + "->" + rightStr() + "}";
    }

    /**
     * Substitites newVal instead oldName. but only if oldName is not
     * equals to formal argument
     * 
     * @param oldName substituted name
     * @param newVal new value
     * @return new function with newVal instead oldName
     */
    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        if (!left().equals(oldName)) {
            return new Fun((Name)left(), rightSubst(oldName, newVal));
        }
        return this;
    }
}
