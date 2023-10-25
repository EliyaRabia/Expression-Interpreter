//Name: Eliya Rabia.
//ID: 318771052.

/**
 * The type Cos.
 * this class is about cosine.
 */
public class Cos extends UnaryExpression implements Expression {

    /**
     * Instantiates a new Cos.
     * the function creates cosine
     *
     * @param expression the expression
     */
    public Cos(Expression expression) {
        super(expression);
    }

    /**
     * Instantiates a new Cos.
     * the function creates cosine
     *
     * @param expression the expression
     */
    public Cos(String expression) {
        super(expression);
    }


    /**
     * Instantiates a new Cos.
     * the function creates cosine
     *
     * @param expression the expression
     */
    public Cos(Double expression) {
        super(expression);
    }

    /**
     * Instantiates a new Cos.
     * the function creates cosine
     *
     * @param expression the expression
     */
    public Cos(int expression) {
        super(expression);
    }

    @Override
    public double evaluate() throws Exception {
        return Math.cos(Math.toRadians(this.getExpression().evaluate()));
    }

    @Override
    public double evaluate(java.util.Map<String, Double> assignment)
            throws Exception {
        return Math.cos(Math.toRadians
                (this.getExpression().evaluate(assignment)));
    }


    @Override
    public String toString() {
        return "cos(" + this.getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Cos(this.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Neg(new Mult(new Sin(this.getExpression()),
                this.getExpression().differentiate(var)));
    }

    @Override
    public Expression simplify() {
        Expression simplifyExpression = this.getExpression().simplify();
        try {
            return new Num(Math.cos(Math.toRadians(simplifyExpression
                    .evaluate())));
        } catch (Exception e) {
            return new Cos(simplifyExpression);
        }
    }

    @Override
    public boolean isCosOrSin(){
        return true;
    }
}
