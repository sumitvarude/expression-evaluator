package sumitvar.evaluator.lib.operations;

import sumitvar.evaluator.lib.Expression;

/**
 * Created by sumitvar on 2/7/14.
 */
public class MultiplicationOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return left.evaluate() * right.evaluate();
    }
}
