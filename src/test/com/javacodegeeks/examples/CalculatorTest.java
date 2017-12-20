package com.javacodegeeks.examples;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    private void clickNumericKeyTest(String keyText) {
        calculator.clickKey(keyText);
        assertEquals(keyText, calculator.getText());
    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void clickKey0Test() {
        clickNumericKeyTest("0");
    }

    @Test
    public void clickKey1Test() {
        clickNumericKeyTest("1");
    }

    @Test
    public void clickKey2Test() {
        clickNumericKeyTest("2");
    }

    @Test
    public void clickKey3Test() {
        clickNumericKeyTest("3");
    }

    @Test
    public void clickKey4Test() {
        clickNumericKeyTest("4");
    }

    @Test
    public void clickKey5Test() {
        clickNumericKeyTest("5");
    }

    @Test
    public void clickKey6Test() {
        clickNumericKeyTest("6");
    }

    @Test
    public void clickKey7Test() {
        clickNumericKeyTest("7");
    }

    @Test
    public void clickKey8Test() {
        clickNumericKeyTest("8");
    }

    @Test
    public void clickKey9Test() {
        clickNumericKeyTest("9");
    }

    @Test
    public void clickPercentTest() {
        // 7 % 3 = 1
        calculator.clickKey("7");
        calculator.clickKey("%");
        calculator.clickKey("3");
        calculator.clickKey("=");
        assertEquals("1", calculator.getText());
    }

    @Test
    public void clickDivideTest() {
        // 12 / 4 = 3
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("/");
        calculator.clickKey("4");
        calculator.clickKey("=");
        assertEquals("3", calculator.getText());
    }

    @Test
    public void clickMultiplyTest() {
        // 25 * 3 = 75
        calculator.clickKey("2");
        calculator.clickKey("5");
        calculator.clickKey("*");
        calculator.clickKey("3");
        calculator.clickKey("=");
        assertEquals("75", calculator.getText());
    }

    @Test
    public void clickSubtractTest() {
        // 97 - 36 = 61
        calculator.clickKey("9");
        calculator.clickKey("7");
        calculator.clickKey("-");
        calculator.clickKey("3");
        calculator.clickKey("6");
        calculator.clickKey("=");
        assertEquals("61", calculator.getText());
    }

    @Test
    public void clickAddTest() {
        // 12 + 34 = 46
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("+");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("=");
        assertEquals("46", calculator.getText());
    }

    @Test
    public void clickClearTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("c");
        calculator.clickKey("3");
        calculator.clickKey("4");
        assertEquals("34", calculator.getText());
    }

    @Test
    public void clickSignOnceTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("s");
        assertEquals("-12", calculator.getText());
    }

    @Test
    public void clickSignTwiceTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("s");
        calculator.clickKey("s");
        assertEquals("12", calculator.getText());
    }

    @Test
    public void clickSignTwiceAfterNumberTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("s");
        calculator.clickKey("3");
        calculator.clickKey("s");
        assertEquals("123", calculator.getText());
    }

    @Test
    public void clickDigitOnceTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("d");
        calculator.clickKey("3");
        calculator.clickKey("4");
        assertEquals("12.34", calculator.getText());
    }

    @Test
    public void clickDigitTwiceTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("d");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("d");
        assertEquals("12.34", calculator.getText());
    }

    @Test
    public void multipleKeysTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("3");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("5");
        calculator.clickKey("6");
        calculator.clickKey("7");
        calculator.clickKey("8");
        calculator.clickKey("9");
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("5");
        calculator.clickKey("6");
        calculator.clickKey("7");
        calculator.clickKey("8");
        calculator.clickKey("9");
        assertEquals("1233456789123456789", calculator.getText());
    }

    @Test
    public void stringOfCalcsTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("+");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("5");
        calculator.clickKey("-");
        calculator.clickKey("6");
        calculator.clickKey("7");
        calculator.clickKey("/");
        calculator.clickKey("1");
        calculator.clickKey("0");
        calculator.clickKey("*");
        calculator.clickKey("3");
        calculator.clickKey("4");
        calculator.clickKey("=");
        assertEquals("986", calculator.getText());
    }

    @Test
    public void clickDiffOperations1Test() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("+");
        calculator.clickKey("-");
        calculator.clickKey("3");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("90", calculator.getText());
    }

    @Test
    public void clickDiffOperations2Test() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("-");
        calculator.clickKey("%");
        calculator.clickKey("3");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("0", calculator.getText());
    }

    @Test
    public void clickDiffOperations3Test() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("%");
        calculator.clickKey("*");
        calculator.clickKey("3");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("3600", calculator.getText());
    }

    @Test
    public void clickDiffOperations4Test() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("%");
        calculator.clickKey("*");
        calculator.clickKey("3");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("3600", calculator.getText());
    }

    @Test
    public void clickDiffOperations5Test() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("*");
        calculator.clickKey("/");
        calculator.clickKey("3");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("4", calculator.getText());
    }

    @Test
    public void clickEqualsEarlyTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("0");
        calculator.clickKey("=");
        assertEquals("120", calculator.getText());
    }

    @Test
    public void clickSignAdditionTest() {
        calculator.clickKey("1");
        calculator.clickKey("2");
        calculator.clickKey("+");
        calculator.clickKey("3");
        calculator.clickKey("1");
        calculator.clickKey("s");
        calculator.clickKey("=");
        assertEquals("-19", calculator.getText());
    }

    @Test
    public void clickEqualsAfterOperationTest() {
        calculator.clickKey("2");
        calculator.clickKey("5");
        calculator.clickKey("1");
        calculator.clickKey("+");
        calculator.clickKey("=");
        assertEquals("251", calculator.getText());
    }

    @Test
    public void clickSignWithNoNumberTest() {
        calculator.clickKey("3");
        calculator.clickKey("6");
        calculator.clickKey("2");
        calculator.clickKey("+");
        calculator.clickKey("s");
        assertEquals("-", calculator.getText());
    }

    @Test
    public void clickSignWithNoNumberThenEqualsTest() {
        calculator.clickKey("3");
        calculator.clickKey("6");
        calculator.clickKey("2");
        calculator.clickKey("+");
        calculator.clickKey("s");
        calculator.clickKey("=");
        assertEquals("362", calculator.getText());
    }

    @Test
    public void clickSignWithEqualsThenNoNumberTest() {
        calculator.clickKey("3");
        calculator.clickKey("6");
        calculator.clickKey("2");
        calculator.clickKey("=");
        calculator.clickKey("s");
        assertEquals("-", calculator.getText());
    }
}