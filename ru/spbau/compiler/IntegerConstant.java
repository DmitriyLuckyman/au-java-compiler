package ru.spbau.compiler;

public class IntegerConstant implements SyntaxTreeItem {
    private int myValue;

    public IntegerConstant(int value) {
        myValue = value;
    }
    
    @Override
    public SyntaxTreeItem evaluateItem() {
        return this;
    }

    @Override
    public String stringRepresentation() {
        return String.valueOf(myValue);
    }
    
    public int intValue() {
        return myValue;
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntegerConstant) {
            return ((IntegerConstant)obj).intValue() == myValue;
        }
        return false;
    }
}
