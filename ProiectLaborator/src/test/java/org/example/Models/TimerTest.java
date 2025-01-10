package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    @Test
    public void testNormalizeTime() {
        Timer timer = new Timer(0, 90);
        assertEquals(1, timer.getMinutes());
        assertEquals(30, timer.getSeconds());
    }

    @Test
    public void testSetMinutes() {
        Timer timer = new Timer();
        timer.setMinutes(65);
        assertEquals(1, timer.getHours());
        assertEquals(5, timer.getMinutes());
    }

    @Test
    public void testSetSeconds() {
        Timer timer = new Timer();
        timer.setSeconds(125);
        assertEquals(2, timer.getMinutes());
        assertEquals(5, timer.getSeconds());
    }
}