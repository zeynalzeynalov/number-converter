package org.abc.app.converter;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.abc.app.utils.NumberConverterTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberConverterManagerTest {

    NumberConverterManager numberConverterManager = new NumberConverterManager();

    @Test
    void getConverter_DecimalToRoman_Correct() {
        Optional<NumberConverter> numberConverter = numberConverterManager.getConverter(DECIMAL_TO_ROMAN);

        assertTrue(numberConverter.isPresent());

        assertEquals(DecimalToRomanConverterImpl.class, numberConverter.get().getClass());
    }

    @Test
    void getConverter_BinaryToDecimal_Correct() {
        Optional<NumberConverter> numberConverter = numberConverterManager.getConverter(BINARY_TO_DECIMAL);

        assertTrue(numberConverter.isPresent());

        assertEquals(BinaryToDecimalConverterImpl.class, numberConverter.get().getClass());
    }

    @Test
    void getConverter_BinaryToRoman_Correct() {
        Optional<NumberConverter> numberConverter = numberConverterManager.getConverter(BINARY_TO_ROMAN);

        assertTrue(numberConverter.isPresent());

        assertEquals(BinaryToRomanConverterImpl.class, numberConverter.get().getClass());
    }
}