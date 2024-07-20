package org.abc;

/**
 * This class implements the NumberConverter interface to convert decimal numbers to Roman numerals.
 */
public class DecimalToRomanConverterImpl implements NumberConverter<Integer, String> {

    public static final int[] DECIMALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Converts a decimal number to its Roman numeral representation.
     * Reference: https://en.wikipedia.org/wiki/Roman_numerals#Standard_form
     *
     * @param source the decimal number to be converted
     * @return the Roman numeral representation of the given decimal number
     * @throws IllegalArgumentException if the input is not a valid positive integer less than 4000
     */
    @Override
    public String convert(Integer source) {
        isValid(source);

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (source > 0) {
            if (source >= DECIMALS[index]) {
                stringBuilder.append(ROMAN_NUMERALS[index]);
                source -= DECIMALS[index];
            } else {
                index++;
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Validates the input decimal number.
     *
     * @param source the decimal number to be validated
     * @return true if the input is a valid positive integer less than 4000
     * @throws IllegalArgumentException if the input is not a valid positive integer less than 4000
     */
    @Override
    public boolean isValid(Integer source) {
        if (source == null || source <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        if (source >= 4000) {
            throw new IllegalArgumentException("Input must be a positive integer less than 4000.");
        }

        return true;
    }
}
