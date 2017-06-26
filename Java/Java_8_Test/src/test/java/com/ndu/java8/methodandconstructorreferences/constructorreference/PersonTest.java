package com.ndu.java8.methodandconstructorreferences.constructorreference;

import com.ndu.java8.methodandconstructorreferences.methodandconstructorreferences.constructorreference.Person;
import com.ndu.java8.methodandconstructorreferences.methodandconstructorreferences.constructorreference.PersonFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    // Given
    private static PersonFactory<Person> personFactory = Person::new;

    @Test
    void should_create_a_person() {
        // When
        Person orlandoBloom = personFactory.create("Orlando", "Bloom");

        // Then
        Assertions.assertEquals("Orlando", orlandoBloom.getFirstName());
        Assertions.assertEquals("Bloom", orlandoBloom.getLastName());
    }
}
