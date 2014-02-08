package sumitvar.evaluator.lib;

/**
 * Created by sumitvar on 2/7/14.
 */
public class SubtractionOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return left.evaluate() - right.evaluate();
    }
}
