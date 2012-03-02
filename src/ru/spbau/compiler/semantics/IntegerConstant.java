package ru.spbau.compiler.semantics;

import java.util.Map;

public class IntegerConstant implements SyntaxTreeItem {
    private int myValue;

    public IntegerConstant(int value) {
        myValue = value;
    }
    
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        return this;
    }

    @Override
    public String str() {
        return String.valueOf(myValue);
    }
    
    public int intValue() {
        return myValue;
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        return this;
    }

}
