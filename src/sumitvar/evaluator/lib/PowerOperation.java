package sumitvar.evaluator.lib;

/**
 * Created by sumitvar on 2/7/14.
 */
public class PowerOperation extends BinaryOperation {
    @Override
    public double operate(Expression left, Expression right) {
        return Math.pow(left.evaluate(), right.evaluate());
    }
}
