package at.technikum.w3resourceOOP.exercise18;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<String> menuItems;
    private ArrayList<Double> prices;
    private ArrayList<Double> ratings;
    private ArrayList<Integer> itemCounts;

    public Restaurant() {
        this.menuItems = new ArrayList<String>();
        this.prices = new ArrayList<Double>();
        this.ratings = new ArrayList<Double>();
        this.itemCounts = new ArrayList<Integer>();
    }

    public void addItem(String item, double price) {
        this.menuItems.add(item);
        this.prices.add(price);
        this.ratings.add(0.);
        this.itemCounts.add(0);
    }

    public void removeItem(String item) {
        int itemID = this.menuItems.indexOf(item);

        if (itemID >= 0) {
            this.menuItems.remove(itemID);
            this.prices.remove(itemID);
            this.ratings.remove(itemID);
            this.itemCounts.remove(itemID);
        }
    }

    public void addRating(String item, double rating) {
        int itemID = this.menuItems.indexOf(item);

        if (itemID >= 0) {
            double currentRating = this.ratings.get(itemID);
            int currentCount = this.itemCounts.get(itemID);
            this.ratings.set(itemID, rating + currentRating);
            this.itemCounts.set(itemID, currentCount + 1);
        }
    }

    public double getAverageRating(String item) {
        int itemID = this.menuItems.indexOf(item);

        if (itemID >= 0) {
            int itemCounts = this.itemCounts.get(itemID);
            if (itemCounts <= 0) return 0.;

            return this.ratings.get(itemID) / itemCounts;
        }
        return 0.;
    }

    public void displayMenu() {
        for (int i=0; i < this.menuItems.size(); i++) {
            String item = this.menuItems.get(i);
            double price = this.prices.get(i);

            System.out.printf("%s:\t$ %.2f\n", item, price);
        }
    }

    public double calculateAverageRating() {
        double sum = 0;
        int itemCount = 0;

        for (int i=0; i < this.menuItems.size(); i++) {
            sum += this.ratings.get(i);
            itemCount += this.itemCounts.get(i);
        }
        return !this.menuItems.isEmpty() ? sum / itemCount : 0.;
    }
}
