package org.abc;

/**
 * This class implements the NumberConverter interface to convert binary strings to decimal integers.
 */
public class BinaryToDecimalConverterImpl implements NumberConverter<String, Integer> {

    /**
     * Converts a binary string to its decimal integer representation.
     *
     * @param source the binary string to be converted
     * @return the decimal integer representation of the given binary string
     * @throws IllegalArgumentException if the input is null or not a valid binary string
     */
    @Override
    public Integer convert(String source) {
        isValid(source);

        int result = 0;
        int base = 1;

        for (int i = source.length() - 1; i >= 0; i--) {
            int lastDigit = source.charAt(i) - '0';
            result += lastDigit * base;
            base *= 2;
        }

        return result;
    }

    /**
     * Validates the binary string input.
     *
     * @param source the binary string to be validated
     * @throws IllegalArgumentException if the input is null, empty, or not a valid binary string
     */
    @Override
    public boolean isValid(String source) throws IllegalArgumentException {
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        if (source.trim().length() >= 32) {
            throw new IllegalArgumentException("Input length must be less than 32.");
        }

        for (char currentChar : source.toCharArray()) {
            if (currentChar != '0' && currentChar != '1') {
                throw new IllegalArgumentException("Input must be a valid binary string.");
            }
        }

        if (source.length() > 1 && source.charAt(0) == '0') {
            throw new IllegalArgumentException("Input can not start with 0.");
        }

        return true;
    }
}
