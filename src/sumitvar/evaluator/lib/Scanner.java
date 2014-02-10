package sumitvar.evaluator.lib;

import java.util.List;
import java.util.Arrays;

public class Scanner {
    private String expression;
    int index;
    String[] symbols = {"+","-","*","/","^","(",")"};
    String[] numbers = {"0","1","2","3","4","5","6","7","8","9","."};
    List<String> numberList = Arrays.asList(numbers);
    List<String> operatorsList = Arrays.asList(symbols);
    public Scanner(String expression) {
        this.expression = expression;
        index = 0;
    }

    public boolean hasNext() {
        if(index > expression.length()-1)
            return false;
        return true;
    }

    public String next() {
        if(!hasNext())
            return null;
        String nextCharacter = expression.substring(index, index + 1);
        if(nextCharacter.equals(" ")){
            index++;
            return next();
        }
        if(operatorsList.contains(nextCharacter)){
            index++;
            return nextCharacter;
        }
        if(numberList.contains(nextCharacter)){
            int indexForNumbers = index;
            while (numberList.contains(nextCharacter)){
                indexForNumbers = indexForNumbers + 1;
                if(indexForNumbers > expression.length()-1){
                    String lastNumber =  expression.substring(index);
                    index = indexForNumbers;
                    return lastNumber;
                }
                nextCharacter = expression.substring(indexForNumbers,indexForNumbers+1);
            }
            String number = expression.substring(index,indexForNumbers);
            index = indexForNumbers;
            return number;
        }
        return null;
    }
}

