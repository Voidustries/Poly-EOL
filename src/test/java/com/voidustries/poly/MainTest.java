package com.voidustries.poly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isThisWorking() {
        Main test = new Main();
        boolean result = test.isThisWorking(true);
        assertTrue(result);
        boolean result1 = test.isThisWorking(false);
        assertFalse(result1);
    }
}