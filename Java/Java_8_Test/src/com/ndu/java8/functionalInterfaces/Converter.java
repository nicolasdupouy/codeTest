package com.ndu.java8.functionalInterfaces;

// The FunctionalInterface annotation ensures that there is only on abstract method defined
// If not, a call to this interface wouldn't compile saying "The target type of this expression must be a functional interface"
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);

	//T testSecondAbstractMethod();
}
