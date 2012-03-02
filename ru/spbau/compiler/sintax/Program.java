package ru.spbau.compiler.sintax;

import java.util.HashMap;
import java.util.Map;
import ru.spbau.compiler.semantics.Name;
import ru.spbau.compiler.semantics.SyntaxTreeItem;

public class Program {
    private Map<Name, SyntaxTreeItem> myContext
            = new HashMap<Name, SyntaxTreeItem>();
    private SyntaxTreeItem myExpression;
    
    public void addStatement(Name state, SyntaxTreeItem value) {
        myContext.put(state, value);
    }
    
    public void setExpression(SyntaxTreeItem item) {
        myExpression = item;
    }
    
    public SyntaxTreeItem eval() {
        return myExpression.eval(myContext);
    }
}
