package com.dijo.appmania;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest() {
        int a = 4;
        int b = 5;

        assertEquals(20, calculator.multiply(a, b));
    }
}
