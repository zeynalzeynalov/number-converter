package org.abc.app.numberconverter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverterService {

    DecimalToRomanConverterImpl decimalToRomanConverter = new DecimalToRomanConverterImpl();

    public String convertDecimalToRoman(Integer input) {
        return decimalToRomanConverter.convert(input);
    }
}
