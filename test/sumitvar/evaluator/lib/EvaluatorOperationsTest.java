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
}
