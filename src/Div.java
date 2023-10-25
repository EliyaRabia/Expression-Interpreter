//Name: Eliya Rabia.
//ID: 318771052.

import java.util.Map;

/**
 * The type Div.
 * this class is about division.
 */
public class Div extends BinaryExpression implements Expression {

    //represent division of two equals expressions.
    public static final int EQUALS = 1;

    //represent denominator = 0.
    public static final int ZERO_DENOMINATOR = 0;

    //represent numerator = 0.
    public static final int ZERO_NUMERATOR = 0;

    //represent denominator = 1.
    public static final int ONE_DENOMINATOR = 1;

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Expression numerator, Expression denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Expression numerator, int denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Expression numerator, double denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Expression numerator, String denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Double numerator, Expression denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(String numerator, Expression denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(int numerator, Expression denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(int numerator, int denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(int numerator, double denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(int numerator, String denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Double numerator, int denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Double numerator, double denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(Double numerator, String denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(String numerator, int denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(String numerator, String denominator) {
        super(numerator, denominator);
    }

    /**
     * Instantiates a new Div.
     * the function creates division object.
     *
     * @param numerator   the numerator
     * @param denominator the denominator
     */
    public Div(String numerator, double denominator) {
        super(numerator, denominator);
    }


    @Override
    public Expression assign(String var, Expression expression) {
        return new Div(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public String toString() {
        return "(" + this.getLeftExpression().toString() + " / " +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public double evaluate() throws Exception {
        double numerator = this.getLeftExpression().evaluate();
        double denominator = this.getRightExpression().evaluate();
        if (denominator == ZERO_DENOMINATOR) {
            throw new Exception("the denominator number: " +
                    this.getLeftExpression().toString() +
                    " is invalid for division");
        }
        return numerator / denominator;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double numerator = this.getLeftExpression().evaluate(assignment);
        double denominator = this.getRightExpression().evaluate(assignment);
        if (denominator == ZERO_DENOMINATOR) {
            throw new Exception("the denominator number: " +
                    this.getLeftExpression().toString() +
                    " is invalid for division");
        }
        return numerator / denominator;
    }

    @Override
    public Expression differentiate(String var) {
        Expression leftDifferentiate = new Minus
                (new Mult(this.getLeftExpression().differentiate(var),
                        this.getRightExpression()),
                        new Mult(this.getLeftExpression(),
                                this.getRightExpression().differentiate(var)));
        Expression rightDifferentiate = new Pow(this.getRightExpression()
                , new Num(2));
        return new Div(leftDifferentiate, rightDifferentiate);
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

            //to avoid the case that the denominator is 0.
            Div division = new Div(evaluateLeftExpression ,
                    evaluateRightExpression);
            return new Num(division.evaluate());

            // in case left expression is zero and the right not simplify.
        } catch (Exception e) {
            try {
                evaluateLeftExpression = simplifyLeftExpression.evaluate();
                if (evaluateLeftExpression == ZERO_NUMERATOR) {
                    return new Num(0);
                }

                //in case right expression is 1 and the left not simplify.
            } catch (Exception e2) {
                try {
                    evaluateRightExpression = simplifyRightExpression
                            .evaluate();
                    if (evaluateRightExpression == ONE_DENOMINATOR) {
                        return simplifyLeftExpression;
                    }

                    //in case the expressions are the same.
                } catch (Exception e3) {
                    if (simplifyLeftExpression.toString().equals
                            (simplifyRightExpression.toString())) {
                        return new Num(EQUALS);
                    }

                    //checking if the opposite is equal.
                    if (simplifyLeftExpression.isBinary() &&
                            this.getRightExpression().isBinary()) {
                        if (simplifyLeftExpression.opposite()
                                .toString().equals
                                (simplifyRightExpression.toString())) {
                            return new Num(EQUALS);
                        }
                    }
                }
            }
        }
        return new Div(simplifyLeftExpression, simplifyRightExpression);
    }

    @Override
    public Expression opposite() {
        return new Div(this.getRightExpression(), this.getLeftExpression());
    }
}
