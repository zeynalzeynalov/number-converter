package org.abc.app.api;

import lombok.RequiredArgsConstructor;
import org.abc.app.converter.NumberConverter;
import org.abc.app.utils.NumberConverterTypeEnum;
import org.abc.app.utils.RequestConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service class for handling number conversion logic.
 */
@Service
@RequiredArgsConstructor
public class NumberConverterService {

    private final Map<NumberConverterTypeEnum, NumberConverter> numberConverterMap = new HashMap<>();

    @Autowired
    public NumberConverterService(List<NumberConverter> numberConverterList) {
        numberConverterList.forEach(converter -> numberConverterMap.put(converter.getType(), converter));
    }

    /**
     * Converts a number based on the provided request.
     *
     * @param request the request containing the input and conversion type
     * @return the result of the conversion
     * @throws IllegalArgumentException if the converter type is unknown or the input is invalid
     */
    public String convert(RequestConvert request) {
        String error = String.format("Converter type %s not found.", request.getType());

        NumberConverter numberConverter;

        try {
            NumberConverterTypeEnum numberConverterTypeEnum = NumberConverterTypeEnum.valueOf(request.getType().toUpperCase());
            numberConverter = numberConverterMap.get(numberConverterTypeEnum);

            if (numberConverter == null) {
                throw new IllegalArgumentException(error);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(error);
        }

        return numberConverter.convert(request.getInput());
    }

    public List<String> getTypes() {
        return Stream.of(NumberConverterTypeEnum.values()).map(Enum::name).collect(Collectors.toList());
    }
}
