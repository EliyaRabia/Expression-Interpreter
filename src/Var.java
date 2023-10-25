//Name: Eliya Rabia.
//ID:318771052.

import java.util.List;
import java.util.LinkedList;

/**
 * The type Var.
 * this class is about variable.
 */
public class Var implements Expression {

    //represent the variable.
    private String var;

    //represent variable differentiated
    private static final int ONE = 1;

    //represent the differentiated if this is not by this variable
    private static final int ZERO =0;

    /**
     * Instantiates a new Var.
     * the function creates Var object.
     *
     * @param var the var
     */
    public Var(String var) {
        this.var = var;
    }

    @Override
    public double evaluate(java.util.Map<String, Double> assignment)
            throws Exception {
        if (assignment.containsKey(this.var)) {
            return assignment.get(this.var);
        } else {
            throw new Exception(
                    "the assignment have not the variant: " + this.var +
                            "to evaluate");
        }
    }

    @Override
    public double evaluate() throws Exception {
        throw new Exception(
                "There is no assign to evaluate the variant " + this.var);
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new LinkedList<>();
        list.add(this.var);
        return list;
    }

    @Override
    public String toString() {
        return this.var;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.var.equals(var)) {
            return expression;
        } else {
            return this;
        }
    }

    @Override
    public Expression differentiate(String var) {
        if (this.var.equals(var)) {
            return new Num(ONE);
        }
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
