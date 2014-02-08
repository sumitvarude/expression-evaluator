package sumitvar.evaluator.lib;

import java.util.List;

/**
 *Parses the expression in the form which is understandable to evaluator
 */
public class Parser {
    String wholeExpression;
    List<String> sub_expression;
    List<String> operators;

    public Parser(String wholeExpression) {
        this.wholeExpression = wholeExpression;
    }

    public String getEvaluableExpression() {
        String expression = this.wholeExpression;
        expression = expression.trim();
        expression = expression.replaceAll("\\+", " + ");
        expression = expression.replaceAll("\\-", " - ");
        expression = expression.replaceAll("\\*", " * ");
        expression = expression.replaceAll("\\^", " ^ ");
        expression = expression.replaceAll("\\(", " ( ");
        expression = expression.replaceAll("\\)", " ) ");
        expression = expression.replaceAll("/", " / ");
        expression = expression.replaceAll("  - ", " -");
        expression = expression.replaceAll(" -  "," -");
        expression = expression.replaceAll("[ ]+"," ");
        expression = expression.trim();
        if (expression.charAt(0) == '-' && expression.charAt(1) == ' ')
            expression = expression.replaceFirst("- ", "-");
        this.wholeExpression = expression;
        return expression;
    }

    public void get() {
        String expression = this.getEvaluableExpression();
        String expressionParts[] = expression.split(" ");

    }
}