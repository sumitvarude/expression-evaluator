package sumitvar.evaluator.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *Parses the expression in the form which is understandable to evaluator
 */
public class Parser {
    private String wholeExpression;
    private HashMap<String,BinaryOperation> operatorsMap = new HashMap<String, BinaryOperation>();

    public Parser(String wholeExpression) {
        this.wholeExpression = wholeExpression;
        operatorsMap.put("+",new AdditionOperation());
        operatorsMap.put("-",new SubtractionOperation());
        operatorsMap.put("*",new MultiplicationOperation());
        operatorsMap.put("/",new DivisionOperation());
        operatorsMap.put("^",new PowerOperation());
    }

    public List<String> getPostfix() {
        List<String> postfix = new ArrayList<String>();
        Scanner scanner = new Scanner(wholeExpression);
        Stack<String> stack = new Stack<String>();
        while(scanner.hasNext()){
            String nextToken = scanner.next();
            if(nextToken == null)
                return postfix;
            if (isNumber(nextToken)) {
                postfix.add(nextToken);
                if (stack.size() != 0 && !(stack.peek().equals("("))) {
                    postfix.add(stack.pop());
                }
                continue;
            }
            if (nextToken.equals(")")) {
                stack.pop();
                if (stack.size() != 0 && !(stack.peek().equals("("))) {
                    postfix.add(stack.pop());
                }
                continue;
            }
            stack.push(nextToken);
        }
        return postfix;
    }

    public Expression giveExpression() {
        List<String> postfixExpression = getPostfix();
        Stack<Expression> expressionStack = new Stack<Expression>();
        BinaryOperation operation;
        for (String expressionPart : postfixExpression) {
            if(isNumber(expressionPart)){
                expressionStack.push(new Expression(Double.parseDouble(expressionPart)));
                continue;
            }

            Expression expression1 = expressionStack.pop();
            Expression expression2 = expressionStack.pop();
            operation = operatorsMap.get(expressionPart);

            Expression resultantExpression = new Expression(expression2,expression1,operation);
            expressionStack.push(resultantExpression);
        }
        return expressionStack.pop();
    }

    private boolean isNumber(String expressionPart) {
        try {
            Double.parseDouble(expressionPart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}