package ru.spbau.compiler.syntax;

public interface Parser {
    public Program parse() throws SyntaxException;
}
