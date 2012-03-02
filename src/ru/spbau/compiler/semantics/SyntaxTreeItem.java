package ru.spbau.compiler.semantics;

import java.util.Map;

public interface SyntaxTreeItem {
    public SyntaxTreeItem eval(Map<Name, SyntaxTreeItem> context);
    public String str();
    public SyntaxTreeItem subst(Name oldName, SyntaxTreeItem newVal);
}
