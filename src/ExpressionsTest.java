//Name: Eliya Rabia.
//ID: 318771052.

import java.util.Map;
import java.util.TreeMap;

public class ExpressionsTest {
    public static void main(String[] args){
        Expression e = new Plus(new Mult(2,"x"),
                new Plus(new Sin(new Mult(4,"y")),
                        new Pow(new Var("e"), new Var("x"))));
        System.out.println(e);
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x",2.0);
        assignment.put("y",0.25);
        assignment.put("e",2.71);
        try {
            System.out.println(e.evaluate(assignment));
        } catch (Exception exception){

        }
        System.out.println(e.differentiate("x"));
        try {
            System.out.println(e.differentiate("x").evaluate(assignment));
        } catch (Exception exception2){

        }
        System.out.println(e.differentiate("x").simplify());
    }
}
