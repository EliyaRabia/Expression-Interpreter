//Name: Eliya Rabia.
//ID: 318771052.

import java.util.List;

/**
 * The type Unary expression.
 * this class is about Unary Expressions.
 */
public abstract class UnaryExpression extends BaseExpression {

    //represent the expression.
    private Expression expression;

    /**
     * Instantiates a new Unary expression.
     * the function creates Unary Expression.
     *
     * @param expression the expression
     */
    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Instantiates a new Unary expression.
     * the function creates Unary Expression.
     *
     * @param expression the expression
     */
    public UnaryExpression(int expression) {
        this.expression = new Num(expression);
    }

    /**
     * Instantiates a new Unary expression.
     * the function creates Unary Expression.
     *
     * @param expression the expression
     */
    public UnaryExpression(String expression) {
        this.expression = new Var(expression);
    }

    /**
     * Instantiates a new Unary expression.
     * the function creates Unary Expression.
     *
     * @param expression the expression
     */
    public UnaryExpression(Double expression) {
        this.expression = new Num(expression);
    }

    /**
     * Gets expression.
     * the function return the expression.
     *
     * @return the expression
     */
    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public List<String> getVariables() {
        return this.getExpression().getVariables();
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public Expression opposite() {
        return this;
    }
}
