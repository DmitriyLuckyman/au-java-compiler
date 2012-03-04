package ru.spbau.compiler.semantics;

import java.util.Map;

/**
 * Abstract syntax tree element interface
 */

public interface SyntaxTreeItem {
    /**
     * Evaluate syntax tree with root in this element
     * 
     * @param context context of evaluation
     * @return evaluated value
     */
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context);
    
    /**
     * String representation of abstract syntax tree
     */
    public String str();
    
    /**
     * Performs substitution of newVal instead oldName in an abstract syntax
     * tree
     * 
     * @param oldName elemnt to be repleced
     * @param newVal new value
     * @return new abstract syntax tree
     */
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal);
}
