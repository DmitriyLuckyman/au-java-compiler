package ru.spbau.compiler;

public class Mul extends BinaryOperation {
    public Mul(SyntaxTreeItem left, SyntaxTreeItem right) {
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
            return new IntegerConstant(leftVal*rightVal);
        } else {
            return new Mul(left, right);
        }
    }

    @Override
    public String stringRepresentation() {
        return "(" + leftStr() + ") * (" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem left = leftSubst(oldName, newVal);
        SyntaxTreeItem right = rightSubst(oldName, newVal);
        return new Mul(left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mul) {
            Mul mul = (Mul)obj;
            return left().equals(mul.left()) && right().equals(mul.right());
        }
        return false;
    }
}
