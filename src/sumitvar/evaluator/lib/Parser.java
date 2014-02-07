package sumitvar.evaluator.lib;
/**
 *Parses the expression in the form which is understandable to evaluator
 */
public class Parser {
    String wholeExpression;

    public Parser(String wholeExpression) {
        this.wholeExpression = wholeExpression;
    }

    public String getEvaluableExpresssion() {
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
}
