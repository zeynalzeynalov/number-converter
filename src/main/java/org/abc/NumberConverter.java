package org.abc;

public interface NumberConverter<T, V> {
    V convert(T source);
}
