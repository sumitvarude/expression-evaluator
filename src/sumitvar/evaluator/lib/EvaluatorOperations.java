package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.List;

public class EvaluatorOperations {
    public boolean hasFloat(String[] arg){
        for (int i = 0; i < arg.length; i++) {
            if(arg[i].contains("."))
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
    public float executeEvaluator(String[] arg) {
        List<Float> operands = getOperands(arg);
        List<String > operator = getOperators(arg);
        float temp = operands.get(0);
        int j = 0;
        for (int i = 0; i < operands.size()-1; i++) {
            String s = operator.get(j);
            if (s.equals("+"))
                temp = addOperands(temp, operands.get(i+1));
            if(s.equals("-"))
                temp = subtractOperands(temp, operands.get(i + 1));
            if(s.equals("*"))
                temp = multiplyOperands(temp, operands.get(i + 1));
            if(s.equals("/"))
                temp = divideOperands(temp, operands.get(i + 1));
            if(s.equals("^"))
                temp = getPower(temp, operands.get(i + 1));
            j++;
        }
        return temp;
    }
}

