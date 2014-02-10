package sumitvar.evaluator.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ScannerTest {
    @Test
    public void testScannerWithOnlyOneOperator() {
        String expression = "+";
        Scanner scanner = new Scanner(expression);
        assertEquals(true, scanner.hasNext());
        assertEquals("+", scanner.next());
        assertEquals(false, scanner.hasNext());
    }

    @Test
    public void testWithTwoOperandsAndOneOperator() {
        String expression = "2+3";
        Scanner scanner = new Scanner(expression);
        assertEquals(true, scanner.hasNext());
        assertEquals("2", scanner.next());
        assertEquals("+", scanner.next());
        assertEquals("3", scanner.next());
    }

    @Test
    public void testWithMultipleDigitOperands() {
        String expression = "33 + 45";
        Scanner scanner = new Scanner(expression);
        assertEquals(true, scanner.hasNext());
        assertEquals("33", scanner.next());
        assertEquals("+", scanner.next());
        assertEquals("45", scanner.next());
        assertEquals(null,scanner.next());
    }

    @Test
    public void testScannerShouldAvoidEmptySpaces() {
        String expression = "  23 +   456";
        Scanner scanner = new Scanner(expression);
        assertEquals(true, scanner.hasNext());
        assertEquals("23", scanner.next());
        assertEquals("+", scanner.next());
        assertEquals("456", scanner.next());
    }

    @Test
    public void testScannerNextMethodWhenNothingIsAvailable() {
        String expression = " ";
        Scanner scanner = new Scanner(expression);
        assertEquals(null, scanner.next());
    }

    @Test
    public void testScannerWhenBracketsAreGiven() {
        String expression = "22 + ( 33 * 44 ) ";
        Scanner scanner = new Scanner(expression);
        assertEquals("22", scanner.next());
        assertEquals("+", scanner.next());
        assertEquals("(", scanner.next());
        assertEquals("33", scanner.next());
        assertEquals("*", scanner.next());
        assertEquals("44", scanner.next());
        assertEquals(")", scanner.next());
        assertEquals(null, scanner.next());
        assertEquals(false, scanner.hasNext());
    }

    @Test
    public void testScannerWithFloatingPointNumber() {
        String expression = "3.3 / 4.4";
        Scanner scanner = new Scanner(expression);
        assertEquals("3.3", scanner.next());
        assertEquals("/", scanner.next());
        assertEquals("4.4", scanner.next());
        assertEquals(null,scanner.next());
    }
}