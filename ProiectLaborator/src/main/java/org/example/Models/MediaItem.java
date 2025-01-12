package org.example.Models;

public abstract class MediaItem {
    protected String name;
    protected String artist;

    public MediaItem() {
        this.name = "";
        this.artist = "";
    }

    public MediaItem(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetArtist() {
        return artist;
    }

    public void SetArtist(String artist) {
        this.artist = artist;
    }

    public abstract void Print();
}
