package org.example.Interfaces;

import org.example.Models.Album;

import java.util.ArrayList;

public interface IAlbumLibrary {
    void Run();

    void Print();

    void AddAlbum(Album album);

    void RemoveAlbum(Album album);

    void ClearLibrary();

    void ReadFromJson(String JSONFilePath);

    void WriteToJson(String JSONFilePath);

    ArrayList<Album> GetAlbums();

    void SetAlbums(ArrayList<Album> albums);

    int GetAlbumCount();
}
