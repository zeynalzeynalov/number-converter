package org.abc.app.service;

import org.springframework.stereotype.Component;

/**
 * This class implements the NumberConverter interface to convert decimal numbers to Roman numerals.
 */
@Component
public class DecimalToRomanConverterImpl implements NumberConverter {

    // Arrays for decimal values and their corresponding Roman numeral symbols
    public static final int[] DECIMALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Converts a decimal number to its Roman numeral representation.
     * Reference: <a href="https://en.wikipedia.org/wiki/Roman_numerals#Standard_form">...</a>
     *
     * @param input the decimal number to be converted
     * @return the Roman numeral representation of the given decimal number
     * @throws IllegalArgumentException if the input is not a valid positive integer less than 4000
     */
    @Override
    public String convert(String input) {
        validateInput(input);

        int inputInteger = Integer.parseInt(input);

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        // Convert decimal to Roman numeral
        while (inputInteger > 0) {
            if (inputInteger >= DECIMALS[index]) {
                stringBuilder.append(ROMAN_NUMERALS[index]);
                inputInteger -= DECIMALS[index];
            } else {
                index++;
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Validates the input decimal number.
     *
     * @param input the decimal number to be validated
     * @throws IllegalArgumentException if the input is not a valid positive integer less than 4000
     */
    @Override
    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        int inputInteger;
        try {
            inputInteger = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid positive integer.");
        }

        if (inputInteger <= 0 || inputInteger >= 4000) {
            throw new IllegalArgumentException("Input must be a positive integer less than 4000.");
        }
    }

    @Override
    public String getType() {
        return "DECIMAL_TO_ROMAN";
    }
}
