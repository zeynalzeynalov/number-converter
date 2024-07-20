package org.abc.app.converter;

import org.abc.app.utils.NumberConverterTypeEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NumberConverterManager {

    /**
     * Returns an Optional containing the appropriate NumberConverter implementation
     * based on the provided NumberConverterTypeEnum.
     *
     * @param numberConverterTypeEnum the type of number converter requested
     * @return an Optional containing the requested NumberConverter implementation, or an empty Optional if no match is found
     */
    public Optional<NumberConverter> getConverter(NumberConverterTypeEnum numberConverterTypeEnum) {
        NumberConverter numberConverter;

        // Determine the appropriate NumberConverter implementation based on the type enum
        switch (numberConverterTypeEnum) {
            case DECIMAL_TO_ROMAN:
                numberConverter = new DecimalToRomanConverterImpl();
                break;
            case BINARY_TO_ROMAN:
                numberConverter = new BinaryToRomanConverterImpl();
                break;
            case BINARY_TO_DECIMAL:
                numberConverter = new BinaryToDecimalConverterImpl();
                break;
            default:
                // If the type enum doesn't match any case, return an empty Optional
                return Optional.empty();
        }

        // Return the appropriate NumberConverter implementation wrapped in an Optional
        return Optional.ofNullable(numberConverter);
    }
}
