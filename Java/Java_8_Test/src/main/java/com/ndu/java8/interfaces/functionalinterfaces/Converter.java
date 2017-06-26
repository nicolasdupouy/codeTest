package com.ndu.java8.interfaces.functionalinterfaces;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
