package ru.spbau.compiler.syntax;

/**
 * Lexical analizer interface
 */
public interface Tokenizer {
    /**
     * Takes next token and returns it
     * 
     * @return new token
     */
    public String getToken();
    
    /**
     * Return current line
     * 
     * @return current line
     */
    public String getLine();
    
    /**
     * Returns current line number
     * 
     * @return line number
     */
    public int getLineNumber();
}
