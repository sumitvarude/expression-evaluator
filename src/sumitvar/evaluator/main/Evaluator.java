package sumitvar.evaluator.main;

import sumitvar.evaluator.lib.EvaluatorOperations;

public class Evaluator {
    public static void main(String[] args) {
        EvaluatorOperations operation = new EvaluatorOperations(args[0].trim());
        double result =  operation.evaluateExpression();
        System.out.println(result);
    }
}
