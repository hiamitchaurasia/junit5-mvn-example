package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class NestedTests {

    private List<String> list;

    @BeforeEach
    void setup() {
        list = Arrays.asList("JUnit 5", "Mockito");
    }

    @Test
    void listTests() {
        assertEquals(2, list.size());
    }

    @DisplayName("Grouped tests for checking members")
    @Nested
    @Order(2)
    class CheckMembers {
        @Test
        void checkFirstElement() {
            assertEquals(("JUnit 5"), list.get(0));
        }

        @Test
        void checkSecondElement() {
            assertEquals(("Mockito"), list.get(1));
        }

    }

    @Nested
    @Order(1)
    class SecondaryTests {
        @Test
        void test2() {
        }
    }

}
