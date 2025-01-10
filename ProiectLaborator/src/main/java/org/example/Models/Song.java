package org.example.Models;

public class Song extends MediaItem {
    private Timer timer;

    public Song() {}

    public Song(String name, String artist, Timer timer) {
        super(name, artist);
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void print() {
        System.out.print("Song_name: " + name + "; Artist: " + artist + "; Timer: ");
        timer.print();
        System.out.println();
    }
}
