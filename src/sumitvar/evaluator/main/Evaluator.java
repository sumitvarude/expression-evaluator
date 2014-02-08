package sumitvar.evaluator.main;


import sumitvar.evaluator.lib.Expression;
import sumitvar.evaluator.lib.Parser;

public class Evaluator {
    public static void main(String[] args) {
        Parser parser = new Parser(args[0].trim());
        Expression expression = parser.giveExpression();
        System.out.println(expression.evaluate());
    }
}
