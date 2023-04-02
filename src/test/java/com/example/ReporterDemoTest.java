package com.example;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestReporterDemo and TestInfoDemo Tests")
public class ReporterDemoTest {
    ReporterDemoTest(TestInfo testInfo) {
        assertEquals("TestReporterDemo and TestInfoDemo Tests", testInfo.getDisplayName());
    }
    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.startsWith("TEST - ") || displayName.equals("test2()"));
    }

        @Test
        @DisplayName("TEST - 4")
        void reportSingleValue(TestReporter testReporter) {
            testReporter.publishEntry("a status message");
        }

        @Test
        @DisplayName("TEST - 3")
        void reportKeyValuePair(TestReporter testReporter) {
            testReporter.publishEntry("a key", "a value");
        }

        @Test
        @DisplayName("TEST - 2")
        void reportMultipleKeyValuePairs(TestReporter testReporter) {
            Map<String, String> values = new HashMap<>();
            values.put("user name", "dk38");
            values.put("award year", "1974");

            testReporter.publishEntry(values);
        }

    @Test
    @DisplayName("TEST - 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST - 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

}