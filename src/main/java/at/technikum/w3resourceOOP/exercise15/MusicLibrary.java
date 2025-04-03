package at.technikum.w3resourceOOP.exercise15;

import java.util.ArrayList;
import java.util.Random;

public class MusicLibrary {
    private ArrayList<Song> songs;

    public MusicLibrary() {
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

    private Song getRandomSong() {
        Random r = new Random();
        int songId = r.nextInt(this.songs.size()-1);
        return this.songs.get(songId);
    }

    public void playRandomSong() {
        Song song = this.getRandomSong();
        System.out.println("Playing random song: " + song.getArtist() + " - " + song.getTitle());
    }
}
