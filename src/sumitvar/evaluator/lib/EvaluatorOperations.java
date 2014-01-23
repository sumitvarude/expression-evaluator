package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.List;

public class EvaluatorOperations {
   public List<Float> getOperands(String[]arg){
       List<Float> operands = new ArrayList();
       for (int i = 0; i < arg.length ; i++) {
           try{
               operands.add(Float.parseFloat(arg[i]));
           }
           catch(Exception e){
           }
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
        float temp = 0.0f;
        for (int i = 0; i <= operator.size() ; i++) {
            temp = addOperands(temp,operands.get(i));
        }
        return temp;
    }
}

