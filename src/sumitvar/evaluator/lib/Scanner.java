package sumitvar.evaluator.lib;

import java.util.List;
import java.util.Arrays;

public class Scanner {
    private String expression;
    int index;
    Character[] symbols = {'+','-','*','/','^','(',')'};
    Character[] numbers = {'0','1','2','3','4','5','6','7','8','9','.'};
    List<Character> numberList = Arrays.asList(numbers);
    List<Character> operatorsList = Arrays.asList(symbols);
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
        Character nextCharacter = expression.charAt(index);
        if(nextCharacter.equals(' ')){
            index++;
            return next();
        }
        if(operatorsList.contains(nextCharacter)){
            index++;
            return nextCharacter.toString();
        }
        int indexForNumbers = index;
        while(numberList.contains(nextCharacter)){
            indexForNumbers = indexForNumbers + 1;
            if(indexForNumbers > expression.length()-1){
                break;
            }
            nextCharacter = expression.charAt(indexForNumbers);
        }
        String number = expression.substring(index,indexForNumbers);
        index = indexForNumbers;
        return number;
    }
}

