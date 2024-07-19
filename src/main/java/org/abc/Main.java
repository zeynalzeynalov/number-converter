package org.abc;

public class Main {

    public static void main(String[] args) {

        NumberConverter converter = new DecimalToRomanNumberConverterImpl();

        System.out.println(converter.convert(1236));
    }
}