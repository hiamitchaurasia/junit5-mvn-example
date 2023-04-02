package com.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/*
    * For this class you need the hamcrest dependency 'org.hamcrest', name: 'hamcrest', version: '2.2'
 */
import org.junit.jupiter.api.Test;

class HamcrestAssertionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }

}
