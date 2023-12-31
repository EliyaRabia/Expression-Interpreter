//Name: Eliya Rabia.
//ID: 318771052.

import java.util.Map;
import java.util.List;
public interface Expression {

    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result.  If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    double evaluate(Map<String, Double> assignment) throws Exception;

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    double evaluate() throws Exception;

    // Returns a list of the variables in the expression.
    List<String> getVariables();

    // Returns a nice string representation of the expression.
    String toString();

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    Expression assign(String var, Expression expression);

    // Returns the expression tree resulting from differentiating
    // the current expression relative to variable `var`.
    Expression differentiate(String var);

    // Returned a simplified version of the current expression.
    Expression simplify();

    //return true if the expression is binary else false.
    boolean isBinary();

    //if the expression is binary return the opposite else do nothing
    Expression opposite();

    //return true is cos or sin else false.
    boolean isCosOrSin();
}