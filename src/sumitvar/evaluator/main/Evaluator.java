package sumitvar.evaluator.main;

import sumitvar.evaluator.lib.EvaluatorOperations;

public class Evaluator {
    public static void main(String[] args) {
        EvaluatorOperations operation = new EvaluatorOperations();
        float result =  operation.executeEvaluator(args);
        System.out.println(result);
    }
}
