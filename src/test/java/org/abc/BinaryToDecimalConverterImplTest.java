package org.abc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryToDecimalConverterImplTest {

    private final BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();

    @Test
    public void convert_Zero_Correct() {
        Integer actual = binaryToDecimalConverter.convert("0");

        assertEquals(0, actual);
    }

    @Test
    public void convert_One_Correct() {
        Integer actual = binaryToDecimalConverter.convert("1");

        assertEquals(1, actual);
    }
}