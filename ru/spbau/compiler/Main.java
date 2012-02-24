package ru.spbau.compiler;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Name x = new Name("x"); //имя переменной
        Name fact = new Name("fact"); //имя функции
        
        IntegerConstant one = new IntegerConstant(1);
        IntegerConstant six = new IntegerConstant(6);
        Sub sub = new Sub(x, one);
        Apply app = new Apply(fact, sub);
        Mul mul = new Mul(x, app);
        If cond = new If(x, mul, one);
        Fun fun = new Fun(x,cond);

        Definition def = new Definition(fact, fun); //bind name and function
        Apply call = new Apply(fun, six); //call function from six
        
        System.out.println(call.evaluateItem().stringRepresentation());
        System.out.println(def.stringRepresentation());
    }
}
