package ru.spbau.compiler.syntax;

public class SyntaxException extends Exception {
    private String myLine;
    private int myLineNumber;
    private String myError;
    
    public SyntaxException(String line, int num, String err) {
        myLine = line;
        myLineNumber = num;
        myError = err;
    }
    
    @Override
    public String getMessage() {
        return "Error: " + myError + " in line[" + myLineNumber + "] " + myLine;
    }
}
