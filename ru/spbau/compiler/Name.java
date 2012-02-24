package ru.spbau.compiler;

public class Name implements SyntaxTreeItem {
    private String myName;
    private SyntaxTreeItem myValue;
    
    public Name(String name) {
        myName = name;
    }

    public void define(SyntaxTreeItem def) {
        myValue = def;
    }
    
    @Override
    public SyntaxTreeItem evaluateItem() {
        if (myValue != null) {
            return myValue.evaluateItem();
        } else {
            return this;
        }
    }

    @Override
    public String stringRepresentation() {
        return myName;
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        if (this.equals(oldName)) {
            return newVal;
        } else {
            return this;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            return ((Name)obj).stringRepresentation().equals(myName);
        }
        return false;
    }
}
