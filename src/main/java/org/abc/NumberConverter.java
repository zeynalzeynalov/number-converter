package org.abc;

public interface NumberConverter<S, T> {
    T convert(S source);

    boolean isValid(S source) throws IllegalArgumentException;
}
