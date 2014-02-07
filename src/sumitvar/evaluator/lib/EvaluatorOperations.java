package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluatorOperations {

    HashMap<String,BinaryOperation> operatorsMap = new HashMap<String, BinaryOperation>();

    public EvaluatorOperations() {
        operatorsMap.put("+",new AdditionOperation());
        operatorsMap.put("-",new SubtractionOperation());
        operatorsMap.put("*",new MultiplicationOperation());
        operatorsMap.put("/",new DivisionOperation());
        operatorsMap.put("^",new PowerOperation());
    }

    private boolean isNumber(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<Double> getOperands(String[] arg) {
        List<Double> operands = new ArrayList();
        for (int i = 0; i < arg.length; i++) {
            if(isNumber(arg[i]))
                operands.add(Double.parseDouble(arg[i]));
        }
        return operands;
    }

    public List<String> getOperators(String[] arg) {
        List<String> operators = new ArrayList();
        for (int i = 0; i < arg.length; i++) {
            if(!isNumber(arg[i]))
                operators.add(arg[i]);
        }
        return operators;
    }

    public String joinExpression(String[] arg) {
        StringBuilder joinedExpression = new StringBuilder();
        for (int i = 0; i < arg.length; i++) {
            joinedExpression.append(arg[i]);
        }
        return joinedExpression.toString();
    }

    public String getExpressionFromBrackets(String arg, int startIndex, int endIndex) {
        String expression = arg;
        String expressionInBracket = expression.substring(startIndex, endIndex);
        return expressionInBracket;
    }

    public double evaluate(String arg) {
        arg = arg.trim();
        String[] elementList = arg.split(" ");
        List<Double> operands = getOperands(elementList);
        List<String> operator = getOperators(elementList);
        double temp = operands.get(0);
        int j = 0;
        for (int i = 0; i < operands.size() - 1; i++) {
            String s = operator.get(j);
            temp = operatorsMap.get(s).operate(temp,operands.get(i+1));
            j++;
        }
        return temp;
    }

    public double evaluateExpression(String wholeExpression) {
        wholeExpression = handleSpaces(wholeExpression);
        double finalResult = 0.0;
        int indexOfOpeningBracket = -1, indexOfClosingBracket = -1;
        wholeExpression = wholeExpression.trim();
        if (true == wholeExpression.contains("(")) {
            for (int i = 0; i < wholeExpression.length(); i++) {
                if (wholeExpression.charAt(i) == '(') {
                    indexOfOpeningBracket = i;
                }
                if (wholeExpression.charAt(i) == ')') {
                    indexOfClosingBracket = i;
                    break;
                }
            }
            String expressionFromBrackets = getExpressionFromBrackets(wholeExpression, indexOfOpeningBracket + 2, indexOfClosingBracket - 1);
            double result = evaluate(expressionFromBrackets.trim());

            String modifiedExpression = wholeExpression.replace("( " + expressionFromBrackets + " )", String.valueOf(result));
            return evaluateExpression(modifiedExpression);
        }
        else {
            finalResult = evaluate(wholeExpression);
        }
        return finalResult;
    }

    public String handleSpaces(String arg) {
        arg = arg.trim();
        arg = arg.replaceAll("\\+", " + ");
        arg = arg.replaceAll("\\-", " - ");
        arg = arg.replaceAll("\\*", " * ");
        arg = arg.replaceAll("\\^", " ^ ");
        arg = arg.replaceAll("\\(", " ( ");
        arg = arg.replaceAll("\\)", " ) ");
        arg = arg.replaceAll("/", " / ");
        arg = arg.replaceAll("  - ", " -");
        arg = arg.replaceAll(" -  "," -");
        arg = arg.replaceAll("[ ]+"," ");
        arg = arg.trim();
        if (arg.charAt(0) == '-' && arg.charAt(1) == ' ')
            arg = arg.replaceFirst("- ", "-");

        return arg;
    }
}
