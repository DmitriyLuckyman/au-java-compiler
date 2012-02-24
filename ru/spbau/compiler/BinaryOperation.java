package ru.spbau.compiler;

public abstract class BinaryOperation implements SyntaxTreeItem {
    private SyntaxTreeItem myLeftOperand;
    private SyntaxTreeItem myRightOperand;
    
    public BinaryOperation(SyntaxTreeItem left, SyntaxTreeItem right) {
        myLeftOperand = left;
        myRightOperand = right;
    }
    
    public SyntaxTreeItem left() {
        return myLeftOperand;
    }
    
    public SyntaxTreeItem right() {
        return myRightOperand;
    }
    
    public SyntaxTreeItem leftEval() {
        return left().evaluateItem();
    }
    
    public SyntaxTreeItem rightEval() {
        return right().evaluateItem();
    }
    
    public SyntaxTreeItem leftSubst(Name var, SyntaxTreeItem expr) {
        return left().substitution(var, expr);
    }
    
    public SyntaxTreeItem rightSubst(Name var, SyntaxTreeItem expr) {
        return right().substitution(var, expr);
    }
    
    public String leftStr() {
        return left().stringRepresentation();
    }
    
    public String rightStr() {
        return right().stringRepresentation();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BinaryOperation) {
            return left().equals(right());
        }
        return false;
    }
}
