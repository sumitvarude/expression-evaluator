package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.List;

public class EvaluatorOperations {
   public List<Float> getOperands(String[]arg){
       List<Float> operands = new ArrayList();
       for (int i = 0; i < arg.length ; i++) {
            if(arg[i].matches("[0-9]+"))
                operands.add(Float.parseFloat(arg[i]));
       }
       return operands;
   }
    public List<String> getOperators(String[]arg){
        List<String> operators = new ArrayList<String>();
        for (int i = 0; i < arg.length; i++) {
            try{
                float temp = Float.parseFloat(arg[i]);
            }
            catch(Exception e){
                operators.add(arg[i]);
            }
        }
        return operators;
    }
    public float addOperands(float a,float b){
        return a+b;
    }
    public float executeEvaluator(String[]arg){
        List<Float> operands = getOperands(arg);
        List<String> operator = getOperators(arg);
        return addOperands(operands.get(0),operands.get(1));
    }
}

