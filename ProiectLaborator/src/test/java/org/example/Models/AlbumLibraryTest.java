package org.example.Models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlbumLibraryTest {
    @Test
    public void testAddAlbum() {
        AlbumLibrary library = new AlbumLibrary();
        Album album = new Album("Test Album", "Test Artist", new ArrayList<>());
        library.addAlbum(album);
        assertEquals(1, library.getAlbumCount());
    }

    @Test
    public void testRemoveAlbum() {
        AlbumLibrary library = new AlbumLibrary();
        Album album = new Album("Test Album", "Test Artist", new ArrayList<>());
        library.addAlbum(album);
        library.removeAlbum(album);
        assertEquals(0, library.getAlbumCount());
    }

    @Test
    public void testClearLibrary() {
        AlbumLibrary library = new AlbumLibrary();
        library.addAlbum(new Album("Test Album 1", "Artist 1", new ArrayList<>()));
        library.addAlbum(new Album("Test Album 2", "Artist 2", new ArrayList<>()));
        library.clearLibrary();
        assertEquals(0, library.getAlbums().size());
    }
}