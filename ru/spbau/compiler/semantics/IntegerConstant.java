package ru.spbau.compiler.semantics;

import java.math.BigInteger;
import java.util.Map;

public class IntegerConstant implements SyntaxTreeItem {
    private BigInteger myValue;

    public IntegerConstant(String value) {
        myValue = new BigInteger(value);
    }
    
    public IntegerConstant(BigInteger value) {
        myValue = value;
    }
    
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        return this;
    }

    @Override
    public String str() {
        return myValue.toString();
    }
    
    public BigInteger intValue() {
        return myValue;
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        return this;
    }

}
