package at.technikum.exercises.voexercises.library;

import at.technikum.exercises.voexercises.library.items.IRentable;
import at.technikum.exercises.voexercises.library.items.Item;

import java.time.LocalDateTime;

public class Library {

    public void rent(IRentable rentable) {
        if(rentable.isAvailable()) {
            rentable.setRentDate(LocalDateTime.now());
        }
    }
}
