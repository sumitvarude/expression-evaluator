package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluatorOperations {

    private String wholeExpression;
    private HashMap<String,BinaryOperation> operatorsMap = new HashMap<String, BinaryOperation>();

    public EvaluatorOperations(String wholeExpression) {
        this.wholeExpression = wholeExpression;
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

    public String getExpressionFromBrackets(int startIndex, int endIndex) {
        String expression = this.wholeExpression;
        String expressionInBracket = expression.substring(startIndex, endIndex);
        return expressionInBracket;
    }

    public double evaluate() {
        String arg = this.wholeExpression;
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
    public double evaluateExpression() {
        Parser parser = new Parser(this.wholeExpression);
        wholeExpression = parser.handleSpaces();
        double finalResult = 0.0;
        int indexOfOpeningBracket = -1, indexOfClosingBracket = -1;
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
            String expressionFromBrackets = getExpressionFromBrackets(indexOfOpeningBracket + 2, indexOfClosingBracket - 1);
            double result = new EvaluatorOperations(expressionFromBrackets.trim()).evaluate();

            String modifiedExpression = wholeExpression.replace("( " + expressionFromBrackets + " )", String.valueOf(result));
            return new EvaluatorOperations(modifiedExpression).evaluateExpression();
        }
        else {
            finalResult = evaluate();
        }
        return finalResult;
    }


}
