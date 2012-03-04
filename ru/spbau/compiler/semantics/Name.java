package ru.spbau.compiler.semantics;

import java.util.Map;

/**
 * Class represents abstract name (name of a function, variable or
 * anything else) in abstract syntax tree
 */
public class Name implements SyntaxTreeItem {
    private String myName;
    
    public Name(String name) {
        myName = name;
    }

    /**
     * If name is binded with exression, method evaluates this expression and
     * this otherwise
     * 
     * @param context context of evaluation
     * @return evaluated value
     */
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        if (context.containsKey(this)) {
            return context.get(this).eval(context);
        }
        return this;
    }

    @Override
    public String str() {
        return myName;
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        if (oldName.equals(this)) {
            return newVal;
        }
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Name && ((Name) obj).str().equals(myName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (myName != null ? myName.hashCode() : 0);
        return hash;
    }
}
