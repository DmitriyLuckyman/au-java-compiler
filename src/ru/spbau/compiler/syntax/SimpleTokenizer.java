package ru.spbau.compiler.syntax;

import java.io.BufferedReader;
import java.io.IOException;

public class SimpleTokenizer implements Tokenizer {
    private BufferedReader myIn;
    private int myLineCounter;
    private String myLine;
    
    public SimpleTokenizer(BufferedReader in) {
        myIn = in;
    }

    @Override
    public String getToken() {
        try {
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
