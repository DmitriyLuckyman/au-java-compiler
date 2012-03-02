package ru.spbau.compiler.syntax;

public interface Tokenizer {
    public String getToken();
    public String getLine();
    public int getLineNumber();
}
