package com.ndu.java8.methodandconstructorreferences.methodreference;

import com.ndu.java8.functionalInterfaces.Converter;
import com.ndu.java8.methodandconstructorreferences.methodandconstructorreferences.methodreference.StartsWithMethodClass;
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
