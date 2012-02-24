package ru.spbau.compiler;

public class Sub extends BinaryOperation {
    public Sub(SyntaxTreeItem left, SyntaxTreeItem right) {
        super(left, right);
    }
    
    @Override
    public SyntaxTreeItem evaluateItem() {
        SyntaxTreeItem left = leftEval();
        SyntaxTreeItem right = rightEval();
        if (left instanceof IntegerConstant
                && right instanceof IntegerConstant) {
            int leftVal = ((IntegerConstant)left).intValue();
            int rightVal = ((IntegerConstant)right).intValue();
            return new IntegerConstant(leftVal - rightVal);
        }
        return new Sub(left, right);
    }

    @Override
    public String stringRepresentation() {
        return "(" + leftStr() + ") - (" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem left = leftSubst(oldName, newVal);
        SyntaxTreeItem right = rightSubst(oldName, newVal);
        return new Sub(left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sub) {
            Sub sub = (Sub)obj;
            return left().equals(sub.left()) && right().equals(sub.right());
        }
        return false;
    }
}
