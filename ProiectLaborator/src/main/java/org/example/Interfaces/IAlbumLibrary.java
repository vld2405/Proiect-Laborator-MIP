package org.example.Interfaces;

import org.example.Models.Album;

public interface IAlbumLibrary {
    void run();
    void print();
    void addAlbum(Album album);
    void removeAlbum(Album album);
    void clearLibrary();
    void readFromJson(String JSONFilePath);
    void writeToJson(String JSONFilePath);
}
