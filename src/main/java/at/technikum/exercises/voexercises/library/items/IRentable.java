package at.technikum.exercises.voexercises.library.items;

import java.time.LocalDateTime;

public interface IRentable {
    // public nicht notwendig, weil Interfaces eh immer von anderen Klassen implementiert werden
    void rent();
    boolean isAvailable();
    void setRentDate(LocalDateTime now);
}
