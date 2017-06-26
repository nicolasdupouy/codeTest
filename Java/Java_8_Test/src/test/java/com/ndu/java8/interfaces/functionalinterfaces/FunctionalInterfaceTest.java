package com.ndu.java8.interfaces.functionalinterfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FunctionalInterfaceTest {

    @Test
    void test_FunctionalInterface() {
        // Given
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

        // When
        Integer to = converter.convert("123");

        // Then
        Assertions.assertEquals(new Integer(123), to);
    }
}
