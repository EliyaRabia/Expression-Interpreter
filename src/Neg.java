//Name: Eliya Rabia.
//ID: 318771052.

/**
 * The type Neg.
 * this class is about negative.
 */
public class Neg extends UnaryExpression implements Expression {

    //represent multiply by -1 to make it neg.
    public static final int NEGATIVE = -1;

    /**
     * Instantiates a new Neg.
     * the function creates Neg object.
     *
     * @param expression the expression
     */
    public Neg(Expression expression) {
        super(expression);
    }

    /**
     * Instantiates a new Neg.
     * the function creates Neg object.
     *
     * @param expression the expression
     */
    public Neg(int expression) {
        super(expression);
    }

    /**
     * Instantiates a new Neg.
     * the function creates Neg object.
     *
     * @param expression the expression
     */
    public Neg(double expression) {
        super(expression);
    }

    /**
     * Instantiates a new Neg.
     * the function creates Neg object.
     *
     * @param expression the expression
     */
    public Neg(String expression) {
        super(expression);
    }


    @Override
    public double evaluate() throws Exception {
        return this.getExpression().evaluate() * NEGATIVE;
    }

    @Override
    public double evaluate(java.util.Map<String, Double> assignment)
            throws Exception {
        return this.getExpression().evaluate(assignment) * NEGATIVE;
    }

    @Override
    public String toString() {
        return "(-" + this.getExpression().toString() +
                ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Neg(this.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Neg(this.getExpression().differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression simplifyExpression =
                this.getExpression().simplify();
        try {
            double evaluateExpression = simplifyExpression.evaluate();
            return new Num(evaluateExpression * NEGATIVE);
        } catch (Exception e) {
            return new Neg(simplifyExpression);
        }
    }
}
