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
        Optional<NumberConverter> numberConverter;
        String error = String.format("Converter type %s not found.", request.getType());

        try {
            NumberConverterTypeEnum numberConverterTypeEnum = NumberConverterTypeEnum.valueOf(request.getType().toUpperCase());
            numberConverter = numberConverterManager.getConverter(numberConverterTypeEnum);

            if (numberConverter.isEmpty()) {
                throw new IllegalArgumentException(error);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(error);
        }

        return numberConverter.get().convert(request.getInput());
    }
}
