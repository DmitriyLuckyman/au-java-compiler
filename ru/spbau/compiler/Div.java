package ru.spbau.compiler;

public class Div extends BinaryOperation {
    public Div(SyntaxTreeItem left, SyntaxTreeItem right) {
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
            return new IntegerConstant(leftVal/rightVal);
        }
        return new Div(left, right);
    }

    @Override
    public String stringRepresentation() {
        return "(" + leftStr() + ") / (" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem left = leftSubst(oldName, newVal);
        SyntaxTreeItem right = rightSubst(oldName, newVal);
        return new Div(left, right);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Div) {
            Div div = (Div)obj;
            return left().equals(div.left()) && right().equals(div.right());
        }
        return false;
    }
}
