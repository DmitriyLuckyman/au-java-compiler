package ru.spbau.compiler.syntax;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Simple tokenizer for the simple syntax
 */
public class SimpleTokenizer implements Tokenizer {
    private BufferedReader myIn;
    private int myLineCounter;
    private String myLine;
    
    /**
     * Constructs tokenizer from a input stream
     * 
     * @param in input stream
     */
    public SimpleTokenizer(BufferedReader in) {
        myIn = in;
    }

    /**
     * Tries to get new token from a input stream
     * 
     * @return new token or null if I/O error was occur or end of file reached
     */
    @Override
    public String getToken() {
        try {
            myLine = null;
            do {
                myLine = myIn.readLine();
                myLineCounter++;
            } while ((myLine != null) && myLine.trim().isEmpty());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return myLine;
    }

    @Override
    public String getLine() {
        return myLine;
    }

    @Override
    public int getLineNumber() {
        return myLineCounter;
    }

}
