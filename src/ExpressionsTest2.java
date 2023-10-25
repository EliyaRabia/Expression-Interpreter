//ID:209380864

import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;

/**
 * The type Expressions test.
 */
public class ExpressionsTest2 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Expression e2 = new Pow(new Plus(new Var("x"), new Var("y")),
                new Num(2));
        String s = e2.toString();
        System.out.println(s);
        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }
        Expression e3 = e2.assign("y", e2);
        System.out.println(e3);
        // (x + ((x + y)^2))^2
        e3 = e3.assign("x", new Num(1));
        System.out.println(e3);
        // (1 + ((1 + y)^2))^2
        e3 = e3.assign("y", new Num(2));
        try {
            double value = e3.evaluate();
            System.out.println("The result is: " + value);
        } catch (Exception e) {
            System.out.println(e);
        }
        Expression e4 = new Pow(new Var("x"), new Var("y"));
        List<String> variables = e4.getVariables();
        for (String v : variables) {
            System.out.println(v);
        }
        e4 = e4.assign("x", new Num(-1));
        e4 = e4.assign("y", new Num(2.3));
        try {
            double value = e4.evaluate();
            System.out.println("The pow result is: " + value);
        } catch (Exception e) {
            System.out.println(e);
        }
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 4.0);
        try {
            double value = e2.evaluate(assignment);
            System.out.println("The result is: " + value);
        } catch (Exception e) {
            System.out.println("");
        }
        Expression e5 = new Plus(new Sin("x"), new Cos("y"));
        e5 = e5.differentiate("x");
        System.out.println("the differentiate is:  " + e5);
        System.out.println("the simplify is: " + e5.simplify());
        Expression e6 = new Pow(new Plus(new Var("x"), new Var("y")),
                new Num(2));
        e6 = e6.differentiate("x");
        System.out.println("the differentiate is:  " + e6);
        System.out.println("the simplify is: " + e6.simplify());
        Expression e7 = new Pow(new Minus(new Mult(new Num(2), new Num(8)),
                new Num(6)), new Num(2));
        System.out.println("e7 = : " + e7);
        System.out.println("e7 simplify: " + e7.simplify());
        Expression e8 = new Minus(new Plus("x", "y"), new Plus("y", "x"));
        System.out.println(e8);
        System.out.println(e8.simplify());
        Expression e9 = new Plus(new Mult(new Neg(new Div(new Var("y"),
                new Neg(new Div(new Var("y"), new Var("x"))))), new Num(0)),
                new Neg(new Neg( new Neg( new Minus(new Minus(new Neg(2),
                        new Num(0)), new Plus(new Neg(4), new Var("x")))))));
        System.out.println(e9);
        System.out.println(e9.simplify());
        Expression e10 = new Plus(new Plus(new Cos(new Var("x")), new Log(new Var(
                "e"), new Var("x"))), new Plus(new Div(new Num(1), new Var("x")),
                new Sin(new Pow(new Var("x"), new Num(2)))));
        System.out.println(e10);
        System.out.println(e10.differentiate("x"));
        Expression e11 = new Plus(new Mult(new Mult(new Var("x"), new Num(1)),
                new Num(1)), new Minus(new Num(0), new Neg(new Plus(new Var("x"),
                new Num(0)))));
        System.out.println(e11);
        System.out.println(e11.simplify());
    }
}