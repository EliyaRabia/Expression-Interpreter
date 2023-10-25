//Name: Eliya Rabia.
//ID: 318771052.

import java.util.Map;

/**
 * The type Minus.
 * this class is about Minus.
 */
public class Minus extends BinaryExpression implements Expression{

    //represent the number 0.
    public static final int ZERO = 0;

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression  the left expression
     * @param rightExpression the right expression
     */
    public Minus(Expression leftExpression, Expression rightExpression){
        super(leftExpression, rightExpression);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Expression leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param left  the left
     * @param right the right
     */
    public Minus(Expression left, double right) {
        super(left, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Expression leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Double leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(String leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(int leftExpression, Expression right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(int leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(int leftExpression, double right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(int leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Double leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Double leftExpression, double right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(Double leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(String leftExpression, int right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(String leftExpression, String right) {
        super(leftExpression, right);
    }

    /**
     * Instantiates a new Minus.
     * the function creates Minus object.
     *
     * @param leftExpression the left expression
     * @param right          the right
     */
    public Minus(String leftExpression, double right) {
        super(leftExpression, right);
    }


    @Override
    public Expression assign(String var, Expression expression){
        return new Minus(this.getLeftExpression().assign(var, expression),
                this.getRightExpression().assign(var, expression));
    }

    @Override
    public String toString(){
        return "(" + this.getLeftExpression().toString() + " - " +
                this.getRightExpression().toString() + ")";
    }

    @Override
    public double evaluate() throws Exception{
        double leftValue = this.getLeftExpression().evaluate();
        double rightValue = this.getRightExpression().evaluate();
        return leftValue - rightValue;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception{
        double leftValue = this.getLeftExpression().evaluate(assignment);
        double rightValue = this.getRightExpression().evaluate(assignment);
        return leftValue - rightValue;
    }

    @Override
    public Expression differentiate(String var){
        Expression leftDifferentiate =
                this.getLeftExpression().differentiate(var);
        Expression rightDifferentiate =
                this.getRightExpression().differentiate(var);
        return new Minus(leftDifferentiate, rightDifferentiate);
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
            return new Num(evaluateLeftExpression - evaluateRightExpression);

            //in case left expression is 0 and the right not simply.
        } catch (Exception e1) {
            try{
                evaluateLeftExpression = simplifyLeftExpression.evaluate();
                if(evaluateLeftExpression == ZERO){
                    return new Neg(simplifyRightExpression);
                }

                //in case right expression is 0 and the left not simply.
            } catch (Exception e2){
                try {
                    evaluateRightExpression =
                            simplifyRightExpression.evaluate();
                    if(evaluateRightExpression == ZERO){
                        return simplifyLeftExpression;
                    }

                    //in case the expression are equal.
                } catch (Exception e3){
                    if (simplifyLeftExpression.toString().equals
                            (simplifyRightExpression.toString())){
                        return new Num(ZERO);
                    }

                    //checking if the opposite is equal.
                    if (simplifyLeftExpression.isBinary() &&
                            this.getRightExpression().isBinary()) {
                        if (simplifyLeftExpression.opposite().toString().equals
                                (simplifyRightExpression.toString())) {
                            return new Num(ZERO);
                        }
                    }
                }
            }
        }
        return new Minus(simplifyLeftExpression, simplifyRightExpression);
    }

    @Override
    public Expression opposite(){
        return new Minus(this.getRightExpression(),this.getLeftExpression());
    }
}
