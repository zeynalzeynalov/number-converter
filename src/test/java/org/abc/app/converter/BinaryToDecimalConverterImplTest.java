package org.abc.app.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalConverterImplTest {

    private final BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();

    @Test
    public void isValid_Valid_True() {
        boolean actual = binaryToDecimalConverter.isValid("1011011");

        assertTrue(actual);
    }

    @Test
    void isValid_Empty_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert("");
        });

        String expectedMessage = "Input cannot be null or empty.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_Invalid_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert("1a1b0");
        });

        String expectedMessage = "Input must be a valid binary string.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_LongerThanMaxLength_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert("11111111111111111111111111111111");
        });

        String expectedMessage = "Input length must be less than 32.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_StartsWithZero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToDecimalConverter.convert("0101");
        });

        String expectedMessage = "Input can not start with 0.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void convert_Zero_Correct() {
        String actual = binaryToDecimalConverter.convert("0");

        assertEquals("0", actual);
    }

    @Test
    public void convert_One_Correct() {
        String actual = binaryToDecimalConverter.convert("1");

        assertEquals("1", actual);
    }

    @Test
    public void convert_LongBinary_Correct() {
        String actual = binaryToDecimalConverter.convert("101010101010");

        assertEquals("2730", actual);
    }

    @Test
    public void convert_LongestBinary_Correct() {
        String actual = binaryToDecimalConverter.convert("1111111111111111111111111111111");

        assertEquals(String.valueOf(Integer.MAX_VALUE), actual);
    }
}