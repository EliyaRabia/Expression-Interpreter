//Name: Eliya Rabia
//ID: 318771052

import java.util.Map;

/**
 * The type Plus.
 * this class is about Plus object.
 */
public class Plus extends BinaryExpression implements Expression {

    //represent the number 0.
    public static final int ZERO = 0;

    //equal expressions is like one expression multiply by 2.
    public static final int EQUAL = 2;

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Expression left, int right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Expression left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Expression left, String right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Double left, Expression right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(String left, Expression right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(int left, Expression right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(int left, int right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(int left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(int left, String right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Double left, int right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Double left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(Double left, String right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(String left, int right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(String left, String right) {
        super(left, right);
    }

    /**
     * Instantiates a new Plus.
     * the function creates Plus Object.
     *
     * @param left  the left
     * @param right the right
     */
    public Plus(String left, double right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double leftExpression = this.getLeftExpression().evaluate(assignment);
        double rightExpression = this.getRightExpression().evaluate(assignment);
        return leftExpression + rightExpression;
    }

    @Override
    public double evaluate() throws Exception {
        double leftExpression = this.getLeftExpression().evaluate();
        double rightExpression = this.getRightExpression().evaluate();
        return leftExpression + rightExpression;
    }

    @Override
    public String toString() {
        return "(" + this.getLeftExpression().toString() + " + " +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Plus(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        Expression leftDifferentiate =
                this.getLeftExpression().differentiate(var);
        Expression rightDifferentiate =
                this.getRightExpression().differentiate(var);
        return new Plus(leftDifferentiate, rightDifferentiate);
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
            return new Num(evaluateLeftExpression + evaluateRightExpression);

            //in case left expression is zero and the right not simplify.
        } catch (Exception e1) {
            try {
                evaluateLeftExpression = simplifyLeftExpression.evaluate();
                if (evaluateLeftExpression == ZERO) {
                    return simplifyRightExpression;
                }

                //in case right expression is zero and the left not
                // simplify.
            } catch (Exception e2) {
                try {
                    evaluateRightExpression = simplifyRightExpression
                            .evaluate();
                    if (evaluateRightExpression == ZERO) {
                        return simplifyLeftExpression;
                    }

                    //in case the expression are equals.
                } catch (Exception e3) {
                    if (simplifyLeftExpression.toString()
                            .equals(simplifyRightExpression.toString())) {
                        return new Mult(EQUAL, simplifyLeftExpression);
                    }

                    //check if the opposite is equal.
                    if (simplifyLeftExpression.isBinary() &&
                            this.getRightExpression().isBinary()) {
                        if (simplifyLeftExpression.opposite().toString().equals
                                (simplifyRightExpression.toString())) {
                            return new Mult(EQUAL, simplifyLeftExpression);
                        }
                    }
                }
            }
            return new Plus(simplifyLeftExpression,
                    simplifyRightExpression);
        }
    }

    @Override
    public Expression opposite() {
        return new Plus(this.getRightExpression(), this.getLeftExpression());
    }
}
