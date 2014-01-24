package sumitvar.evaluator.main;

import sumitvar.evaluator.lib.EvaluatorOperations;

public class Evaluator {
    public static void main(String[] args) {
        EvaluatorOperations operation = new EvaluatorOperations();
        String arg = args[0].trim();
        float result =  operation.salveExpressionHavingBrackets(arg);
        System.out.println(result);
    }
}
