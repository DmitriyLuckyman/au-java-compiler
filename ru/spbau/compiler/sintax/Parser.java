package ru.spbau.compiler.sintax;

public interface Parser {
    public Program parse() throws SyntaxException;
}
