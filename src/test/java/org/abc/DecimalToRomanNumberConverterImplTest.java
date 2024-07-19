package org.abc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToRomanNumberConverterImplTest {

    private final DecimalToRomanNumberConverterImpl decimalToRomanNumberConverter = new DecimalToRomanNumberConverterImpl();

    @Test
    public void isValid_PositiveAndLessThanMax_True() {
        boolean actual = decimalToRomanNumberConverter.isValid(123);

        assertEquals(true, actual);
    }

    @Test
    void isValid_Zero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(0);
        });

        String expectedMessage = "Input must be a positive integer.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_Negative_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(-1);
        });

        String expectedMessage = "Input must be a positive integer.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_LargerThanMaxLimit_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(4000);
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void convert_AllRomanNumerals_Correct() {
        for (int i = 0; i < DecimalToRomanNumberConverterImpl.DECIMALS.length; i++) {
            String actual = decimalToRomanNumberConverter.convert(DecimalToRomanNumberConverterImpl.DECIMALS[i]);

            assertEquals(actual, DecimalToRomanNumberConverterImpl.ROMAN_NUMERALS[i]);
        }
    }

    @Test
    public void convert_SingleDigit_Correct() {
        String actual = decimalToRomanNumberConverter.convert(1);

        assertEquals(actual, "I");
    }

    @Test
    void convert_SingleDigit_Incorrect() {
        String actual = decimalToRomanNumberConverter.convert(2);

        assertNotEquals(actual, "2");
    }

    @Test
    void convert_SingleDigitSpecialDecimal_Correct() {
        String actual = decimalToRomanNumberConverter.convert(4);

        assertEquals(actual, "IV");
    }

    @Test
    void convert_SingleDigitSpecialDecimal_Incorrect() {
        String actual = decimalToRomanNumberConverter.convert(5);

        assertNotEquals(actual, "IIIII");
    }

    @Test
    void convert_LongDecimal_Correct() {
        String actual = decimalToRomanNumberConverter.convert(3514);

        assertEquals(actual, "MMMDXIV");
    }

    @Test
    void convert_LongDecimal_Incorrect() {
        String actual = decimalToRomanNumberConverter.convert(3000);

        assertNotEquals(actual, "3000");
    }

    @Test
    void convert_MaxDecimal_Correct() {
        String actual = decimalToRomanNumberConverter.convert(3999);

        assertEquals(actual, "MMMCMXCIX");
    }

    @Test
    void convert_Zero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(0);
        });

        String expectedMessage = "Input must be a positive integer.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_NegativeDecimal_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(-1);
        });

        String expectedMessage = "Input must be a positive integer.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_MaxDecimal_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanNumberConverter.convert(4000);
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}