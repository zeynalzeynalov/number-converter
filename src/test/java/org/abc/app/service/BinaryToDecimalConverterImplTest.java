package org.abc.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.abc.app.common.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BinaryToDecimalConverterImplTest {

    @Autowired
    private BinaryToDecimalConverterImpl binaryToDecimalConverter;

    @Test
    void isValid_withValidBinary_shouldReturnTrue() {
        //TODO: assertTrue(binaryToDecimalConverter.isValid(VALID_BINARY));
    }

    @Test
    void convert_withEmptyInput_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binaryToDecimalConverter.convert(EMPTY_BINARY));

        String expectedMessage = "Input cannot be null or empty.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withInvalidBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binaryToDecimalConverter.convert(INVALID_BINARY));

        String expectedMessage = "Input must be a valid binary string with only 1 and 0 chars.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withTooLongBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binaryToDecimalConverter.convert(TOO_LONG_BINARY));

        String expectedMessage = "Input length must be less than 32.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void convert_withLeadingZeroBinary_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binaryToDecimalConverter.convert(LEADING_ZERO_BINARY));

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
