package com.example.custom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

class ExternalCustomConditionDemo {

    @Test
    @EnabledIf("com.example.custom.ExternalCondition#customCondition")
    void enabled() {
        // ...
    }

}
