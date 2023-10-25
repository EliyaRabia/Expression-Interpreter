//Name: Eliya Rabia.
//ID: 318771052.

/**
 * Sin.
 * the class is about the sin object.
 */
public class Sin extends UnaryExpression implements Expression {

    /**
     * Instantiates a new Sin.
     * the function creates Sin object.
     *
     * @param expression the expression
     */
    public Sin(Expression expression) {
        super(expression);
    }

    /**
     * Instantiates a new Sin.
     * the function creates Sin object.
     *
     * @param expression the expression
     */
    public Sin(Double expression) {
        super(expression);
    }

    /**
     * Instantiates a new Sin.
     * the function creates Sin object.
     *
     * @param expression the expression
     */
    public Sin(String expression) {
        super(expression);
    }

    /**
     * Instantiates a new Sin.
     * the function creates Sin object.
     *
     * @param expression the expression
     */
    public Sin(int expression) {
        super(expression);
    }


    @Override
    public double evaluate() throws Exception {
        return Math.sin(Math.toRadians(this.getExpression().evaluate()));
    }


    @Override
    public double evaluate(java.util.Map<String, Double> assignment)
            throws Exception {
        return Math.sin(Math.toRadians
                (this.getExpression().evaluate(assignment)));
    }

    @Override
    public String toString() {
        return "sin(" + this.getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Sin(this.getExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Mult(new Cos(this.getExpression()),
                this.getExpression().differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression simplifyExpression = this.getExpression().simplify();
        try {
            return new Num(Math.sin(Math.toRadians(simplifyExpression
                    .evaluate())));
        } catch (Exception e) {
            return new Sin(simplifyExpression);
        }
    }

    @Override
    public boolean isCosOrSin(){
        return true;
    }
}
