package org.abc.app.service;

/**
 * Interface for converting numbers between different formats.
 */
public interface NumberConverter {

    /**
     * Converts the input number to a different format.
     *
     * @param input the number to be converted, as a string
     * @return the converted number, as a string
     * @throws IllegalArgumentException if the input is invalid or cannot be converted
     */
    String convert(String input);

    /**
     * Validates the input number.
     *
     * @param input the number to be validated, as a string
     * @throws IllegalArgumentException if the input is null, empty, or not valid according to specific conversion rules
     */
    void validateInput(String input) throws IllegalArgumentException;

    String getType();
}
