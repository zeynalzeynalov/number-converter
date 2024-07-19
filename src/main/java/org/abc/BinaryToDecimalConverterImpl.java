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
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        int result = 0;
        int base = 1;

        for (int i = source.length() - 1; i >= 0; i--) {
            char currentChar = source.charAt(i);
            if (currentChar != '0' && currentChar != '1') {
                throw new IllegalArgumentException("Input must be a valid binary string.");
            }

            int last_digit = currentChar - '0';
            result += last_digit * base;
            base *= 2;
        }

        return result;
    }
}
