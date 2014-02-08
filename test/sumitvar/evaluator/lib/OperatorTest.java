package sumitvar.evaluator.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorTest {
    @Test
    public void addOperandsWillAddTwoNumbers() throws Exception {
        double one = 1.0, two = 2.0, expected = 3.0;
        double result = new AdditionOperation().operate(new Expression(one),new Expression(two));
        assertEquals(result, expected, 0.0);
    }

    @Test
    public void subtractOperandsWillSubtractTwoNumbers() throws Exception {
        double one = 2.0, two = 1.0, expected = 1.0;
        double result = new SubtractionOperation().operate(new Expression(one),new Expression(two));
        assertEquals(result, expected, 0.0);
    }

    @Test
    public void multiplyOperandsWillMultiplyTwoNumbers() throws Exception {
        double one = 2.0, two = 3.0, expected = 6.0;
        double result = new MultiplicationOperation().operate(new Expression(one),new Expression(two));
        assertEquals(result, expected, 0.0);
    }

    @Test
    public void divideOperandsWillDivideTwoNumbers() throws Exception {
        double one = 6.0, two = 3.0, expected = 2.0;
        double result = new DivisionOperation().operate(new Expression(one),new Expression(two));
        assertEquals(result, expected, 0.0);
    }

    @Test
    public void getPowerWillGivePowerOfOperand() throws Exception {
        double operand = 4.0, power = 2.0, expected = 16.0;
        double result = new PowerOperation().operate(new Expression(operand), new Expression(power));
        assertEquals(result, expected, 0.0);
    }

    @Test
    public void testEvaluateComplexExpression() {
        Expression expressionToEvaluate = new Expression(
            new Expression(new Expression(3),new Expression(2),new AdditionOperation()),
            new Expression(new Expression(3),new Expression(2),new MultiplicationOperation()),
                new AdditionOperation()
        );

        assertEquals(11.0,expressionToEvaluate.evaluate(),0.0);
    }
}
