package sumitvar.evaluator.lib.operations;

import sumitvar.evaluator.lib.Expression;

public class AdditionOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return left.evaluate() + right.evaluate();

    }
}
