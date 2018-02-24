package com.voidustries.poly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void isThisWorking() {
        Main test = new Main();
        boolean result = test.isThisWorking(true);
        boolean result1 = test.isThisWorking(false);
        assertTrue(result);
        assertFalse(result1);
    }
}