package org.example.Interfaces;

import org.example.Models.Song;

import java.util.ArrayList;

public interface IAlbum {
    ArrayList<Song> GetSongs();

    void SetSongs(ArrayList<Song> songs);

    void AddSong(Song song);

    void RemoveSong(Song song);

    boolean ContainsSong(Song song);

    int GetTrackCount();

    void SetTrackCount(int trackCount);

    void Print();
}
