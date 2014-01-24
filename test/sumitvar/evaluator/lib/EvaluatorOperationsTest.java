package sumitvar.evaluator.lib;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EvaluatorOperationsTest {
    @Test
    public void getOperandsWillGivesOperands() throws Exception {
        String[] arg = {"2","-","3"};
        List<Float> expected = new ArrayList();
        expected.add(2.00f);
        expected.add(3.00f);
        EvaluatorOperations op = new EvaluatorOperations();
        List<Float> operands = op.getOperands(arg);
        assertEquals(expected, operands);
    }

    @Test
    public void getOperatorsWillGivesArithmeticSymbols() throws Exception {
        String[] arg = {"2", "+", "3", "-", "6"};
        List<String> expected = new ArrayList();
        expected.add("+");
        expected.add("-");
        EvaluatorOperations op = new EvaluatorOperations();

        List<String> operators = op.getOperators(arg);
        assertEquals(expected, operators);
    }

    @Test
    public void addOperandsWillAddTwoNumbers() throws Exception {
        float one = 1.0f, two = 2.0f;
        float expected = 3.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.addOperands(one, two);
        assertEquals(result, expected , 0.0);
    }

    @Test
    public void executeEvaluatorWillGiveAdditionOfTwoNumbers() throws Exception {
        String arg = " 2 + 3 ";
        float expected = 5.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.evaluateExpression(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void executeEvaluatorWillGiveAdditionOfMultipleNumbers() throws Exception {
        String arg = "2 + 3 + 5";
        float expected = 10.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.evaluateExpression(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void executeEvaluatorWillGivesSubtractionOfMultipleNumbers() throws Exception {
        String arg = "10 - 3 - 5";
        float expected = 2.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.evaluateExpression(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void executeEvaluatorWillGivesMultiplicationOfMultipleNumbers() throws Exception {
        String arg = "10 * 3 * 2";
        float expected = 60.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.evaluateExpression(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void executeEvaluatorWillGivesDivisionAndPowerOfMultipleNumbers() throws Exception {
        String arg = "10 / 2 ^ 2";
        float expected = 25.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.evaluateExpression(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void subtractOperandsWillSubtractTwoNumbers() throws Exception {
        float one = 2.0f, two = 1.0f;
        float expected = 1.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.subtractOperands(one, two);
        assertEquals(result, expected , 0.0);
    }

    @Test
    public void multiplyOperandsWillMultiplyTwoNumbers() throws Exception {
        float one = 2.0f, two = 3.0f;
        float expected = 6.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.multiplyOperands(one, two);
        assertEquals(result, expected , 0.0);
    }

    @Test
    public void divideOperandsWillDivideTwoNumbers() throws Exception {
        float one = 6.0f, two = 3.0f;
        float expected = 2.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.divideOperands(one, two);
        assertEquals(result, expected , 0.0);
    }

    @Test
    public void getPowerWillGivePowerOfOperand() throws Exception {
        float operand = 3.0f, power = 3.0f;
        float expected = 27.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.getPower(operand, power);
        assertEquals(result, expected , 0.0);
    }

    @Test
    public void executeEvaluatorWillEvaluateExpressionNotHavingBracket() throws Exception {
        String arg = "3 - 1 * 5 / 2 ^ 2";
        float expected = 25.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.evaluate(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void joinExpressionWillJoinTheExpression() throws Exception {
        String[] arg = {"10", "-", "(", "5", "+","3",")"};
        String expected = "10-(5+3)";
        EvaluatorOperations  op = new EvaluatorOperations();

        String result = op.joinExpression(arg);
        assertEquals(expected,result);
    }

    @Test
    public void reduceSpacesWillReduceSpacesFromExpression() throws Exception {
        String arg = "1           0           -            (    5      +      3   )     ";
        String expected = "10-(5+3)";
        EvaluatorOperations  op = new EvaluatorOperations();

        String result = op.reduceSpaces(arg);
        assertEquals(expected,result);
    }

    @Test
    public void swapArrayElementsByOneWillSwapEachElementToPreviousLocation() throws Exception {
        String[] arg = {"", "(", "5", "+", "3", ")"};
        String[] expected = {"(", "5", "+", "3", ")"};
        EvaluatorOperations  op = new EvaluatorOperations();
        String[] result = op.swapArrayElementsByOne(arg);
        Assert.assertArrayEquals(expected,result);
    }

    @Test
    public void getExpressionFromBracketsWillGiveSpecifiedExpression(){
        String arg = "3 + ( 50 + 3 )";
        EvaluatorOperations op = new EvaluatorOperations();
        String result =  op.getExpressionFromBrackets(arg,5,arg.length()-2);
    }

    @Test
    public void evaluateExpressionHavingBracketsWillGiveAddition() throws Exception {
        String arg = "3 + ( 50 + 3 )";
        float expected = 56.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }
    @Test
    public void evaluateExpressionHavingSinglePairOfBracket() throws Exception {
        String arg = " 3 + ( 50 / 2 ) ";
        float expected = 28.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }
    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndIntegers() throws Exception {
        String arg = " 3 + ( 50 / 2 ) + ( 2 - 1 )";
        float expected = 29.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndDecimal() throws Exception {
        String arg = " 3.0 + ( 50.0 / 2.0 ) + ( 2.0 - 1.0 )";
        float expected = 29.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndNegativeIntegers() throws Exception {
        String arg = "-10 + ( 20 + -10 )";
        float expected = 0.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingNestedBracketsAndNegativeIntegers() throws Exception {
        String arg = "-10 + ( ( 20 + -10 ) )";
        float expected = 0.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingNestedBracketsAndNegativeDecimals() throws Exception {
        String arg = "-10.0 + ( ( 20.0 + -5.0 ) )";
        float expected = 5.0f;
        EvaluatorOperations  op = new EvaluatorOperations();
        float result = op.evaluateExpression(arg);
        assertEquals(expected,result,0.0);
    }
}
