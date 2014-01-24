package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.List;

public class EvaluatorOperations {
    public boolean hasFloat(String[] org) {
        for (int i = 0; i < org.length; i++) {
            if (org[i].contains("."))
                return true;
        }
        return false;
    }

    public List<Float> getOperands(String[] arg) {
        List<Float> operands = new ArrayList();
        for (int i = 0; i < arg.length; i++) {
            try {
                operands.add(Float.parseFloat(arg[i]));
            } catch (Exception e) {
            }
        }

        return operands;
    }

    public List<String> getOperators(String[] arg) {
        List<String> operators = new ArrayList();
        for (int i = 0; i < arg.length; i++) {
            try {
                float temp = Float.parseFloat(arg[i]);
            } catch (Exception e) {
                operators.add(arg[i]);
            }
        }
        return operators;
    }

    public float addOperands(float a, float b) {
        return a + b;
    }

    public float subtractOperands(float a, float b) {
        return a - b;
    }

    public float multiplyOperands(float a, float b) {
        return a * b;
    }

    public float divideOperands(float a, float b) {
        return a / b;
    }

    public float getPower(float operand, float power) {
        float result = 1.0f;
        for (int i = 0; i < (int) power; i++) {
            result = result * operand;
        }
        return result;
    }



    public String joinExpression(String[] arg) {
        StringBuilder joinedExpression = new StringBuilder();
        for (int i = 0; i < arg.length; i++) {
            joinedExpression.append(arg[i]);
        }
        return joinedExpression.toString();
    }

    public String reduceSpaces(String arg) {
        String fileData = arg;
        fileData = fileData.replaceAll("[ ]+", "");
        return fileData;
    }
    public String getExpressionFromBrackets(String arg,int startIndex,int endIndex){
        String expression  = arg;
        String expressionInBracket = expression.substring(startIndex,endIndex);
        return expressionInBracket;
    }
    public String[] swapArrayElementsByOne(String[]arg){
        String temp[] = new String[arg.length-1];
        for (int i = 0; i < arg.length-1; i++) {
            temp[i] = arg[i+1];
        }
        return temp;
    }
    public float evaluate(String arg) {
        arg = arg.trim();
        String[] elementList = arg.split(" ");
        List<Float> operands = getOperands(elementList);
        List<String> operator = getOperators(elementList);
        float temp = operands.get(0);
        int j = 0;
        for (int i = 0; i < operands.size() - 1; i++) {
            String s = operator.get(j);
            if (s.equals("+"))
                temp = addOperands(temp, operands.get(i + 1));
            if (s.equals("-"))
                temp = subtractOperands(temp, operands.get(i + 1));
            if (s.equals("*"))
                temp = multiplyOperands(temp, operands.get(i + 1));
            if (s.equals("/"))
                temp = divideOperands(temp, operands.get(i + 1));
            if (s.equals("^"))
                temp = getPower(temp, operands.get(i + 1));
            j++;
        }
        return temp;
    }

    public float evaluateExpression(String wholeExpression) {
        float finalResult = 0.0f;
        int indexOfOpeningBracket=-1,indexOfClosingBracket=-1;
        wholeExpression = wholeExpression.trim();
        String[] elementList = wholeExpression.split("");
        if(true == wholeExpression.contains("(")){
            for (int i = 0; i < wholeExpression.length(); i++) {
                if(wholeExpression.charAt(i)=='('){
                    indexOfOpeningBracket = i;
                }
                if(wholeExpression.charAt(i)==')'){
                    indexOfClosingBracket = i;
                    break;
                }
            }
            String expressionFromBrackets = getExpressionFromBrackets(wholeExpression,indexOfOpeningBracket+2,indexOfClosingBracket-1);
            float result = evaluate(expressionFromBrackets.trim());

            String modifiedExpression = wholeExpression.replace("( "+expressionFromBrackets+" )",String.valueOf(result));
            return evaluateExpression(modifiedExpression);
        }
        else{
            finalResult = evaluate(wholeExpression);
        }
        return finalResult;
    }
}

