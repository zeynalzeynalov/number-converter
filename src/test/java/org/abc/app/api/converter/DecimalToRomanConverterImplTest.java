package org.abc.app.api.converter;

import org.abc.app.converter.DecimalToRomanConverterImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToRomanConverterImplTest {

    private final DecimalToRomanConverterImpl decimalToRomanConverter = new DecimalToRomanConverterImpl();

    @Test
    public void isValid_PositiveAndLessThanMax_True() {
        boolean actual = decimalToRomanConverter.isValid("123");

        assertTrue(actual);
    }

    @Test
    void isValid_Zero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("0");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_Negative_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("-1");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_LargerThanMaxLimit_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("4000");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void convert_AllRomanNumerals_Correct() {
        for (int i = 0; i < DecimalToRomanConverterImpl.DECIMALS.length; i++) {
            String actual = decimalToRomanConverter.convert(String.valueOf(DecimalToRomanConverterImpl.DECIMALS[i]));

            assertEquals(actual, DecimalToRomanConverterImpl.ROMAN_NUMERALS[i]);
        }
    }

    @Test
    public void convert_SingleDigit_Correct() {
        String actual = decimalToRomanConverter.convert("1");

        assertEquals(actual, "I");
    }

    @Test
    void convert_SingleDigit_Incorrect() {
        String actual = decimalToRomanConverter.convert("2");

        assertNotEquals(actual, "2");
    }

    @Test
    void convert_SingleDigitSpecialDecimal_Correct() {
        String actual = decimalToRomanConverter.convert("4");

        assertEquals(actual, "IV");
    }

    @Test
    void convert_SingleDigitSpecialDecimal_Incorrect() {
        String actual = decimalToRomanConverter.convert("5");

        assertNotEquals(actual, "IIIII");
    }

    @Test
    void convert_LongDecimal_Correct() {
        String actual = decimalToRomanConverter.convert("3514");

        assertEquals(actual, "MMMDXIV");
    }

    @Test
    void convert_LongDecimal_Incorrect() {
        String actual = decimalToRomanConverter.convert("3000");

        assertNotEquals(actual, "3000");
    }

    @Test
    void convert_MaxDecimal_Correct() {
        String actual = decimalToRomanConverter.convert("3999");

        assertEquals(actual, "MMMCMXCIX");
    }

    @Test
    void convert_Zero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("0");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_NegativeDecimal_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("-1");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_MaxDecimal_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert("4000");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}