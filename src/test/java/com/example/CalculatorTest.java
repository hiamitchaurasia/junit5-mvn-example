package com.example;

import com.example.model.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("calculator")
@DisplayName("Calculator Test Cases \uD83D\uDE31")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    Calculator calculator;
    private static User user;
    @BeforeAll
    static void initAll() {
        user = new User();
        user.setFirstName("Amit");
        user.setLastName("Doe");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Order(1)
    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5),
                "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
    }
    @Order(2)
    @Test
    @DisplayName("Expect ArithmeticException")
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
    @Test
    @Disabled("Kept this test out of scope for now!")
    void groupedAssertions() {
        Address address = new Address();
        address.setFirstName("John");
        address.setLastName("User");
        assertAll("First and Last Name in the Address",
                () -> assertEquals("John", address.getFirstName()),
                () -> assertEquals("User", address.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = user.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("A")),
                            () -> assertTrue(firstName.endsWith("t"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = user.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    @AfterAll
    static void tearDownAll() {
    }
}
