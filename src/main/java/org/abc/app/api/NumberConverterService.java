package org.abc.app.api;

import lombok.RequiredArgsConstructor;
import org.abc.app.converter.NumberConverter;
import org.abc.app.converter.NumberConverterManager;
import org.abc.app.utils.NumberConverterTypeEnum;
import org.abc.app.utils.RequestConvert;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling number conversion logic.
 */
@Service
@RequiredArgsConstructor
public class NumberConverterService {

    private final NumberConverterManager numberConverterManager;

    /**
     * Converts a number based on the provided request.
     *
     * @param request the request containing the input and conversion type
     * @return the result of the conversion
     * @throws IllegalArgumentException if the converter type is unknown or the input is invalid
     */
    public String convert(RequestConvert request) {
        try {
            NumberConverterTypeEnum numberConverterTypeEnum = NumberConverterTypeEnum.valueOf(request.getType().toUpperCase());
            Optional<NumberConverter> numberConverter = numberConverterManager.getConverter(numberConverterTypeEnum);

            if (numberConverter.isPresent()) {
                return numberConverter.get().convert(request.getInput());
            } else {
                throw new IllegalArgumentException("Converter not found for type: " + request.getType());
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid converter type: " + request.getType(), e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error during conversion", e);
        }
    }
}
