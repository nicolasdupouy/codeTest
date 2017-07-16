package com.ndu.java8.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    void should_reduce_a_strings() {
        // When
        Optional<String> stringSortedAndReduced = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .sorted()
                .reduce((a, b) -> a + "#" + b);

        // Then
        if (stringSortedAndReduced.isPresent()) {
            Assertions.assertEquals("aaa1#aaa2", stringSortedAndReduced.get());
        } else {
            Assertions.fail("stream should not be empty");
        }
    }

    @Test
    void should_fail_to_reduce_z_strings() {
        // When
        Optional<String> stringSortedAndReduced = stringCollection
                .stream()
                .filter(s -> s.startsWith("z"))
                .sorted()
                .reduce((a, b) -> a + "#" + b);

        // Then
        Assertions.assertFalse(stringSortedAndReduced.isPresent());
    }

    @Test
    void should_get_first_element_from_list() {
        // When
        String first = Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .get();

        // Then
        Assertions.assertEquals("a1", first);
    }

    @Test
    void should_get_first_element_from_objects_references() {
        // When
        String first = Stream.of("a1", "a2", "a3")
                .findFirst()
                .get();

        // Then
        Assertions.assertEquals("a1", first);

    }

    @Test
    void should_create_a_stream_of_int() {
        // Given
        List<Integer> integersWithRange = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        // When
        IntStream.range(1, 4)
                .forEach(integersWithRange::add);

        // Then
        Assertions.assertEquals(integers, integersWithRange);
    }

    @Test
    void operations_are_done_vertically() {
        // Given
        List<String> expectedResult = Arrays.asList("map: d2", "anyMatch: D2", "map: a2", "anyMatch: A2");

        // When
        List<String> result = new ArrayList<>();
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    result.add("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    result.add("anyMatch: " + s);
                    return s.startsWith("A");
                });

        // Then
        Assertions.assertEquals(expectedResult, result);
    }
}
