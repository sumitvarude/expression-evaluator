package sumitvar.evaluator.lib;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EvaluatorOperationsTest {
    @Test
    public void getOperandsWillGivesOperands() throws Exception {
        String[] arg = {"2", "+", "3"};
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
        String[] arg = {"2", "+", "3"};
        float expected = 5.0f;
        EvaluatorOperations op = new EvaluatorOperations();

        float result = op.executeEvaluator(arg);
        assertEquals(expected,result , 0.0);
    }

    @Test
    public void executeEvaluatorWillGiveAdditionOfMultipleNumbers() throws Exception {
        String[] arg = {"2", "+", "3", "+", "5"};
        float expected = 10.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.executeEvaluator(arg);
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
        String[] arg = {"3", "-", "1", "*", "5","/","2","^","2"};
        float expected = 25.0f;
        EvaluatorOperations  op = new EvaluatorOperations();

        float result = op.executeEvaluator(arg);
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
    public void getExpressionFromBracketsWillGiveExpressionFromBracket() throws Exception {
        String expression = "10+(5+3)";
        String expected = "5+3";
        EvaluatorOperations  op = new EvaluatorOperations();
        String result = op.getExpressionFromBrackets(expression);
        assertEquals(expected,result);
    }
}
