package sumitvar.evaluator.lib;

public class AdditionOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return left.evaluate() + right.evaluate();

    }
}
