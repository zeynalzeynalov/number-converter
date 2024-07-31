package org.abc.app.service;

import lombok.RequiredArgsConstructor;
import org.abc.app.dto.RequestConvert;
import org.abc.app.utils.NumberConverterTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
     * @throws IllegalArgumentException if the service type is unknown or the input is invalid
     */
    public String convert(RequestConvert request) {
        Optional<NumberConverterTypeEnum> numberConverterTypeEnum =
                Arrays.stream(NumberConverterTypeEnum.values())
                        .filter(v -> v.toString().equals(request.getType().toUpperCase()))
                        .collect(Collectors.toList()).stream().findFirst();

        if (numberConverterTypeEnum.isEmpty()) {
            throw new InvalidNumberConverterException(String.format("Converter type %s not found.", request.getType()));
        }

        NumberConverter numberConverter = numberConverterMap.get(numberConverterTypeEnum.get());

        return numberConverter.convert(request.getInput());
    }

    public List<String> getTypes() {
        return Stream.of(NumberConverterTypeEnum.values()).map(Enum::name).collect(Collectors.toList());
    }
}
