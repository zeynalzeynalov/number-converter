package org.abc.app.numberconverter;

public interface NumberConverter<S, T> {
    T convert(S source);

    boolean isValid(S source) throws IllegalArgumentException;
}
