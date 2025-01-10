package org.example.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    public void testGetTimer() {
        Timer timer = new Timer(2, 45);
        Song song = new Song("Test Song", "Test Artist", timer);
        assertEquals(timer, song.getTimer());
    }

    @Test
    public void testSetTimer() {
        Timer timer = new Timer(2, 45);
        Song song = new Song();
        song.setTimer(timer);
        assertEquals(timer, song.getTimer());
    }
}