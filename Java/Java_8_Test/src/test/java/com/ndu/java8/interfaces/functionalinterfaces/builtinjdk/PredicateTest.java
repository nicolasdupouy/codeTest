package com.ndu.java8.interfaces.functionalinterfaces.builtinjdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

class PredicateTest {

    // Given
    private static Predicate<String> positiveLengthPredicate = (s) -> s.length() > 0;

    @Test
    void test_positive_length_with_predicate() {
        // When
        boolean testStringHasPositiveLength = positiveLengthPredicate.test("testString");

        // Then
        Assertions.assertTrue(testStringHasPositiveLength);
    }

    @Test
    void test_negative_length_with_predicate() {
        // When
        boolean testStringHasNegativeLength = positiveLengthPredicate.negate().test("testString");

        // Then
        Assertions.assertFalse(testStringHasNegativeLength);
    }
}
