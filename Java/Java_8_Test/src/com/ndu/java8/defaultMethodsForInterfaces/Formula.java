package com.ndu.java8.defaultMethodsForInterfaces;

public interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
