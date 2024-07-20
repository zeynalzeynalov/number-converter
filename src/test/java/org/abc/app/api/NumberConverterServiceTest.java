package org.abc.app.api;

import org.abc.app.converter.NumberConverterManager;
import org.abc.app.utils.RequestConvert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterServiceTest {

    NumberConverterManager numberConverterManager = new NumberConverterManager();
    NumberConverterService numberConverterService = new NumberConverterService(numberConverterManager);

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