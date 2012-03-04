package ru.spbau.compiler.syntax;

/**
 * Abstract program parser interface
 */
public interface Parser {
    /**
     * Parses program
     * 
     * @return parsed program
     * @throws SyntaxException may throws if program is in wrong concrete syntax 
     */
    public Program parse() throws SyntaxException;
}
