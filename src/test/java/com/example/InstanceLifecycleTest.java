package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("InstanceLifecycleTest Test Cases \uD83D\uDE31")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstanceLifecycleTest {
    Calculator calculator;
    int result;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Order(1)
    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        result = calculator.multiply(4, 5);
        assertEquals(20, result,
                "Regular multiplication should work");
    }

    @Order(3)
    @Test
    @DisplayName("Multiplication again")
    void testMultiplyAgain() {
        //because Lifecycle is set to PER_CLASS it will return 100
        assertEquals(100, calculator.multiply(result, 5),
                "Regular multiplication should work");
    }

    @Order(2)
    @Test
    @DisplayName("Expect ArithmeticException")
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
