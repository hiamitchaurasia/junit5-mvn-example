package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassTest {

    @Test
    void testWillBeSkipped() {
    }

}
