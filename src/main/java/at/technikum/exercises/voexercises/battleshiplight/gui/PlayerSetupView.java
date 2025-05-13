package at.technikum.exercises.voexercises.battleshiplight.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PlayerSetupView {
    private final TextField player1NameField = new TextField("Player 1");
    private final TextField player2NameField = new TextField("Player 2");
    private final CheckBox multiPlayerCheckBox = new CheckBox("Multiplayer Mode");
    private final TextField gridSizeField = new TextField("Enter Grid Size (e.g. 5)");
    private final Button startButton = new Button("Start Game");
    private static final int DEFAULT_GRIDSIZE = 5;

    private VBox root;

    public PlayerSetupView() {
        this.root = new VBox(15);
        this.root.setAlignment(Pos.CENTER);
        this.root.setPadding(new Insets(30));
        this.root.setBackground(new Background(
                new BackgroundFill(GameTheme.BGCOLOR, null, Insets.EMPTY)
        ));

        this.player1NameField.setMaxWidth(200);
        this.player2NameField.setMaxWidth(200);
        this.player2NameField.setVisible(false);
        this.player2NameField.setManaged(false);
        this.gridSizeField.setMaxWidth(200);
        this.multiPlayerCheckBox.setTextFill(Color.WHITE);

        Text enterText = new Text("Enter Player Name:");
        enterText.setFill(Color.WHITE);
        Text gridSizeText = new Text("Grid Size:");
        gridSizeText.setFill(Color.WHITE);

        // Toggle visibility of player 2 field based on checkbox
        multiPlayerCheckBox.setOnAction(e -> {
            if(this.isMultiPlayer())
                enterText.setText("Enter Player Names:");
            else {
                enterText.setText("Enter Player Name:");
            }
            this.player2NameField.setVisible(this.isMultiPlayer());
            this.player2NameField.setManaged(this.isMultiPlayer());
        });

        root.getChildren().addAll(
                enterText,
                this.player1NameField,
                this.player2NameField,
                this.multiPlayerCheckBox,
                gridSizeText,
                this.gridSizeField,
                this.startButton
        );

        this.root.setAlignment(Pos.CENTER);
    }

    public Scene getScene() {
        return new Scene(this.root, 800, 600);
    }

    public Button getStartButton() {
        return this.startButton;
    }

    public String getPlayer1Name() {
        return this.player1NameField.getText();
    }

    public String getPlayer2Name() {
        return this.multiPlayerCheckBox.isSelected() ? this.player2NameField.getText() : "Computer";
    }

    public boolean isMultiPlayer() {
        return this.multiPlayerCheckBox.isSelected();
    }

    public int getGridSize() {
        try {
            return Integer.parseInt(this.gridSizeField.getText());
        } catch (NumberFormatException e) {
            return DEFAULT_GRIDSIZE; // default fallback
        }
    }
}
