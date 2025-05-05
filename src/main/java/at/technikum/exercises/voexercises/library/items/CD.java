package at.technikum.exercises.voexercises.library.items;

public class CD extends Item {
    private String title;
    private String artist;
    private int numberOfTracks;
    private int year;

    public CD(String title, String artist, int numberOfTracks, int year, boolean available) {
        super(available);
        this.title = title;
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public void print() {
        System.out.printf("CD %s %s%n", this.title, this.artist);
    }
}
