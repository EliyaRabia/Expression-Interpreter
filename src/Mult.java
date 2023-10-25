//Name: Eliya Rabia
//ID: 318771052

import java.util.Map;

/**
 * The type Mult.
 * this class is about Multiply.
 */
public class Mult extends BinaryExpression implements Expression {

    //multiply equal expressions is like pow by 2.
    public static final int EQUAL = 2;

    //represent the number zero.
    public static final int ZERO = 0;

    //represent the number one.
    public static final int ONE = 1;

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression  the left expression
     * @param rightExpression the right expression
     */
    public Mult(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Expression leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param left  the left
     * @param right the right
     */
    public Mult(Expression left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Expression leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Double leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(String leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(int leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(int leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(int leftExpression, double right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(int leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Double leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Double leftExpression, double right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(Double leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(String leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(String leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Mult.
     * the function creates MUlt object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Mult(String leftExpression, double right) {
        super(leftExpression, right);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double leftMult = this.getLeftExpression().evaluate(assignment);
        double rightMult = this.getRightExpression().evaluate(assignment);
        return leftMult * rightMult;
    }

    @Override
    public double evaluate() throws Exception {
        double leftMult = this.getLeftExpression().evaluate();
        double rightMult = this.getRightExpression().evaluate();
        return leftMult * rightMult;
    }

    @Override
    public String toString() {
        return "(" + this.getLeftExpression().toString() + " * " +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Mult(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        Expression leftDifferentiate = new Mult(this.getLeftExpression()
                .differentiate(var), this.getRightExpression());
        Expression rightDifferentiate = new Mult(this.getLeftExpression(),
                this.getRightExpression().differentiate(var));
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
            return new Num(evaluateLeftExpression * evaluateRightExpression);

            //in case the left expression is 0 or 1 and the right not simply.
        } catch (Exception e1) {
            try {
                evaluateLeftExpression = simplifyLeftExpression.evaluate();
                if (evaluateLeftExpression == ZERO) {
                    return new Num(ZERO);
                }
                if (evaluateLeftExpression == ONE) {
                    return simplifyRightExpression;
                }

                //in case the right expression is 0 or 1 and the left not
                // simply.
            } catch (Exception e2) {
                try {
                    evaluateRightExpression =
                            simplifyRightExpression.evaluate();
                    if (evaluateRightExpression == ZERO) {
                        return new Num(ZERO);
                    }
                    if (evaluateRightExpression == ONE) {
                        return simplifyLeftExpression;
                    }

                    //if the expression are equals.
                } catch (Exception e3) {
                    if (simplifyLeftExpression.toString().equals
                            (simplifyRightExpression.toString())) {
                        return new Pow(simplifyLeftExpression,
                                EQUAL);
                    }

                    //checking if the opposite is equal.
                    if (simplifyLeftExpression.isBinary() &&
                            this.getRightExpression().isBinary()) {
                        if (simplifyLeftExpression.opposite().toString().equals
                                (simplifyRightExpression.toString())) {
                            return new Pow(simplifyLeftExpression,
                                    EQUAL);
                        }
                    }
                }
            }
            return new Mult(simplifyLeftExpression, simplifyRightExpression);
        }
    }

    @Override
    public Expression opposite(){
        return new Mult(this.getRightExpression(), this.getLeftExpression());
    }
}
