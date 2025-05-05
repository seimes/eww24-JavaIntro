package at.technikum.exercises.voexercises.library;

import at.technikum.exercises.voexercises.library.items.Item;

import java.time.LocalDateTime;

public class Library {

    public void rent(Item item) {
        item.print();
        if(item.isAvailable()) {
            item.setAvailable(false);
            item.setRentDate(LocalDateTime.now());
        } else {
            System.out.println("Item not available");
        }
    }
}
