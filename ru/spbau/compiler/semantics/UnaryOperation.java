package ru.spbau.compiler.semantics;

import java.util.Map;

public class UnaryOperation implements SyntaxTreeItem {
    private SyntaxTreeItem myOperand;
    
    public UnaryOperation(SyntaxTreeItem operand) {
        myOperand = operand;
    }
    
    public SyntaxTreeItem operand() {
        return myOperand;
    }
    
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        return myOperand.eval(context);
    }
    
    @Override
    public String str() {
        return myOperand.str();
    }
    
    public SyntaxTreeItem subst(Name name, SyntaxTreeItem newVal) {
        return myOperand.subst(name, newVal);
    }
}
