package ru.spbau.compiler.semantics;

import java.util.Map;

public class Sub extends BinaryOperation {
    public Sub(SyntaxTreeItem left, SyntaxTreeItem right) {
        super(left, right);
    }
    
    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        SyntaxTreeItem left = leftEval(context);
        SyntaxTreeItem right = rightEval(context);
        if (left instanceof IntegerConstant
                && right instanceof IntegerConstant) {
            int leftVal = ((IntegerConstant)left).intValue();
            int rightVal = ((IntegerConstant)right).intValue();
            return new IntegerConstant(leftVal - rightVal);
        }
        return new Sub(left, right);
    }

    @Override
    public String str() {
        return "(" + leftStr() + "-" + rightStr() + ")";
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        SyntaxTreeItem left = leftSubst(oldName, newVal);
        SyntaxTreeItem right = rightSubst(oldName, newVal);
        return new Sub(left, right);
    }

}
