package at.technikum.exercises.voexercises.battleshiplight.gui;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Field;
import at.technikum.exercises.voexercises.battleshiplight.core.PlayerState;
import at.technikum.exercises.voexercises.battleshiplight.core.Player;
import at.technikum.exercises.voexercises.battleshiplight.core.State;
import at.technikum.exercises.voexercises.battleshiplight.gui.board.BoardGUI;
import at.technikum.exercises.voexercises.battleshiplight.gui.board.FieldGUI;
import at.technikum.exercises.voexercises.battleshiplight.interfaces.BoardLike;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameSceneBuilder {

    public static void buildStartScene(Stage primaryStage) {
        PlayerSetupView playerSetupView = new PlayerSetupView();

        Scene startScene = playerSetupView.getScene();

        playerSetupView.getStartButton().setOnAction(e -> {
            String playerName1 = playerSetupView.getPlayer1Name();
            String playerName2 = "Computer";
            if (playerSetupView.isMultiPlayer()) playerName2 = playerSetupView.getPlayer2Name();

            int gridSize = playerSetupView.getGridSize();

            Player player1 = new Player(playerName1, new BoardGUI(gridSize, 50, false));
            Player player2 = new Player(playerName2, new BoardGUI(gridSize, 50, true));

            if (!playerSetupView.isMultiPlayer()) player2.getGameState().setComputerPlayer(true);

            Scene[] playerScenes = new Scene[2];

            playerScenes[0] = GameSceneBuilder.build(player1, player2, gridSize, primaryStage, playerScenes, 0, playerSetupView);
            playerScenes[1] = GameSceneBuilder.build(player2, player1, gridSize, primaryStage, playerScenes, 1, playerSetupView);

            primaryStage.setScene(playerScenes[0]);
        });

        primaryStage.setScene(startScene);
        primaryStage.setTitle("Start Screen");
        primaryStage.show();
    }

    public static Scene build(Player player, Player opponent, int gridSize, Stage primaryStage, Scene[] scenes, int playerIndex, PlayerSetupView playerSetupView) {
        BoardLike<? extends Field> playerBoard = player.getBoard();
        BoardLike<? extends Field> oppBoard = opponent.getBoard();

        if (playerBoard instanceof BoardGUI && oppBoard instanceof BoardGUI) {
            VBox gameRoot = new VBox(20);
            final FieldGUI[] selectedAttackCell = {null};
            ArrayList<FieldGUI> selectedAttackCells = new ArrayList<FieldGUI>();
            gameRoot.setAlignment(Pos.CENTER);
            gameRoot.setPadding(new Insets(20));
            gameRoot.setBackground(new Background(
                    new BackgroundFill(GameTheme.BGCOLOR, null, Insets.EMPTY)
            ));

            Text[] scoreTexts = new Text[2];
            TextFlow welcomeText = createInstructionAndStatsText(player, opponent, scoreTexts);
            Text playerScore = scoreTexts[0];
            Text opponentScore = scoreTexts[1];
            gameRoot.getChildren().add(welcomeText);

            GridPane playerGrid = createPlayerGrid(player, opponent, gridSize, playerBoard, playerSetupView);
            GridPane oppGrid = createOpponentGrid(opponent, gridSize, player, selectedAttackCell, selectedAttackCells, playerScore);

            HBox boardsContainer = new HBox(50);
            boardsContainer.setAlignment(Pos.CENTER);
            boardsContainer.getChildren().addAll(playerGrid, oppGrid);

            Button submitBoardBtn = new Button("Submit Board");

            VBox buttonContainer = new VBox(submitBoardBtn);
            buttonContainer.setAlignment(Pos.CENTER);
            buttonContainer.setPadding(new Insets(10));

            gameRoot.getChildren().addAll(boardsContainer, buttonContainer);

            submitBoardBtn.setOnMouseClicked(e -> {
                if (player.getGameState().getShipsPlaced() >= gridSize) {
                    player.getGameState().setBoardSubmitted(true);

                    updateOppGridGraphics(selectedAttackCells);
                    // Disable the player's grid AFTER submitting
                    //playerGrid.setDisable(true);

                    if (submitBoardBtn.getText().equals("Attack")) {
                        int nextPlayerIndex = (playerIndex + 1) % 2;
                        Player nextPlayer = (nextPlayerIndex == 0) ? player : opponent;
                        player.getGameState().incrementTurnCount();

                        if (nextPlayer.getGameState().isComputerPlayer()) {
                            performComputerTurn(nextPlayer, player, primaryStage, scenes, opponentScore);
                        } else {
                            primaryStage.setScene(scenes[nextPlayerIndex]);
                        }
                    }

                    submitBoardBtn.setText("Attack");
                }
            });

            return new Scene(gameRoot, 900, 700);
        } else {
            System.out.println("Player board is not of type BoardGUI.");
            return null;
        }
    }

    private static void performComputerTurn(Player computer, Player player, Stage primaryStage, Scene[] scenes, Text opponentScore) {
        if (!(player.getBoard() instanceof BoardGUI humanBoard)) return;

        FieldGUI[][] fields = humanBoard.getFields();

        // not random yet, attacks from top left to bottom right
        // TODO: still need to make it random!!!
        for (int row = 0; row < fields.length; row++) {
            for (int col = 0; col < fields[row].length; col++) {
                FieldGUI cell = fields[row][col];

                if (cell.getState() == State.SHIP_NO_HIT || cell.getState() == State.NO_SHIP_NO_HIT) {
                    Button btn = cell.getButton();

                    if (cell.getState() == State.SHIP_NO_HIT) {
                        cell.setState(State.SHIP_HIT);
                        computer.getGameState().incrementScore();
                        opponentScore.setText(computer.getName() + " Score: " + computer.getGameState().getScore());
                        btn.setGraphic(AssetLoader.convertToImageView(AssetLoader.HIT_IMG, 40));
                    } else {
                        cell.setState(State.NO_SHIP_HIT);
                        btn.setGraphic(AssetLoader.convertToImageView(AssetLoader.MISS_IMG, 40));
                    }

                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(event -> primaryStage.setScene(scenes[0]));
                    pause.play();

                    return;
                }
            }
        }
    }

    private static void updateOppGridGraphics(ArrayList<FieldGUI> selectedAttackCells) {
        for (FieldGUI cell : selectedAttackCells) {
            if (cell.getLinkedTargetCell().getState() == State.SHIP_HIT) {
                cell.getButton().setGraphic(AssetLoader.convertToImageView(AssetLoader.HIT_IMG, 40));
            } else if (cell.getLinkedTargetCell().getState() == State.NO_SHIP_HIT) {
                cell.getButton().setGraphic(AssetLoader.convertToImageView(AssetLoader.MISS_IMG, 40));
            }
        }
    }
    /*private static void allowOneAttack(BoardLike<? extends Field> oppBoard, Button submitBtn, Runnable onAttackDone) {
        if (!(oppBoard instanceof BoardGUI boardGUI)) return;

        FieldGUI[][] fields = boardGUI.getFields();

        for (int row = 0; row < fields.length; row++) {
            for (int col = 0; col < fields[row].length; col++) {
                FieldGUI cell = fields[row][col];
                Button btn = cell.getButton();

                btn.setDisable(false); // make clickable
                btn.setOnMouseClicked(ev -> {
                    updateFieldStateAfterAttack(cell, btn);

                    disableAllOpponentButtons(fields);
                    onAttackDone.run(); // trigger "End Turn" logic
                });
            }
        }
    }*/

    private static void disableAllOpponentButtons(FieldGUI[][] fields) {
        for (FieldGUI[] row : fields) {
            for (FieldGUI cell : row) {
                cell.getButton().setDisable(true);
            }
        }
    }

    private static GridPane createPlayerGrid(Player player, Player opponent, double gridSize, BoardLike<? extends Field> playerBoard, PlayerSetupView playerSetupView) {
        GridPane playerGrid = new GridPane();
        playerGrid.setHgap(2);
        playerGrid.setVgap(2);

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                FieldGUI cell = (FieldGUI) playerBoard.getFields()[row][col];
                System.out.println("player " + player.getName() + ", cell " + cell.getCoordinate() + "state: " + cell.getState());
            }
        }

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                FieldGUI cell = (FieldGUI) playerBoard.getFields()[row][col];
                Button cellButton = cell.getButton();

                if (player.getGameState().isComputerPlayer() && cell.getState() == State.SHIP_NO_HIT) {
                    cellButton.setGraphic(AssetLoader.convertToImageView(AssetLoader.SHIP_IMG, 40));
                    player.getGameState().setShipsPlaced((int) gridSize);
                }

                cellButton.setOnMouseClicked(e -> {
                    PlayerState playerState = player.getGameState();

                    if (playerState.isComputerPlayer()) return;

                    System.out.println("player: " + player.getName());
                    System.out.println("ships placed: " + playerState.getShipsPlaced());
                    System.out.println("cell state: " + cell.getState());

                    // Disallow any interaction if the board is submitted
                    if (playerState.isBoardSubmitted()) {
                        return;
                    }

                    // Allow placing a ship if limit not reached and cell is empty
                    if (playerState.getShipsPlaced() < gridSize && cell.getState() == State.NO_SHIP_NO_HIT) {
                        cellButton.setGraphic(AssetLoader.convertToImageView(AssetLoader.SHIP_IMG, 40));
                        cell.setState(State.SHIP_NO_HIT);
                        playerState.incrementPlacedShips();

                        // Allow removing a ship before submission
                    } else if (cell.getState() == State.SHIP_NO_HIT) {
                        cellButton.setGraphic(AssetLoader.convertToImageView(AssetLoader.SEA_IMG, 40));
                        cell.setState(State.NO_SHIP_NO_HIT);
                        playerState.decrementPlacedShips();
                    }
                });

                playerGrid.add(cellButton, col, row);
            }
        }

        // Disable grid only if the current player already submitted
        if (player.getGameState().isBoardSubmitted()) {
            playerGrid.setDisable(true);
        }

        return playerGrid;
    }

    private static GridPane createOpponentGrid(Player opponent, double gridSize, Player player, FieldGUI[] selectedAttackCell, ArrayList<FieldGUI> selectedAttackCells, Text playerScore) {
        GridPane oppGrid = new GridPane();
        oppGrid.setHgap(2);
        oppGrid.setVgap(2);

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                FieldGUI oppCell = (FieldGUI) opponent.getBoard().getFields()[row][col];
                FieldGUI attackCell = new FieldGUI(50, new Point(0, 0), new Point(col, row));
                Button attackCellButton = getAttackButton(player, attackCell, opponent, oppCell, selectedAttackCell, selectedAttackCells, playerScore);

                oppGrid.add(attackCellButton, col, row);
            }
        }

        return oppGrid;
    }

    private static Button getAttackButton(Player player, FieldGUI attackCell, Player opponent, FieldGUI oppCell, FieldGUI[] selectedAttackCell, ArrayList<FieldGUI> selectedAttackCells, Text playerScore) {
        Button attackCellButton = attackCell.getButton();
        AtomicBoolean isAttackSubmitted = new AtomicBoolean(false);

        attackCellButton.setOnMouseClicked(e -> {
            for (int row = 0; row < opponent.getBoard().getFields().length; row++) {
                for (int col = 0; col < opponent.getBoard().getFields().length; col++) {
                    FieldGUI cell = (FieldGUI) opponent.getBoard().getFields()[row][col];
                    System.out.println("player " + opponent.getName() + ", cell " + cell.getCoordinate() + "state: " + cell.getState());
                }
            }

            if (oppCell.getState() == State.SHIP_NO_HIT)
                System.out.println("hit shit");

            System.out.println(selectedAttackCells);
            if (!player.getGameState().isBoardSubmitted()) return;

            // If this cell is already selected, deselect it
            if (selectedAttackCells.contains(attackCell)) {
                selectedAttackCell[0] = null;
                selectedAttackCells.remove(attackCell);
                attackCell.setLinkedTargetCell(null);
                attackCellButton.setGraphic(AssetLoader.convertToImageView(AssetLoader.SEA_IMG, 40)); // revert image
                return;
            }

            // If another cell is already selected, ignore this click
            System.out.println("no. selected cells %d; turn count: %d".formatted(selectedAttackCells.size(), player.getGameState().getTurnCount()));
            if (selectedAttackCells.size() == player.getGameState().getTurnCount()) return;

            // Select this cell
            selectedAttackCell[0] = attackCell;
            selectedAttackCells.add(attackCell);
            attackCell.setLinkedTargetCell(oppCell);
            attackCellButton.setGraphic(AssetLoader.convertToImageView(AssetLoader.ATTACK_IMG, 40)); // show attack image
            isAttackSubmitted.set(true);

            if (isAttackSubmitted.get())
                updateFieldStateAfterAttack(player, opponent, oppCell, attackCellButton, playerScore);
        });

        return attackCellButton;
    }

    private static void updateFieldStateAfterAttack(Player player, Player opponent, FieldGUI oppCell, Button attackCellButton, Text playerScore) {
        if (oppCell.getState() == State.SHIP_NO_HIT) {
            oppCell.setState(State.SHIP_HIT);
            player.getGameState().incrementScore();
            playerScore.setText("Your Score: " + player.getGameState().getScore());
        } else if (oppCell.getState() == State.NO_SHIP_NO_HIT) {
            oppCell.setState(State.NO_SHIP_HIT);
        }
    }


    private static void setCellStateAndImage(FieldGUI oppCell, FieldGUI attackCell, Image img) {
        oppCell.setState(State.SHIP_HIT);
        attackCell.setState(State.SHIP_HIT);
        ImageView hitView = new ImageView(img);
        hitView.setFitWidth(40);
        hitView.setFitHeight(40);
        attackCell.getButton().setGraphic(hitView);
    }

    private static TextFlow createInstructionAndStatsText(Player player, Player opponent, Text[] scoreTexts) {
        Text welcome = new Text("Welcome, ");
        Text name = new Text(player.getName() + "!\n");
        String instructionText = "Select a cell to attack on the right grid.";
        if (!player.getGameState().isComputerPlayer()) {
            instructionText = "Place your ships by clicking on the left grid.\n" + instructionText;
        }
        Text instruction = new Text(instructionText);

        scoreTexts[0] = new Text("Your Score: " + player.getGameState().getScore());
        scoreTexts[1] = new Text(opponent.getName() + " Score: " + opponent.getGameState().getScore());

        // Style the texts
        welcome.setFont(javafx.scene.text.Font.font("Arial", FontWeight.NORMAL, 20));
        name.setFont(GameTheme.TITLE_FONT);
        instruction.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        scoreTexts[0].setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        scoreTexts[1].setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        welcome.setFill(javafx.scene.paint.Color.WHITE);
        name.setFill(javafx.scene.paint.Color.LIGHTGREEN);
        instruction.setFill(Color.LIGHTGRAY);
        scoreTexts[0].setFill(Color.LIGHTGRAY);
        scoreTexts[1].setFill(Color.LIGHTGRAY);

        TextFlow textFlow = new TextFlow(welcome, name, instruction, scoreTexts[0], scoreTexts[1]);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setPadding(new Insets(20));
        textFlow.setMaxWidth(600);

        return textFlow;
    }
}
