package org.abc.app.converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BinaryToDecimalConverterImplTest {

    private static final String VALID_BINARY = "1011011";
    private static final String INVALID_BINARY = "1a1b0";
    private static final String TOO_LONG_BINARY = "11111111111111111111111111111111";
    private static final String LEADING_ZERO_BINARY = "0101";
    private static final String EMPTY_BINARY = "";
    private static final String MAX_BINARY = "1111111111111111111111111111111";
    @Autowired
    private BinaryToDecimalConverterImpl binaryToDecimalConverter;

    @Test
    void isValid_withValidBinary_shouldReturnTrue() {
        assertTrue(binaryToDecimalConverter.isValid(VALID_BINARY));
    }

    @Test
    void convert_withEmptyInput_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert(EMPTY_BINARY);
        });

        String expectedMessage = "Input cannot be null or empty.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withInvalidBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert(INVALID_BINARY);
        });

        String expectedMessage = "Input must be a valid binary string.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withTooLongBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert(TOO_LONG_BINARY);
        });

        String expectedMessage = "Input length must be less than 32.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withLeadingZeroBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert(LEADING_ZERO_BINARY);
        });

        String expectedMessage = "Input can not start with 0.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withZeroBinary_shouldReturnZero() {
        String actual = binaryToDecimalConverter.convert("0");
        assertEquals("0", actual);
    }

    @Test
    void convert_withOneBinary_shouldReturnOne() {
        String actual = binaryToDecimalConverter.convert("1");
        assertEquals("1", actual);
    }

    @Test
    void convert_withLongBinary_shouldReturnCorrectDecimal() {
        String actual = binaryToDecimalConverter.convert("101010101010");
        assertEquals("2730", actual);
    }

    @Test
    void convert_withMaxBinary_shouldReturnMaxIntegerValue() {
        String actual = binaryToDecimalConverter.convert(MAX_BINARY);
        assertEquals(String.valueOf(Integer.MAX_VALUE), actual);
    }
}
