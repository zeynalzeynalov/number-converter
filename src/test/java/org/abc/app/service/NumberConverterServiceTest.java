package org.abc.app.service;

import org.abc.app.dto.RequestConvert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberConverterServiceTest {

    private static final String ROMAN_TO_ENGLISH = "ROMAN_TO_ENGLISH";
    private static final String DECIMAL_TO_ROMAN = "DECIMAL_TO_ROMAN";

    @Autowired
    private NumberConverterService numberConverterService;

    @Test
    void convertDecimalToRoman_shouldReturnCorrectRomanNumeral() {
        String actual = numberConverterService.convert(RequestConvert.builder()
                .input("1")
                .type(DECIMAL_TO_ROMAN)
                .build());

        assertEquals("I", actual);
    }

    @Test
    void convertRomanToEnglish_shouldThrowIllegalArgumentException() {
        InvalidNumberConverterException exception = assertThrows(InvalidNumberConverterException.class, () -> numberConverterService.convert(RequestConvert.builder()
                .input("V")
                .type(ROMAN_TO_ENGLISH)
                .build()));

        String expectedMessage = "Converter type " + ROMAN_TO_ENGLISH + " not found.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
