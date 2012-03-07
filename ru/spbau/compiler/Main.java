package ru.spbau.compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ru.spbau.compiler.syntax.*;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2 ||
                (!args[1].equals("-e") && !args[1].equals("-p")) ) {
            System.err.println("usage:\n\tprogram filename -p|-e");
            System.err.println("\t-p --- print program");
            System.err.println("\t-e --- evaluate program");
            System.exit(1);
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(args[0]));
            Tokenizer tok = new SimpleTokenizer(in);
            Parser pars = new SimpleParser(tok);
            Program prog = pars.parse();
            if (args[1].equals("-p")) {
                System.out.println(prog);
            } else {
                System.out.println(prog.eval().str());
            }
        } catch (FileNotFoundException e) {
            System.err.println("file " + args[0] + " not found");
        } catch (SyntaxException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                //nothing to do
            }
        }
    }
}
