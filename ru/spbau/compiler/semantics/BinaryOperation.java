package ru.spbau.compiler.semantics;

import java.util.Map;

/**
 * Base class for binary operation
 */
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
    
    public SyntaxTreeItem leftEval(Map<Name, SyntaxTreeItem> context) {
        return left().eval(context);
    }
    
    public SyntaxTreeItem rightEval(Map<Name, SyntaxTreeItem> context) {
        return right().eval(context);
    }
    
    public SyntaxTreeItem leftSubst(Name var, SyntaxTreeItem expr) {
        return left().subst(var, expr);
    }
    
    public SyntaxTreeItem rightSubst(Name var, SyntaxTreeItem expr) {
        return right().subst(var, expr);
    }
    
    public String leftStr() {
        return left().str();
    }
    
    public String rightStr() {
        return right().str();
    }
}
