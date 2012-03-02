package ru.spbau.compiler.sintax;

public interface Tokenizer {
    public String getToken();
    public String getLine();
    public int getLineNumber();
}
