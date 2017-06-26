package com.ndu.java8.interfaces.defaultMethod;

public interface Formula {
    double calculate(int number);

    default double sqrt(int number) {
        return Math.sqrt(number);
    }
}
