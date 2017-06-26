package com.ndu.java8.methodandconstructorreferences;

import com.ndu.java8.functionalInterfaces.Converter;
import com.ndu.java8.interfaces.methodandconstructorreferences.StartsWithMethodClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StartsWithMethodClassTest {
    
    private static StartsWithMethodClass startsWithMethodClass = new StartsWithMethodClass();
    
    @Test
    void functionalInterface_should_use_method_reference() {
        // Given
        Converter<String, String> converter = startsWithMethodClass::startsWith;
        
        // When
        String to = converter.convert("Java");
        
        // Then
        Assertions.assertEquals("J", to);
    }
}
