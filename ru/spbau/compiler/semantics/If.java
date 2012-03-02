package ru.spbau.compiler.semantics;

import java.util.Map;

public class If implements SyntaxTreeItem {
    private SyntaxTreeItem myCondition;
    private SyntaxTreeItem myIfTrueAction;
    private SyntaxTreeItem myIfFalseAction;
    
    public If(SyntaxTreeItem cond, SyntaxTreeItem ifTrue,
            SyntaxTreeItem ifFalse) {
        myCondition = cond;
        myIfTrueAction = ifTrue;
        myIfFalseAction = ifFalse;
    }

    @Override
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context) {
        SyntaxTreeItem cond = myCondition.eval(context);
        if (cond instanceof IntegerConstant) {
            int val = ((IntegerConstant)cond).intValue();
            if (val > 0) {
                return myIfTrueAction.eval(context);
            } else {
                return myIfFalseAction.eval(context);
            }
        } else {
            //TODO: throw exception in this case
        }
        return null;
    }

    @Override
    public String str() {
        return "(IF " + myCondition.str()
                + " THEN " + myIfTrueAction.str()
                + " ELSE " + myIfFalseAction.str()
                + ")";
    }

    @Override
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal) {
        return new If(myCondition.subst(oldName, newVal),
                myIfTrueAction.subst(oldName, newVal),
                myIfFalseAction.subst(oldName, newVal));
    }
    
}
