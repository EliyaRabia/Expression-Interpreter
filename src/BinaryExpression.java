//Name : eliya Rabia.
// ID : 318771052.
import java.util.List;

/**
 * The type Binary expression.
 * this class is about binary expressions.
 */
public abstract class BinaryExpression extends BaseExpression {

    //represent left expression.
    private Expression left;

    //represent right expression.
    private Expression right;


    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Expression left, String right) {
        this.left = left;
        this.right = new Var(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Expression left, double right) {
        this.left = left;
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Expression left, int right) {
        this.left = left;
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Double left, Expression right) {
        this.left = new Num(left);
        this.right = right;
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(String left, Expression right) {
        this.left = new Var(left);
        this.right = right;
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(int left, Expression right) {
        this.left = new Num(left);
        this.right = right;
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Double left, double right) {
        this.left = new Num(left);
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Double left, String right) {
        this.left = new Num(left);
        this.right = new Var(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(Double left, int right) {
        this.left = new Num(left);
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(String left, double right) {
        this.left = new Var(left);
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(int left, double right) {
        this.left = new Num(left);
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(String left, String right) {
        this.left = new Var(left);
        this.right = new Var(right);
    }


    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(String left, int right) {
        this.left = new Var(left);
        this.right = new Num(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(int left, String right) {
        this.left = new Num(left);
        this.right = new Var(right);
    }

    /**
     * Instantiates a new Binary expression.
     * creates binary expression.
     *
     * @param left  the left
     * @param right the right
     */
    protected BinaryExpression(int left, int right) {
        this.left = new Num(left);
        this.right = new Num(right);
    }


    /**
     * Gets left expression.
     * the function returns the left expression.
     *
     * @return the left expression
     */
    public Expression getLeftExpression() {
        return this.left;
    }

    /**
     * Gets right expression.
     * the function returns the right expression.
     *
     * @return the right expression
     */
    public Expression getRightExpression() {
        return this.right;
    }

    @Override
    public List<String> getVariables() {
        List<String> list = this.getLeftExpression().getVariables();
        List<String> rightList = this.getRightExpression().getVariables();

        //will be the indication for unique variable.
        int unique = 0;

        //in case there are no variable in the left expression.
        if (this.getLeftExpression().getVariables().isEmpty()) {
            return rightList;
        }

        //in case there are no variable in the right expression.
        if (this.getRightExpression().getVariables().isEmpty()) {
            return list;
        }

        //in case both have variables.
        for (int i = 0; i < rightList.size(); i++) {
            for (int j = 0; j < list.size(); j++) {

                //make a list with unique variables.
                if (!rightList.get(i).equals(list.get(j))) {
                    unique++;

                    //the variable is unique;
                    if (unique == list.size()) {
                        list.add(rightList.get(i));
                    }
                }
            }
            unique = 0;
        }
        return list;
    }

    @Override
    public boolean isBinary() {
        return true;
    }
}
