package sumitvar.evaluator.lib;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void testConvertExpressionHavingTwoOperandsAndAdditionOperatorToPostfix() throws Exception {
        String expression = "33 + 45";
        String[] expectedArray = {"33", "45", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithOnlyOneNumber() throws Exception {
        String expression = "3";
        String[] expectedArray = {"3"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndMultiplicationOperatorToPostfix() throws Exception {
        String expression = "3 * 4";
        String[] expectedArray = {"3", "4", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumbers() throws Exception {
        String expression = "3.3 / 4.4";
        String[] expectedArray = {"3.3", "4.4", "/"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumberAndPowerOperator() throws Exception {
        String expression = "1100.2 ^ 34.2";
        String[] expectedArray = {"1100.2", "34.2", "^"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4";
        String[] expectedArray = {"2", "3", "+", "4", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        Parser converter = new Parser(expression);

        List<String> postfix = converter.getPostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testShouldCheckEqualityOfSingleValuedExpression() {
        String expression = "3";
        Parser parser = new Parser(expression);
        Expression expected = new Expression(3.0);

        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }

    @Test
    public void testParsingOfExpressionHavingLeftAndRight(){
        String expression = "1 + 1";
        Parser parser = new Parser(expression);
        Expression expected = new Expression(new Expression(1),new Expression(1),new AdditionOperation());

        Expression actual = parser.giveExpression();

        assertEquals(expected, actual);
    }

    @Test
    public void testParsingOfExpressionHavingThreeOperands() {
        String expression = "1 + 2 * 3";
        Parser parser = new Parser(expression);
        Expression firstExp = new Expression(new Expression(1),new Expression(2),new AdditionOperation());
        Expression expected = new Expression(firstExp,new Expression(3),new MultiplicationOperation());

        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }

    @Test
    public void testParsingOfExpressionHavingBrackets() {
        String expression = "( 2 * 3 )";
        Parser parser = new Parser(expression);
        Expression expected = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());

        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }

    @Test
    public void testParsingOfExpressionHavingMultipleBrackets() {
        String expression = "( 2 * 3 ) * ( 2 * 3 )";
        Parser parser = new Parser(expression);
        Expression expOne = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());
        Expression expTwo = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());

        Expression expected = new Expression(expOne,expTwo,new MultiplicationOperation());
        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }

    @Test
    public void testParsingOfExpressionHavingNestedBrackets() {
        String expression = "( 2 * 3 / ( 1 * 2 ) )";
        Parser parser = new Parser(expression);

        Expression expOne = new Expression(new Expression(1),new Expression(2),new MultiplicationOperation());
        Expression expTwo = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());
        Expression expected = new Expression(expTwo,expOne,new DivisionOperation());
        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }

    @Test
    public void testParsingExpressionWithoutSpaces() {
        String expression = "(2*3/(1*2))";
        Parser parser = new Parser(expression);

        Expression expOne = new Expression(new Expression(1),new Expression(2),new MultiplicationOperation());
        Expression expTwo = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());
        Expression expected = new Expression(expTwo,expOne,new DivisionOperation());
        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);

    }
    @Test
    public void testParsingExpressionWithSpacesAtLast() {
        String expression = "(2*3/(1*2)) ";
        Parser parser = new Parser(expression);

        Expression expOne = new Expression(new Expression(1),new Expression(2),new MultiplicationOperation());
        Expression expTwo = new Expression(new Expression(2),new Expression(3),new MultiplicationOperation());
        Expression expected = new Expression(expTwo,expOne,new DivisionOperation());
        Expression actual = parser.giveExpression();

        assertEquals(expected,actual);
    }
}