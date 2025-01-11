package org.example.Models;

import org.example.Interfaces.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumLibrary implements IAlbumLibrary {
    private ArrayList<Album> albums;
    private int albumCount;

    @Override
    public void run() {
        boolean printMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(printMenu) {
            System.out.println("===============================");
            System.out.println("Menu:");
            System.out.println("1. Print album library");
            System.out.println("2. Clear album library");
            System.out.println("3. Read last saved library (JSON)");
            System.out.println("4. Save album library (JSON)");
            System.out.println("5. Add new album");
            System.out.println("6. Remove album");
            System.out.println("7. Add new song to album");
            System.out.println("8. Remove song from album");
            System.out.println("9. Exit");
            System.out.println("===============================");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1: { // PRINT
                    print();
                    break;
                }

                case 2: { // CLEAR
                    clearLibrary();
                    break;
                }

                case 3: {
                    readFromJson("libraryInput.json");
                    break;
                }

                case 4: {
                    writeToJson("libraryOutput.json");
                    break;
                }

                case 5: { // ADD ALBUM
                    Album newAlbum = new Album();
                    readAlbum(newAlbum);
                    addAlbum(newAlbum);
                    break;
                }

                case 6: { // DELETE ALBUM
                    System.out.print("Enter album ID: ");

                    int albumID = scanner.nextInt();
                    if (albumID > 0 && albumID <= albums.size()) {
                        removeAlbum(albums.get(albumID - 1));
                        System.out.println("Album successfully removed.");
                    } else {
                        System.out.println("Invalid album ID");
                    }

                    break;
                }

                case 7: { // ADD SONG
                    Song newSong = new Song();
                    readSong(newSong);

                    System.out.print("Enter album ID to add song to: ");
                    int albumID = scanner.nextInt();
                    if(albumID > 0 && albumID <= albums.size()) {
                        Album album = albums.get(albumID - 1);
                        album.addSong(newSong);
                        System.out.println("Song successfully added.");
                    }
                    else {
                        System.out.println("Invalid song ID");
                    }

                    break;
                }

                case 8: { // DELETE SONG
                    System.out.print("Enter album ID: ");
                    int albumID = scanner.nextInt();
                    System.out.print("Enter song ID: ");
                    int songID = scanner.nextInt();

                    if(albumID > 0 && albumID <= albums.size()) {
                        if(songID > 0 && songID <= albums.get(albumID - 1).getSongs().size()) {
                            Album album = albums.get(albumID - 1);
                            ArrayList<Song> songs = album.getSongs();
                            album.removeSong(songs.get(songID - 1));
                            System.out.println("Song successfully removed.");
                        }
                        else {
                            System.out.println("Invalid song ID");
                        }
                    }
                    else {
                        System.out.println("Invalid album ID");
                    }
                    break;
                }

                case 9: { // EXIT
                    printMenu = false;
                    break;
                }
            }

            System.out.println();
        }
    }


    public AlbumLibrary() {
        this.albums = new ArrayList<>();
        this.albumCount = 0;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        this.albumCount = albums.size();
    }

    @Override
    public void addAlbum(Album album) {
        this.albums.add(album);
        this.albumCount++;
    }

    @Override
    public void removeAlbum(Album album) {
        if(this.albums.contains(album)) {
            this.albums.remove(album);
            this.albumCount--;
        }
        else {
            System.out.println("Album does not exist");
        }
    }

    @Override
    public void clearLibrary()
    {
        System.out.println("Clearing library");
        this.albums.clear();
        this.albumCount = albums.size();
    }

    @Override
    public void readFromJson(String JSONFilePath) {
        try {
            System.out.println("Reading JSON file from: " + JSONFilePath);
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSONFilePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            if (!jsonObject.has("albums")) {
                return;
            }

            JSONArray albumsArray = jsonObject.getJSONArray("albums");

            for (int i = 0; i < albumsArray.length(); i++) {
                JSONObject albumObj = albumsArray.getJSONObject(i);
                String albumName = albumObj.getString("name");
                String artistName = albumObj.getString("artist");

                JSONArray songsArray = albumObj.getJSONArray("songs");

                ArrayList<Song> songs = new ArrayList<>();
                for (int j = 0; j < songsArray.length(); j++) {
                    JSONObject songObj = songsArray.getJSONObject(j);
                    String songName = songObj.getString("name");
                    String songArtist = songObj.getString("artist");

                    JSONObject timerObj = songObj.getJSONObject("timer");
                    int hours = timerObj.optInt("hours", 0);
                    int minutes = timerObj.optInt("minutes", 0);
                    int seconds = timerObj.optInt("seconds", 0);

                    Timer timer = new Timer(hours, minutes, seconds);
                    Song song = new Song(songName, songArtist, timer);
                    songs.add(song);
                }

                Album album = new Album(albumName, artistName, songs);
                this.addAlbum(album);
            }

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void writeToJson(String JSONFilePath) {
        try {
            JSONObject libraryJson = new JSONObject();
            JSONArray albumsArray = new JSONArray();

            for (Album album : this.albums) {

                JSONObject albumObj = new JSONObject();
                albumObj.put("name", album.getName());
                albumObj.put("artist", album.getArtist());
                albumObj.put("trackCount", album.getTrackCount());

                JSONArray songsArray = new JSONArray();

                for (Song song : album.getSongs()) {

                    JSONObject songObj = new JSONObject();
                    songObj.put("name", song.getName());
                    songObj.put("artist", song.getArtist());

                    JSONObject timerObj = new JSONObject();
                    timerObj.put("hours", song.getTimer().getHours());
                    timerObj.put("minutes", song.getTimer().getMinutes());
                    timerObj.put("seconds", song.getTimer().getSeconds());

                    songObj.put("timer", timerObj);
                    songsArray.put(songObj);
                }

                albumObj.put("songs", songsArray);
                albumsArray.put(albumObj);
            }

            libraryJson.put("albums", albumsArray);

            Files.write(Paths.get(JSONFilePath), libraryJson.toString(4).getBytes());
            System.out.println("JSON file successfully written to: " + JSONFilePath);

        } catch (IOException e) {
            System.err.println("Error writing to JSON file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void print() {
        System.out.println("Album Count: " + this.albumCount);
        for (Album album : this.albums) {
            System.out.print((albums.indexOf(album) + 1) + ") ");
            album.print();
        }
    }

    public int getAlbumCount() {
        return this.albumCount;
    }

    private static void readAlbum(Album album) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter album name: ");
        String albumName = scanner.nextLine();

        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();

        System.out.print("Enter track count: ");
        int trackCount = scanner.nextInt();

        ArrayList<Song> songs = new ArrayList<>();

        for(int i = 0 ; i < trackCount ; i++) {
            Song newSong = new Song();
            readSong(newSong);
            songs.add(newSong);
        }

        album.setName(albumName);
        album.setArtist(artistName);
        album.setSongs(songs);
        album.setTrackCount(trackCount);

        System.out.println("Album successfully read!");
    }

    private static void readSong(Song song) {
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

        song.setTimer(timer);
        song.setName(songName);
        song.setArtist(artistName);

        System.out.println("Song successfully read!");
    }
}
