package org.example.Models;

import java.util.ArrayList;

public class Album extends MediaItem implements org.example.Interfaces.IAlbum {
    private int trackCount;
    private ArrayList<Song> songs;

    public Album() {
        super();
        this.trackCount = 0;
        this.songs = new ArrayList<>();
    }

    public Album(String albumName, String artistName, ArrayList<Song> songs) {
        super(albumName, artistName);
        this.songs = songs;
        this.trackCount = songs.size();
    }

    @Override
    public ArrayList<Song> GetSongs() {
        return this.songs;
    }

    @Override
    public void SetSongs(ArrayList<Song> songs) {
        this.songs = songs;
        this.trackCount = songs.size();
    }

    @Override
    public void AddSong(Song song) {
        this.songs.add(song);
        this.trackCount++;
    }

    @Override
    public void RemoveSong(Song song) {
        if (songs.contains(song)) {
            this.songs.remove(song);
            this.trackCount--;
        } else {
            System.out.println("Song does not exist");
        }
    }

    @Override
    public boolean ContainsSong(Song song) {
        return this.songs.contains(song);
    }

    @Override
    public int GetTrackCount() {
        return this.trackCount;
    }

    @Override
    public void SetTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    @Override
    public void Print() {
        System.out.println("Album_name: " + this.name + "; Artist: " + this.artist + "; Track Count: " + this.trackCount);
        for (Song song : this.songs) {
            System.out.print("\t" + (songs.indexOf(song) + 1) + ") ");
            song.Print();
        }
    }
}
