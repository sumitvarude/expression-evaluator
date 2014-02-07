package sumitvar.evaluator.lib;

/**
 * Created by sumitvar on 2/7/14.
 */
public class PowerOperation implements BinaryOperation {
    @Override
    public double operate(double number1, double number2) {
        return Math.pow(number1,number2);
    }
}
