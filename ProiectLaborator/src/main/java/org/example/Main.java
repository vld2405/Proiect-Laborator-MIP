package org.example;

import org.example.Interfaces.IAlbumLibrary;
import org.example.Models.*;

public class Main {
    public static void main(String[] args) {
        IAlbumLibrary albumLibrary = new AlbumLibrary();
        albumLibrary.run();
    }
}