package sumitvar.evaluator.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void handleSpacesCase1() throws Exception {
        String arg = "-10.0+((20.0+-5.0))";
        String expected = "-10.0 + ( ( 20.0 + -5.0 ) )";
        Parser parser = new Parser(arg);
        String result = parser.getEvaluableExpresssion();
        assertEquals(expected, result);
    }

    @Test
    public void handleSpacesCase2() throws Exception {
        String arg = "53 -(63+32)-(-534)";
        String expected = "53 - ( 63 + 32 ) - ( -534 )";
        Parser parser = new Parser(arg);
        String result = parser.getEvaluableExpresssion();
        assertEquals(expected, result);
    }

    @Test
    public void handleSpacesCase3() throws Exception {
        String arg = "-10.0+ (( 20.0 +-5.0))";
        String expected = "-10.0 + ( ( 20.0 + -5.0 ) )";
        Parser parser = new Parser(arg);
        String result = parser.getEvaluableExpresssion();
        assertEquals(expected, result);
    }
}