//Name: Eliya rabia
//ID: 318771052

import java.util.Map;

/**
 * Pow.
 * the class is about the pow object.
 */
public class Pow extends BinaryExpression implements Expression {

    //under zero the number is negative.
    public static final int POSITIVE = 0;

    //represent number 1.
    public static final int ONE = 1;

    //represent exponent = 1.
    public static final int EXPONENT_ONE =1;

    //represent exponent = 0.
    public static final int EXPONENT_ZERO =0;

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Expression base, Expression exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Expression base, int exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Expression base, double exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Expression base, String exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Double base, Expression exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(String base, Expression exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(int base, Expression exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(int base, int exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(int base, double exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(int base, String exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Double base, int exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Double base, double exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(Double base, String exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(String base, int exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(String base, String exponent) {
        super(base, exponent);
    }

    /**
     * Instantiates a new Pow.
     * the function creates Pow object.
     *
     * @param base     the base
     * @param exponent the exponent
     */
    public Pow(String base, double exponent) {
        super(base, exponent);
    }


    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double base = this.getLeftExpression().evaluate(assignment);
        double exponent = this.getRightExpression().evaluate(assignment);
        if (base < POSITIVE) {
            if ((int) exponent != exponent) {
                throw new Exception("Exception : pow(" + this.toString() +
                        ") It is impossible to pow a negative base by not " +
                        "integers exponent");
            }
        }
        return Math.pow(base, exponent);
    }

    @Override
    public double evaluate() throws Exception {
        double base = this.getLeftExpression().evaluate();
        double exponent = this.getRightExpression().evaluate();
        if (base < POSITIVE) {

            //in case the exponent is not an integer.
            if ((int) exponent != exponent) {
                throw new Exception("Exception : pow(" + this.toString() +
                        ") It is impossible to evaluate");
            }
        }
        return Math.pow(base, exponent);
    }

    @Override
    public String toString() {
        return "(" + this.getLeftExpression().toString() + "^" +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Pow(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        Expression currentExponent = this.getRightExpression();

        //in case e is the base and the var in the exponent.
        if (this.getLeftExpression().toString().equals("e") &&
                this.getRightExpression().toString().contains(var)) {
            return new Mult(this,
                    this.getRightExpression().differentiate(var));
        }

        //if the base is sin / cos.
        if(this.getLeftExpression().isCosOrSin() &&
        !this.getRightExpression().toString().contains(var)){
            return new Mult(new Mult(this.getRightExpression(),
                    new Pow(this.getLeftExpression(),
                    new Minus(this.getRightExpression(), new Num(1)))),
                    this.getLeftExpression().differentiate(var));
        }

        //in case the var isn't in the exponent.
        if(!this.getRightExpression().getVariables().contains(var) &&
        this.getLeftExpression().toString().contains(var)){
            Expression differentiateExponent = new Minus(currentExponent,
                    new Num(ONE));
            return new Mult(new Pow(this.getLeftExpression(),
                    differentiateExponent), currentExponent);
        }

        //in case there is an expression in the exponent.
        Expression leftDifferentiate = this.getLeftExpression()
                .differentiate(var);
        Expression rightDifferentiate = this.getRightExpression()
                .differentiate(var);
        Expression rightDivLeft = new Div(this.getRightExpression(),
                this.getLeftExpression());
        Expression lnLeft = new Log(Math.E, this.getLeftExpression());
        Expression expression = this;
        Expression multRight = new Mult(rightDifferentiate, lnLeft);
        Expression multLeft = new Mult(leftDifferentiate, rightDivLeft);
        Expression plus = new Plus(multLeft, multRight);
        return new Mult(expression, plus);
    }

    @Override
    public Expression simplify() {
        Expression simplifyLeftExpression = this.getLeftExpression().simplify();
        Expression simplifyRightExpression =
                this.getRightExpression().simplify();
        double evaluateLeftExpression, evaluateRightExpression;
        try {
            evaluateLeftExpression = simplifyLeftExpression.evaluate();
            evaluateRightExpression = simplifyRightExpression.evaluate();
            Pow p = new Pow(evaluateLeftExpression,
                    evaluateRightExpression);
            return new Num(p.evaluate());
        } catch (Exception e1) {

            try {
                evaluateRightExpression = simplifyRightExpression.evaluate();

                //in case the exponent is 1.
                if (evaluateRightExpression == EXPONENT_ONE) {
                    return simplifyLeftExpression;
                }

                //in case the exponent is 0.
                if (evaluateRightExpression == EXPONENT_ZERO) {
                    return new Num(ONE);
                }
            } catch (Exception e2) {
                return new Pow(simplifyLeftExpression, simplifyRightExpression);
            }
            return new Pow(simplifyLeftExpression, simplifyRightExpression);
        }
    }

    @Override
    public Expression opposite() {
        return new Pow(this.getRightExpression(), this.getLeftExpression());
    }
}
