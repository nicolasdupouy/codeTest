package com.ndu.java8.interfaces.defaultMethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormulaTest {

    // Given
    private static Formula formulaWithPlus50;

    @BeforeAll
    private static void setUp() {
        formulaWithPlus50 = new Formula() {
            public double calculate(int number) {
                return sqrt(number) + 50;
            }
        };
    }

    @Test
    @DisplayName("Formula should provide the square root function")
    public void formula_should_provide_square_root() {
        // When
        double sqrtOf16 = formulaWithPlus50.sqrt(16);

        // Then
        Assertions.assertEquals(4, sqrtOf16);
    }

    @Test
    public void formula_should_calculate() {
        // When
        double sqrtOf9Plus50 = formulaWithPlus50.calculate(9);

        // Then
        Assertions.assertEquals(53, sqrtOf9Plus50);
    }


}
