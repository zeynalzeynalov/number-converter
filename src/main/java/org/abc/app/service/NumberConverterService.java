package org.abc.app.service;

import lombok.RequiredArgsConstructor;
import org.abc.app.dto.RequestConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service class for handling number conversion logic.
 */
@Service
@RequiredArgsConstructor
@PropertySource("classpath:converter.properties")
public class NumberConverterService {

    private final Map<String, NumberConverter> numberConverterMap = new HashMap<>();

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
        if (!numberConverterMap.containsKey(request.getType())) {
            throw new InvalidNumberConverterException(String.format("Converter type %s not found.", request.getType()));
        }

        NumberConverter numberConverter = numberConverterMap.get(request.getType());

        return numberConverter.convert(request.getInput());
    }

    public Set<String> getTypes() {
        return numberConverterMap.keySet();
    }
}
