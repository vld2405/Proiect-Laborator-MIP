package org.example.Models;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    @Test
    public void testAddSong() {
        Album album = new Album("Test Album", "Test Artist", new ArrayList<>());
        Song song = new Song("Test Song", "Test Artist", new Timer(3, 30));
        album.addSong(song);
        assertTrue(album.containsSong(song));
    }

    @Test
    public void testRemoveSong() {
        Album album = new Album("Test Album", "Test Artist", new ArrayList<>());
        Song song = new Song("Test Song", "Test Artist", new Timer(3, 30));
        album.addSong(song);
        album.removeSong(song);
        assertFalse(album.containsSong(song));
    }

    @Test
    public void testRemoveNonExistentSong() {
        Album album = new Album("Test Album", "Test Artist", new ArrayList<>());
        Song song = new Song("Test Song", "Test Artist", new Timer(3, 30));

        // Capturăm ieșirea din consolă
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        album.removeSong(song);

        // Resetăm consola
        System.setOut(System.out);

        assertEquals(0, album.getTrackCount());
        assertTrue(outContent.toString().contains("Song does not exist"));
    }

    @Test
    public void testAlbumContainsSong() {
        Song song = new Song("Test Song", "Test Artist", new Timer(3, 30));
        Album album = new Album();
        album.addSong(song);
        assertTrue(album.containsSong(song));
    }

    @Test
    public void testAlbumDoesntContainsSong() {
        Song existingSong = new Song("Test Song", "Test Artist", new Timer(3, 30));
        Song notExistingSong = new Song("Test Song 2", "Test Artist", new Timer(3, 30));
        Album album = new Album();
        album.addSong(existingSong);
        assertFalse(album.containsSong(notExistingSong));
    }

}