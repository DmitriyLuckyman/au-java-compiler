package ru.spbau.compiler.syntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import ru.spbau.compiler.semantics.Name;
import ru.spbau.compiler.semantics.SyntaxTreeItem;

/**
 * Class Program represents program as set of definitions and expression to be
 * evaluted
 */
public class Program {
    private Map<Name, SyntaxTreeItem> myContext
            = new HashMap<Name, SyntaxTreeItem>();
    private SyntaxTreeItem myExpression;
    
    /**
     * Add definition to a program
     * 
     * @param state new name
     * @param value new value
     */
    public void addStatement(Name state, SyntaxTreeItem value) {
        myContext.put(state, value);
    }
    
    /**
     * Sets expression to be evaluated
     * 
     * @param item expression
     */
    public void setExpression(SyntaxTreeItem item) {
        myExpression = item;
    }
    
    /**
     * Evaluates a program
     * 
     * @return evalutated value
     */
    public SyntaxTreeItem eval() {
        return myExpression.eval(myContext);
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Entry<Name, SyntaxTreeItem> entry : myContext.entrySet()) {
            str.append(entry.getKey().str());
            str.append(" = ");
            str.append(entry.getValue().str());
            str.append("\n");
        }
        if (myExpression != null) {
            str.append(myExpression.str());
        }
        return str.toString();
    }
}