package org.example.Models;

import java.awt.*;
import java.util.ArrayList;

public class Album extends MediaItem{
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

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
        this.trackCount = songs.size();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        this.trackCount++;
    }

    public void removeSong(Song song) {
        if(songs.contains(song)) {
            this.songs.remove(song);
            this.trackCount--;
        }
        else {
            System.out.println("Song does not exist");
        }
    }

    public boolean containsSong(Song song) {
        return this.songs.contains(song);
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public void print() {
        System.out.println("Album_name: " + this.name + "; Track Count: " + this.trackCount);
        for(Song song : this.songs) {
            System.out.print("    - ");
            song.print();
        }
    }
}
