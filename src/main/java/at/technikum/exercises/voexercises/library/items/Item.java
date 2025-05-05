package at.technikum.exercises.voexercises.library.items;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Item {
    protected String id;
    protected boolean available;
    protected LocalDateTime rentDate;

    public Item(boolean available) {
        System.out.println("Item constructor");
        this.id = UUID.randomUUID().toString();
        this.available = available;
    }

    public LocalDateTime getRentDate() {
        return this.rentDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return this.id;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public abstract void print();
}
