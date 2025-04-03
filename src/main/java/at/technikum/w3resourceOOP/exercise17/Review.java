package at.technikum.w3resourceOOP.exercise17;

public class Review {
    private String text;
    private Reviewer reviewer;
    private double rating;

    public Review(String text, Reviewer reviewer, double rating) {
        this.text = text;
        this.reviewer = reviewer;
        this.rating = rating;
    }

    public Review(String text, String reviewer, double rating) {
        this.text = text;
        this.reviewer = new Reviewer(reviewer);
        this.rating = rating;
    }

    public Person getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewerName() {
        return this.reviewer.getName();
    }
}
