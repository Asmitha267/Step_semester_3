package main.java.week7.assignment_problems;
// File name: Playlist.java

import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs: " + Arrays.toString(copy));
        System.out.println("Song count: " + p.getSongCount());

        copy[0] = "Hacked";

        System.out.println("After modifying copy: "
                + Arrays.toString(p.getSongs()));
    }
}