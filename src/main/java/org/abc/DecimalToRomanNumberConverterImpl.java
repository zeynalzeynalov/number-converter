package org.abc;

/**
 * This class implements the NumberConverter interface to convert decimal numbers to Roman numerals.
 */
public class DecimalToRomanNumberConverterImpl implements NumberConverter<Integer, String> {

    public static final int[] DECIMALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Converts a decimal number to its Roman numeral representation.
     * The largest number that can be represented in this manner is 3,999 (MMMCMXCIX)
     * Reference: https://en.wikipedia.org/wiki/Roman_numerals#Standard_form
     *
     * @param source the decimal number to be converted
     * @return the Roman numeral representation of the given decimal number
     */
    @Override
    public String convert(Integer source) {
        if (source == null || source <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        if (source > 3999) {
            throw new IllegalArgumentException("Input must be a positive integer less than 3999.");
        }

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (source > 0) {
            if (source >= DECIMALS[i]) {
                stringBuilder.append(ROMAN_NUMERALS[i]);
                source -= DECIMALS[i];
            } else {
                i++;
            }
        }

        return stringBuilder.toString();
    }
}

