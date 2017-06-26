package com.ndu.java8.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class StreamTest {

    private static List<String> stringCollection;

    @BeforeAll
    private static void setUp() {
        // Given
        stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    @Test
    void should_filter_strings_beginning_by_a() {
        // When
        List<String> stringCollectionBeginningByA = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        // Then
        Assertions.assertEquals(stringCollectionBeginningByA,
                Arrays.asList("aaa2", "aaa1"));
    }

    @Test
    void should_filter_sorted_strings_beginning_by_a() {
        // When
        List<String> sortedFilteredCollection = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .sorted()
                .collect(Collectors.toList());

        // Then
        Assertions.assertEquals(sortedFilteredCollection,
                Arrays.asList("aaa1", "aaa2"));
    }

    @Test
    void should_uppercase_and_reverse_sort() {
        // When
        List<String> stringCollectionReversedAndUppercased = stringCollection
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Then
        Assertions.assertEquals(stringCollectionReversedAndUppercased,
                Arrays.asList("DDD2", "DDD1", "CCC", "BBB3", "BBB2", "BBB1", "AAA2", "AAA1"));
    }

    @Test
    void should_match_one_a() {
        // When
        boolean anyMatch = stringCollection
                .stream()
                .anyMatch(s -> s.startsWith("a"));

        // Then
        Assertions.assertTrue(anyMatch);
    }

    @Test
    void should_match_all_a() {
        // When
        boolean allMatch = stringCollection
                .stream()
                .allMatch(s -> s.startsWith("a"));

        // Then
        Assertions.assertFalse(allMatch);
    }

    @Test
    void should_match_none_a() {
        // When
        boolean noneMatch = stringCollection
                .stream()
                .noneMatch(s -> s.startsWith("z"));

        // Then
        Assertions.assertTrue(noneMatch);
    }

    @Test
    void should_have_3_starting_by_B() {
        // When
        long number = stringCollection
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();

        // Then
        Assertions.assertEquals(3, number);
    }
}
