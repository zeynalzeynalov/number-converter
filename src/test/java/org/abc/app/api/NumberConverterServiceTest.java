package org.abc.app.api;

import org.abc.app.converter.BinaryToDecimalConverterImpl;
import org.abc.app.converter.BinaryToRomanConverterImpl;
import org.abc.app.converter.DecimalToRomanConverterImpl;
import org.abc.app.utils.RequestConvert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterServiceTest {

    DecimalToRomanConverterImpl decimalToRomanConverter = new DecimalToRomanConverterImpl();
    BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();
    BinaryToRomanConverterImpl binaryToRomanConverter = new BinaryToRomanConverterImpl();

    NumberConverterService numberConverterService = new NumberConverterService(List.of(
            decimalToRomanConverter, binaryToDecimalConverter, binaryToRomanConverter
    ));

    @Test
    void convert_DecimalToRoman_Correct() {
        RequestConvert requestConvert = new RequestConvert("1", "DECIMAL_TO_ROMAN");
        String actual = numberConverterService.convert(requestConvert);

        assertEquals(actual, "I");
    }

    @Test
    void convert_RomanToEnglish_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RequestConvert requestConvert = new RequestConvert("1", "ROMAN_TO_ENGLISH");
            numberConverterService.convert(requestConvert);
        });

        String expectedMessage = "Converter type ROMAN_TO_ENGLISH not found.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}