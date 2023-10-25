//Name: Eliya Rabia.
//ID: 318771052.

import java.util.LinkedList;
import java.util.List;


/**
 * The type Num.
 * the class is about number.
 */
public class Num implements Expression {

    //represent the number of num object.
    private double num;

     //represent differentiate of number is 0.
    public static final int ZERO = 0;

    /**
     * Instantiates a new Num.
     * the function creates Num object.
     *
     * @param num the num
     */
    public Num(int num) {
        this.num = num;
    }

    /**
     * Instantiates a new Num.
     * the function creates Num object.
     *
     * @param num the num
     */
    public Num(Double num) {
        this.num = num;
    }


    @Override
    public double evaluate(java.util.Map<String, Double> assignment)
            throws Exception {
        return this.num;
    }

    @Override
    public double evaluate() throws Exception {
        return this.num;
    }

    @Override
    public List<String> getVariables() {
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        if(this.num == Math.E){
            return "e";
        }

        return Double.toString(this.num);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(ZERO);
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public Expression opposite() {
        return this;
    }

    @Override
    public boolean isCosOrSin(){
        return false;
    }
}
