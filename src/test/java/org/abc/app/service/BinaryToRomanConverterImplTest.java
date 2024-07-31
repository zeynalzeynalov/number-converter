package org.abc.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BinaryToRomanConverterImplTest {

    private static final String VALID_BINARY = "1011011";
    private static final String EMPTY_BINARY = "";
    private static final String INVALID_BINARY = "1a1b0";
    private static final String TOO_LONG_BINARY = "11111111111111111111111111111111";
    private static final String LEADING_ZERO_BINARY = "0101";
    private static final String ZERO_BINARY = "0";
    private static final String LONG_BINARY = "101010101010";
    private static final String MAX_BINARY = "1111111111111111111111111111111";
    @Autowired
    private BinaryToRomanConverterImpl binaryToRomanConverter;

    @Test
    void isValid_withValidBinary_shouldReturnTrue() {
        assertTrue(binaryToRomanConverter.isValid(VALID_BINARY));
    }

    @Test
    void convert_withEmptyInput_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(EMPTY_BINARY);
        });

        assertEquals("Input cannot be null or empty.", exception.getMessage());
    }

    @Test
    void convert_withInvalidBinary_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(INVALID_BINARY);
        });

        assertEquals("Input must be a valid binary string.", exception.getMessage());
    }

    @Test
    void convert_withTooLongBinary_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(TOO_LONG_BINARY);
        });

        assertEquals("Input length must be less than 32.", exception.getMessage());
    }

    @Test
    void convert_withLeadingZeroBinary_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(LEADING_ZERO_BINARY);
        });

        assertEquals("Input can not start with 0.", exception.getMessage());
    }

    @Test
    void convert_withZeroBinary_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(ZERO_BINARY);
        });

        assertEquals("Input must be a positive integer less than 4000.", exception.getMessage());
    }

    @Test
    void convert_withOneBinary_shouldReturnRomanI() {
        String actual = binaryToRomanConverter.convert("1");
        assertEquals("I", actual);
    }

    @Test
    void convert_withLongBinary_shouldReturnCorrectRoman() {
        String actual = binaryToRomanConverter.convert(LONG_BINARY);
        assertEquals("MMDCCXXX", actual);
    }

    @Test
    void convert_withMaxBinary_shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert(MAX_BINARY);
        });

        assertEquals("Input must be a positive integer less than 4000.", exception.getMessage());
    }
}
