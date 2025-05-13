package at.technikum.exercises.voexercises.battleshiplight.gui;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.BattleshipGame;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameGUI extends Application {
    private final BattleshipGame game;

    public GameGUI() {
        this.game = new BattleshipGame();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameSceneBuilder.buildStartScene(primaryStage);
    }

    public BattleshipGame getGame() {
        return game;
    }
}

