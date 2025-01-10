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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public abstract void print();
}
