package org.abc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalConverterImplTest {

    private final BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();

    @Test
    public void convert_AllRomanNumerals_Correct() {
        Integer actual = binaryToDecimalConverter.convert("10");

        assertEquals(2, actual);
    }
}