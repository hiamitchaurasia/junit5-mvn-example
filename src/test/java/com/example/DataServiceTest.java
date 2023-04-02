package com.example;

import com.example.service.FakeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class DataServiceTest {
    @Test
    public void ensureServiceDoesNotRunTooLong() {
        FakeService fakeService = new FakeService();
        assertTimeout(Duration.ofSeconds(3),()-> fakeService.fakeUpdate());
    }
}
