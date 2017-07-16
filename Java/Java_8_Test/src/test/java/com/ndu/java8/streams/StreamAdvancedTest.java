package com.ndu.java8.streams;

import com.ndu.java8.methodandconstructorreferences.methodandconstructorreferences.constructorreference.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAdvancedTest {

    private static Person max = new Person("Max", 18);
    private static Person peter = new Person("Peter", 23);
    private static Person pamela = new Person("Pamela", 23);
    private static Person david = new Person("David", 12);
    private static List<Person> persons = Arrays.asList(max, peter, pamela, david);

    @Test
    void should_group_persons_by_age() {
        // Given
        Map<Integer, List<Person>> expectedGroups = new HashMap<>();
        expectedGroups.put(12, Arrays.asList(david));
        expectedGroups.put(18, Arrays.asList(max));
        expectedGroups.put(23, Arrays.asList(peter, pamela));

        // When
        Map<Integer, List<Person>> personsByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        // Then
        Assertions.assertEquals(expectedGroups, personsByAge);
    }
}
