package org.example.Models;

import javax.swing.*;

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
        normalizeTime();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        normalizeTime();
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
        normalizeTime();
    }

    private void normalizeTime() {
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

    public void print() {
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
