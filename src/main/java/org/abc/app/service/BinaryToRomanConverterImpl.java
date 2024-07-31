package org.abc.app.service;

import org.springframework.stereotype.Component;

/**
 * This class implements the NumberConverter interface to convert binary strings to Roman numerals.
 */
@Component
public class BinaryToRomanConverterImpl implements NumberConverter {

    // Instance of BinaryToDecimalConverterImpl to convert binary to decimal
    private final BinaryToDecimalConverterImpl binaryToDecimalConverter = new BinaryToDecimalConverterImpl();
    // Instance of DecimalToRomanConverterImpl to convert decimal to Roman numerals
    private final DecimalToRomanConverterImpl decimalToRomanConverter = new DecimalToRomanConverterImpl();

    /**
     * Converts a binary string to its Roman numeral representation.
     *
     * @param input the binary string to be converted
     * @return the Roman numeral representation of the given binary string
     * @throws IllegalArgumentException if the input is not a valid binary string
     */
    @Override
    public String convert(String input) {
        // Convert binary to decimal, then convert decimal to Roman numeral
        return decimalToRomanConverter.convert(binaryToDecimalConverter.convert(input));
    }

    /**
     * Validates the binary string input.
     *
     * @param input the binary string to be validated
     * @return true if the input is a valid binary string, false otherwise
     * @throws IllegalArgumentException if the input is null or empty
     */
    @Override
    public void validateInput(String input) throws IllegalArgumentException {
        // Validate using the binaryToDecimalConverter's isValid method
        binaryToDecimalConverter.validateInput(input);
    }

    public String getType() {
        return "BINARY_TO_ROMAN";
    }
}
