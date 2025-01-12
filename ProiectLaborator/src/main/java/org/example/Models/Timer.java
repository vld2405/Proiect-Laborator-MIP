package org.example.Models;

public class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    public Timer() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Timer(int minutes, int seconds) {
        this(0, minutes, seconds);
    }

    public Timer(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        NormalizeTime();
    }

    public int GetHours() {
        return hours;
    }

    public void SetHours(int hours) {
        this.hours = hours;
    }

    public int GetMinutes() {
        return minutes;
    }

    public void SetMinutes(int minutes) {
        this.minutes = minutes;
        NormalizeTime();
    }

    public int GetSeconds() {
        return seconds;
    }

    public void SetSeconds(int seconds) {
        this.seconds = seconds;
        NormalizeTime();
    }

    private void NormalizeTime() {
        this.minutes += this.seconds / 60;
        this.seconds %= 60;

        this.hours += this.minutes / 60;
        this.minutes %= 60;

        if (this.seconds < 0) {
            this.seconds += 60;
            this.minutes--;
        }

        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours--;
        }
    }

    public void Print() {
        if(hours > 0 )
            System.out.print(hours + ":" + minutes + ":");
        else
            System.out.print(minutes + ":");
        if(seconds < 10)
            System.out.print("0" + seconds);
        else
            System.out.print(seconds);
    }
}
