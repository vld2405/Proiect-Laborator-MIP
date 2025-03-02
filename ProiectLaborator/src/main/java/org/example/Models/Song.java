package org.example.Models;

public class Song extends MediaItem {
    private Timer timer;

    public Song() {}

    public Song(String name, String artist, Timer timer) {
        super(name, artist);
        this.timer = timer;
    }

    public Timer GetTimer() {
        return timer;
    }

    public void SetTimer(Timer timer) {
        this.timer = timer;
    }

    public void Print() {
        System.out.print("Song_name: " + name + "; Artist: " + artist + "; Timer: ");
        timer.Print();
        System.out.println();
    }
}
