package sumitvar.evaluator.lib;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EvaluatorOperationsTest {
    @Test
    public void getOperandsWillGivesOperands() throws Exception {
        String[] arg = {"2", "-", "3"};
        List<Double> expected = new ArrayList();
        expected.add(2.00);
        expected.add(3.00);
        List<Double> operands = new EvaluatorOperations("").getOperands(arg);
        assertEquals(expected, operands);
    }

    @Test
    public void getOperatorsWillGivesArithmeticSymbols() throws Exception {
        String[] arg = {"2", "+", "3", "-", "6"};
        List<String> expected = new ArrayList();
        expected.add("+");
        expected.add("-");

        List<String> operators = new EvaluatorOperations("").getOperators(arg);
        assertEquals(expected, operators);
    }

    @Test
    public void executeEvaluatorWillGiveAdditionOfTwoNumbers() throws Exception {
        String arg = "2 + 3";
        double expected = 5.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);

        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void executeEvaluatorWillGiveAdditionOfMultipleNumbers() throws Exception {
        String arg = "2 + 3 + 5";
        double expected = 10.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);

        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void executeEvaluatorWillGivesMultiplicationOfMultipleNumbers() throws Exception {
        String arg = "10 * 3 * 2";
        double expected = 60.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);

        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void executeEvaluatorWillGivesDivisionAndPowerOfMultipleNumbers() throws Exception {
        String arg = "10 / 2 ^ 2";
        double expected = 25.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);

        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void executeEvaluatorWillEvaluateExpressionNotHavingBracket() throws Exception {
        String arg = "3 - 1 * 5 / 2 ^ 2";
        double expected = 25.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);

        double result = op.evaluate();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionHavingBracketsWillGiveAddition() throws Exception {
        String arg = "3 + ( 50 + 3 )";
        double expected = 56.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionHavingSinglePairOfBracket() throws Exception {
        String arg = "3 + ( 50 / 2 )";
        double expected = 28.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndIntegers() throws Exception {
        String arg = "3 + ( 50 / 2 ) + ( 2 - 1 )";
        double expected = 29.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndDecimal() throws Exception {
        String arg = "3.0 + ( 50.0 / 2.0 ) + ( 2.0 - 1.0 )";
        double expected = 29.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingMultipleBracketsAndNegativeIntegers() throws Exception {
        String arg = "-10 + ( 20 + -10 )";
        double expected = 0.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingNestedBracketsAndNegativeIntegers() throws Exception {
        String arg = "-10 + ( ( 20 + -10 ) )";
        double expected = 0.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkForExpressionHavingNestedBracketsAndNegativeDecimals() throws Exception {
        String arg = "-10.0 + ( ( 20.0 + -5.0 ) )";
        double expected = 5.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void evaluateExpressionWillWorkWithoutSpacesInBetween() throws Exception {
        String arg = "4 - -4";
        double expected = 8.0;
        EvaluatorOperations op = new EvaluatorOperations(arg);
        double result = op.evaluateExpression();
        assertEquals(expected, result, 0.0);
    }


}
