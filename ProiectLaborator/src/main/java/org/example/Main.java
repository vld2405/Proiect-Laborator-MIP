package org.example;

import org.example.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void readSong(Song song) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter song name: ");
        String songName = scanner.nextLine();

        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();

        System.out.print("Enter song duration (minutes): ");
        int minutes = scanner.nextInt();

        System.out.print("Enter song duration (seconds): ");
        int seconds = scanner.nextInt();

        Timer timer = new Timer(minutes, seconds);

        song = new Song(songName, artistName, timer);

        System.out.println("Song successfully read!");
    }

    public static void readAlbum(Album album) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter track count: ");
        int trackCount = scanner.nextInt();

        System.out.print("Enter album name: ");
        String albumName = scanner.nextLine();

        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();

        ArrayList<Song> songs = new ArrayList<>();

        for(int i = 0 ; i < trackCount ; i++) {
            Song newSong = new Song();
            readSong(newSong);
            songs.add(newSong);
        }

        album = new Album(albumName, artistName, songs);

        System.out.println("Album successfully read!");
    }

    public static Song readAlbum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter song name: ");
        String songName = scanner.nextLine();

        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();

        System.out.print("Enter song duration (minutes): ");
        int minutes = scanner.nextInt();

        System.out.print("Enter song duration (seconds): ");
        int seconds = scanner.nextInt();

        Timer timer = new Timer(minutes, seconds);

        Song newSong = new Song(songName, artistName, timer);

        System.out.println("Song successfully read!");
        return newSong;
    }

    public static void main(String[] args) {
        AlbumLibrary albumLibrary = new AlbumLibrary();

        boolean printMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(printMenu) {
            System.out.println("Menu:");
            System.out.println("1. Print album library");
            System.out.println("2. Clear album library");
            System.out.println("3. Add new album");
            System.out.println("4. Delete album");
            System.out.println("5. Add new song");
            System.out.println("6. Delete song");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    albumLibrary.print();
                    break;
                case 2:
                    albumLibrary.clearLibrary();
                    break;
                case 3:
            }

        }
    }
}