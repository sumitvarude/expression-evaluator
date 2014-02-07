package sumitvar.evaluator.lib;

/**
 * Created by sumitvar on 2/7/14.
 */
public class SubtractionOperation implements BinaryOperation{
    @Override
    public double operate(double number1, double number2) {
        return number1 - number2;
    }
}
