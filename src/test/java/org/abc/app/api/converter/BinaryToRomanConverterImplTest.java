package org.abc.app.api.converter;

import org.abc.app.converter.BinaryToRomanConverterImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToRomanConverterImplTest {

    private final BinaryToRomanConverterImpl binaryToRomanConverter = new BinaryToRomanConverterImpl();

    @Test
    public void isValid_Valid_True() {
        boolean actual = binaryToRomanConverter.isValid("1011011");

        assertTrue(actual);
    }

    @Test
    void isValid_Empty_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("");
        });

        String expectedMessage = "Input cannot be null or empty.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_Invalid_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("1a1b0");
        });

        String expectedMessage = "Input must be a valid binary string.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_LongerThanMaxLength_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("11111111111111111111111111111111");
        });

        String expectedMessage = "Input length must be less than 32.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValid_StartsWithZero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("0101");
        });

        String expectedMessage = "Input can not start with 0.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_Zero_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("0");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void convert_One_Correct() {
        String actual = binaryToRomanConverter.convert("1");

        assertEquals("I", actual);
    }

    @Test
    public void convert_LongBinary_Correct() {
        String actual = binaryToRomanConverter.convert("101010101010");

        assertEquals("MMDCCXXX", actual);
    }

    @Test
    public void convert_LongestBinary_Correct() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            binaryToRomanConverter.convert("1111111111111111111111111111111");
        });

        String expectedMessage = "Input must be a positive integer less than 4000.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}