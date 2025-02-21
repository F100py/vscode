package Calculator.Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Calculator.NumCalc;

public class NumCalcTest {
    @Test
    public void testAddition() {
        NumCalc calc = new NumCalc("3 + 2");
        assertEquals("5.0", calc.evaluate());
    }

    @Test
    public void testSubtraction() {
        NumCalc calc = new NumCalc("5 - 2");
        assertEquals("3.0", calc.evaluate());
    }

    @Test
    public void testMultiplication() {
        NumCalc calc = new NumCalc("3 * 2");
        assertEquals("6.0", calc.evaluate());
    }

    @Test
    public void testDivision() {
        NumCalc calc = new NumCalc("6 / 2");
        assertEquals("3.0", calc.evaluate());
    }

    @Test(expected = RuntimeException.class)
    public void testDivisionByZero() {
        NumCalc calc = new NumCalc("6 / 0");
        calc.evaluate();
    }

    @Test
    public void testModulo() {
        NumCalc calc = new NumCalc("5 % 2");
        assertEquals("1.0", calc.evaluate());
    }

    @Test
    public void testPower() {
        NumCalc calc = new NumCalc("2 ^ 3");
        assertEquals("8.0", calc.evaluate());
    }

    @Test(expected = RuntimeException.class)
    public void testUnrecognizedToken() {
        NumCalc calc = new NumCalc("3 $ 2");
        calc.evaluate();
    }

    @Test(expected = RuntimeException.class)
    public void testWrongOperands() {
        NumCalc calc = new NumCalc("3 + + 2");
        calc.evaluate();
    }
}
