package com.ndu.java8.methodAndConstructorReferences.methodReferences;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
