package org.abc.app.numberconverter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverterService {

    DecimalToRomanConverterImpl decimalToRomanConverter = new DecimalToRomanConverterImpl();
    BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();

    public String convertDecimalToRoman(Integer input) {
        return decimalToRomanConverter.convert(input);
    }

    public Integer convertBinaryToDecimal(String input) {
        return binaryToDecimalConverter.convert(input);
    }
}
