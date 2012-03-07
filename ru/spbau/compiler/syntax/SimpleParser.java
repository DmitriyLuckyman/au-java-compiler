package ru.spbau.compiler.syntax;

import ru.spbau.compiler.semantics.*;

public class SimpleParser implements Parser {
    private Tokenizer myTokenizer;
    private Program myProgram = new Program();
    private String myToken;
    private int myFormalArgsCounter;
    private final String myFormalPrefix = "formal_arg$";
    
    public SimpleParser(Tokenizer tok) {
        myTokenizer = tok;
    }
    
    @Override
    public Program parse() throws SyntaxException {
        parseProgram();
        return myProgram;
    }
    
    private void parseProgram() throws SyntaxException {
        while ((myToken = myTokenizer.getToken()) != null) {
            if (myToken.equals(";")) {
                myToken = myTokenizer.getToken();
                myProgram.setExpression(readExpression());
                myToken = myTokenizer.getToken();
                if (myToken != null) {
                    throw new SyntaxException(myToken,
                            myTokenizer.getLineNumber(),
                            "end of file expected");
                }
            } else {
                Name name = new Name(myToken);
                myToken = myTokenizer.getToken();
                myProgram.addStatement(name, readExpression());
            }
        }
    }
    
    private SyntaxTreeItem readExpression() throws SyntaxException {
        SyntaxTreeItem item;
        String old = myToken;
        myToken = myTokenizer.getToken();
        if ((old == null) || (myToken == null)) {
            throw new SyntaxException(null, myTokenizer.getLineNumber(),
                    "unexpected end of file");
        } else if (old.equals("x")) {
            item = parseVariable();
        } else if (old.equals("f")) {
            item = parseFunction();
        } else if (old.equals("a")) {
            item = parseApplication();
        } else if (old.equals("?")) {
            item = parseCondition();
        } else if (old.equals("@")) {
            item = parseOperation();
        } else if (old.equals("!")) {
            item = parseConstant();
        } else {
            throw new SyntaxException(old, myTokenizer.getLineNumber() - 1,
                    "x, f, a, ?, @ or ! expected");
        }
        return item;
    }
    
    private Name parseVariable() {
        return new Name(myToken);
    }
    
    private Fun parseFunction() throws SyntaxException {
        Name arg = new Name(myToken);
        Name newArg = new Name(myFormalPrefix + myFormalArgsCounter++);
        myToken = myTokenizer.getToken();
        SyntaxTreeItem fun = readExpression();
        return new Fun(newArg, fun.subst(arg, newArg));
    }
    
    private SyntaxTreeItem parseApplication() throws SyntaxException {
        SyntaxTreeItem left = readExpression();
        myToken = myTokenizer.getToken();
        SyntaxTreeItem right = readExpression();
        return new Apply(left, right);
    }
    
    private SyntaxTreeItem parseCondition() throws SyntaxException {
        SyntaxTreeItem c = readExpression();
        myToken = myTokenizer.getToken();
        SyntaxTreeItem t = readExpression();
        myToken = myTokenizer.getToken();
        SyntaxTreeItem f = readExpression();
        return new If(c, t, f);
    }
    
    private SyntaxTreeItem parseOperation() throws SyntaxException {
        String op = myToken;
        myToken = myTokenizer.getToken();
        SyntaxTreeItem left = readExpression();
        myToken = myTokenizer.getToken();
        SyntaxTreeItem right = readExpression();
        if (op.equals("+")) {
            return new Sum(left, right);
        } else if (op.equals("-")) {
            return new Sub(left, right);
        } else if (op.equals("*")) {
            return new Mul(left, right);
        } else if (op.equals("/")) {
            return new Div(left, right);
        } else {
            throw new SyntaxException(myToken, myTokenizer.getLineNumber(),
                    "+,-,* or / expected");
        }
    }
    
    private SyntaxTreeItem parseConstant() {
        return new IntegerConstant(myToken);
    }
}
