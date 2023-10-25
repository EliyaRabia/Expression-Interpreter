//Name: Eliya Rabia.
//ID: 318771052.

import java.util.Map;

/**
 * The type Log.
 * this class is about log.
 */
public class Log extends BinaryExpression implements Expression {

    //represent the number 0.
    public static final int ZERO = 0;

    //represent expression = 0.
    public static final int EXPRESSION_ZERO = 0;

    //represent base = 1.
    public static final int EXPRESSION_ONE = 1;

    //log of base and expression equals is 1.
    public static final int EQUAL = 1;

    //represent base =1.
    public static final int BASE_ONE = 1;

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Expression base, Expression expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Expression base, int expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Expression base, double expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Expression base, String expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Double base, Expression expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(String base, Expression expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(int base, Expression expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(int base, int expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(int base, double expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(int base, String expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Double base, int expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Double base, double expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(Double base, String expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(String base, int expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(String base, String expression) {
        super(base, expression);
    }

    /**
     * Instantiates a new Log.
     * the function creates log object.
     *
     * @param base       the base
     * @param expression the expression
     */
    public Log(String base, double expression) {
        super(base, expression);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Log(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public String toString() {
        return "log(" + this.getLeftExpression().toString() + ", " +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public double evaluate() throws Exception {
        double baseValue = this.getLeftExpression().evaluate();
        double expressionValue = this.getRightExpression().evaluate();

        //in case the base is invalid.
        if (baseValue <= BASE_ONE) {
            throw new Exception("base value: " + this.getLeftExpression()
                    .toString() + ", log can't have a base value 1 or below!");
        }

        //in case the number is in valid.
        if (expressionValue <= EXPRESSION_ZERO) {
            throw new Exception("number value: " + this.getRightExpression()
                    .toString() + ", log can't get value of 0 or below!");
        }
        return Math.log(expressionValue) / Math.log(baseValue);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double baseValue = this.getLeftExpression().evaluate(assignment);
        double expressionValue = this.getRightExpression().evaluate(assignment);

        //in case the base is invalid.
        if (baseValue <= BASE_ONE) {
            throw new Exception("base value: " + this.getLeftExpression()
                    .toString() + ", log can't have a base value 1 or below!");
        }

        //in case the number is in valid.
        if (expressionValue <= EXPRESSION_ZERO) {
            throw new Exception("number value: " + this.getRightExpression()
                    .toString() + ", log can't get value of 0 or below!");
        }
        return Math.log(expressionValue) / Math.log(baseValue);
    }

    @Override
    public Expression differentiate(String var) {
        Expression numerator = this.getRightExpression().differentiate(var);
        Expression denominator = new Mult(this.getRightExpression(),
                new Log(Math.E, this.getLeftExpression()));
        return new Div(numerator, denominator);
    }

    @Override
    public Expression simplify() {
        Expression simplifyLeftExpression =
                this.getLeftExpression().simplify();
        Expression simplifyRightExpression =
                this.getRightExpression().simplify();
        double evaluateLeftExpression, evaluateRightExpression;
        try {
            evaluateLeftExpression = simplifyLeftExpression.evaluate();
            evaluateRightExpression = simplifyRightExpression.evaluate();
            Log log = new Log(evaluateLeftExpression,evaluateRightExpression);
            return new Num(log.evaluate());

            //in case the right expression is 1 and the left not simplify.
        } catch (Exception e1) {
            try {
                evaluateRightExpression = simplifyRightExpression.evaluate();
                if (evaluateRightExpression == EXPRESSION_ONE) {
                    return new Num(ZERO);
                }

                // in case the expressions are the same.
            } catch (Exception e2) {
                if (simplifyLeftExpression.toString().equals
                        (simplifyRightExpression.toString())) {
                    return new Num(EQUAL);
                }

                //checking if the opposite is equal.
                if (simplifyLeftExpression.isBinary() &&
                        this.getRightExpression().isBinary()) {
                    if (simplifyLeftExpression.opposite()
                            .toString().equals
                            (simplifyRightExpression.toString())) {
                        return new Num(EQUAL);
                    }
                }
            }
        }
        return new Log(simplifyLeftExpression, simplifyRightExpression);
    }

    @Override
    public Expression opposite() {
        return new Log(this.getRightExpression(), this.getLeftExpression());
    }
}
