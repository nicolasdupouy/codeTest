package com.ndu.java8.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
                .filter((s) -> s.startsWith("a"))
                .collect(Collectors.toList());

        // Then
        Assertions.assertEquals(stringCollectionBeginningByA,
                Arrays.asList("aaa2", "aaa1"));
    }
}
