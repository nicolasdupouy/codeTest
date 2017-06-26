package com.ndu.java8.lambaexpressions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionTest {

    @Test
    public void sort_list_with_older_method() {
        // Given
        List<String> names = Arrays.asList("B", "D", "C", "A");

        // When
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // Then
        Assertions.assertEquals(names, Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    public void sort_list_with_verbose_lambda_expression() {
        // Given
        List<String> names = Arrays.asList("B", "D", "C", "A");

        // When
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });

        // Then
        Assertions.assertEquals(names, Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    public void sort_list_with_simple_lambda_expression() {
        // Given
        List<String> names = Arrays.asList("B", "D", "C", "A");

        // When
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Then
        Assertions.assertEquals(names, Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    public void sort_list_with_method_reference() {
        // Given
        List<String> names = Arrays.asList("B", "D", "C", "A");

        // When
        Collections.sort(names, String::compareTo);

        // Then
        Assertions.assertEquals(names, Arrays.asList("A", "B", "C", "D"));
    }
}
