package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    @Test
    public void testNormalizeTime() {
        Timer timer = new Timer(0, 90);
        assertEquals(1, timer.GetMinutes());
        assertEquals(30, timer.GetSeconds());
    }

    @Test
    public void testSetMinutes() {
        Timer timer = new Timer();
        timer.SetMinutes(65);
        assertEquals(1, timer.GetHours());
        assertEquals(5, timer.GetMinutes());
    }

    @Test
    public void testSetSeconds() {
        Timer timer = new Timer();
        timer.SetSeconds(125);
        assertEquals(2, timer.GetMinutes());
        assertEquals(5, timer.GetSeconds());
    }
}