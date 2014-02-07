package sumitvar.evaluator.main;

import sumitvar.evaluator.lib.EvaluatorOperations;
import sumitvar.evaluator.lib.Parser;

public class Evaluator {
    public static void main(String[] args) {
        Parser parser = new Parser(args[0].trim());
        EvaluatorOperations operation = new EvaluatorOperations(parser.getEvaluableExpresssion());
        double result =  operation.evaluateExpression();
        System.out.println(result);
    }
}
