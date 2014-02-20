package sumitvar.evaluator.lib.operations;

import sumitvar.evaluator.lib.Expression;
import sumitvar.evaluator.lib.operations.BinaryOperation;

/**
 * Created by sumitvar on 2/7/14.
 */
public class SubtractionOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return left.evaluate() - right.evaluate();
    }
}
