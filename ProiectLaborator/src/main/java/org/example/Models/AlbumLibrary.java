package org.example.Models;

import org.example.Interfaces.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AlbumLibrary implements IAlbumLibrary {
    private ArrayList<Album> albums;
    private int albumCount;

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
            album.print();
        }
    }

    public int getAlbumCount() {
        return this.albumCount;
    }
}
