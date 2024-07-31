package org.abc.app.converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DecimalToRomanConverterImplTest {

    private static final String VALID_NUMBER = "123";
    private static final String ZERO = "0";
    private static final String NEGATIVE_NUMBER = "-1";
    private static final String EXCEEDS_MAX_LIMIT = "4000";
    private static final String MAX_LIMIT = "3999";
    private static final int[] DECIMALS = DecimalToRomanConverterImpl.DECIMALS;
    private static final String[] ROMAN_NUMERALS = DecimalToRomanConverterImpl.ROMAN_NUMERALS;
    @Autowired
    private DecimalToRomanConverterImpl decimalToRomanConverter;

    @Test
    void isValid_withValidPositiveNumber_shouldReturnTrue() {
        assertTrue(decimalToRomanConverter.isValid(VALID_NUMBER));
    }

    @Test
    void convert_withZero_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert(ZERO);
        });

        assertEquals("Input must be a positive integer less than 4000.", exception.getMessage());
    }

    @Test
    void convert_withNegativeNumber_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert(NEGATIVE_NUMBER);
        });

        assertEquals("Input must be a positive integer less than 4000.", exception.getMessage());
    }

    @Test
    void convert_withNumberExceedingMaxLimit_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            decimalToRomanConverter.convert(EXCEEDS_MAX_LIMIT);
        });

        assertEquals("Input must be a positive integer less than 4000.", exception.getMessage());
    }

    @Test
    void convert_allValidNumbers_shouldReturnCorrectRomanNumerals() {
        for (int i = 0; i < DECIMALS.length; i++) {
            String actual = decimalToRomanConverter.convert(String.valueOf(DECIMALS[i]));
            assertEquals(ROMAN_NUMERALS[i], actual);
        }
    }

    @Test
    void convert_withSingleDigit_shouldReturnCorrectRoman() {
        assertEquals("I", decimalToRomanConverter.convert("1"));
    }

    @Test
    void convert_withSpecialSingleDigitDecimal_shouldReturnCorrectRoman() {
        assertEquals("IV", decimalToRomanConverter.convert("4"));
    }

    @Test
    void convert_withLongDecimal_shouldReturnCorrectRoman() {
        assertEquals("MMMDXIV", decimalToRomanConverter.convert("3514"));
    }

    @Test
    void convert_withMaxDecimal_shouldReturnCorrectRoman() {
        assertEquals("MMMCMXCIX", decimalToRomanConverter.convert(MAX_LIMIT));
    }

    @Test
    void convert_withSingleDigit_shouldNotReturnIncorrectRoman() {
        assertNotEquals("2", decimalToRomanConverter.convert("2"));
    }

    @Test
    void convert_withSpecialSingleDigitDecimal_shouldNotReturnIncorrectRoman() {
        assertNotEquals("IIIII", decimalToRomanConverter.convert("5"));
    }

    @Test
    void convert_withLongDecimal_shouldNotReturnIncorrectRoman() {
        assertNotEquals("3000", decimalToRomanConverter.convert("3000"));
    }
}
