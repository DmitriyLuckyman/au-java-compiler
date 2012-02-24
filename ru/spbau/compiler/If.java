package ru.spbau.compiler;

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
    public SyntaxTreeItem evaluateItem() {
        SyntaxTreeItem cond = myCondition.evaluateItem();
        if (cond instanceof IntegerConstant) {
            int val = ((IntegerConstant)cond).intValue();
            if (val > 0) {
                return myIfTrueAction.evaluateItem();
            } else {
                return myIfFalseAction.evaluateItem();
            }
        } else {
            //TODO: throw exception in this case
        }
        return null;
    }

    @Override
    public String stringRepresentation() {
        return "IF (" + myCondition.stringRepresentation()
                + ") THEN (" + myIfTrueAction.stringRepresentation()
                + ") ELSE (" + myIfFalseAction.stringRepresentation()
                + ")";
    }

    @Override
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal) {
        return new If(myCondition.substitution(oldName, newVal),
                myIfTrueAction.substitution(oldName, newVal),
                myIfFalseAction.substitution(oldName, newVal));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof If) {
            If cond = (If)obj;
            return myCondition.equals(cond.myCondition)
                    && myIfTrueAction.equals(cond.myIfTrueAction)
                    && myIfFalseAction.equals(cond.myIfFalseAction);
        }
        return false;
    }
}
