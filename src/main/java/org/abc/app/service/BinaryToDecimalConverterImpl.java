package org.abc.app.service;

import org.springframework.stereotype.Component;

/**
 * This class implements the NumberConverter interface to convert binary strings to decimal integers.
 */
@Component
public class BinaryToDecimalConverterImpl implements NumberConverter {

    /**
     * Converts a binary string to its decimal integer representation.
     *
     * @param input the binary string to be converted
     * @return the decimal integer representation of the given binary string
     * @throws IllegalArgumentException if the input is null or not a valid binary string
     */
    @Override
    public String convert(String input) {
        // Validate the input before conversion
        validateInput(input);

        int result = 0;
        int base = 1;

        // Convert binary string to decimal
        for (int i = input.length() - 1; i >= 0; i--) {
            int lastDigit = input.charAt(i) - '0';
            result += lastDigit * base;
            base *= 2;
        }

        return String.valueOf(result);
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
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        if (input.length() >= 32) {
            throw new IllegalArgumentException("Input length must be less than 32.");
        }

        for (char currentChar : input.toCharArray()) {
            if (currentChar != '0' && currentChar != '1') {
                throw new IllegalArgumentException("Input must be a valid binary string with only 1 and 0 chars.");
            }
        }

        if (input.length() > 1 && input.charAt(0) == '0') {
            throw new IllegalArgumentException("Input can not start with 0.");
        }
    }

    @Override
    public String getType() {
        return "BINARY_TO_DECIMAL";
    }
}
