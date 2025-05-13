package at.technikum.exercises.voexercises.battleshiplight.interfaces;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Field;
import at.technikum.exercises.voexercises.battleshiplight.core.Player;

import java.awt.*;

public interface BoardLike<T extends Field> {
    T[][] getFields();
    int getSize();
    void updateStateAndScore(Point fieldCoordinate, Player player);
}
