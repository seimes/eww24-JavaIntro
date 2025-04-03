package at.technikum.w3resourceOOP.exercise17;

import java.util.ArrayList;

public class Movie {
    private String title;
    private Director director;
    private ArrayList<Actor> actors;
    private ArrayList<Review> reviews;

    public Movie(String title, Director director) {
        this.title = title;
        this.director = director;
        this.actors = new ArrayList<Actor>();
        this.reviews = new ArrayList<Review>();
    }

    public Movie(String title, String director) {
        this.title = title;
        this.director = new Director(director);
        this.actors = new ArrayList<Actor>();
        this.reviews = new ArrayList<Review>();
    }

    public Movie(String title, Director director, ArrayList<Actor> actors) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.reviews = new ArrayList<Review>();
    }

    public Movie(String title, String director, ArrayList<Actor> actors) {
        this.title = title;
        this.director = new Director(director);
        this.actors = actors;
        this.reviews = new ArrayList<Review>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }
}
