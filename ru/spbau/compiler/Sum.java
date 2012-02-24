package ru.spbau.compiler;

public class Sum extends BinaryOperation {
    public Sum(SyntaxTreeItem left, SyntaxTreeItem right) {
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
            return new IntegerConstant(leftVal + rightVal);
        }
        
        return new Sum(left, right);
    }

    @Override
    public String stringRepresentation() {
        return "(" + leftStr() + ") + (" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem left = leftSubst(oldName, newVal);
        SyntaxTreeItem right = rightSubst(oldName, newVal);
        return new Sum(left, right);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sum) {
            Sum sum = (Sum)obj;
            return left().equals(sum.left()) && right().equals(sum.right());
        }
        return false;
    }
}
