package ru.spbau.compiler;

public interface SyntaxTreeItem {
    public SyntaxTreeItem evaluateItem();
    public String stringRepresentation();
    public SyntaxTreeItem substitution(Name oldName, SyntaxTreeItem newVal);
}
