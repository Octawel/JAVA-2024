package Homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Homework extends Application {
    private GameBoard gameBoard;
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private boolean isRedTurn = true;

    @Override
    public void start(Stage primaryStage) {
        configPanel = new ConfigPanel();
        gameBoard = new GameBoard(10, 10);
        controlPanel = new ControlPanel(gameBoard);

        configPanel.getNewGameButton().setOnAction(e -> gameBoard.initializeNewGame(
                configPanel.getGridWidthSpinner().getValue(),
                configPanel.getGridHeightSpinner().getValue()));

        controlPanel.getSaveButton().setOnAction(e -> gameBoard.saveGame());
        controlPanel.getLoadButton().setOnAction(e -> gameBoard.loadGame());

        gameBoard.setOnMouseClicked(this::handleMouseClick);

        BorderPane root = new BorderPane();
        root.setTop(configPanel);
        root.setCenter(gameBoard);
        root.setBottom(controlPanel);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setTitle("Grid Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClick(MouseEvent event) {
        if (gameBoard != null) {
            double screenX = event.getX();
            double screenY = event.getY();

            double cellSize = gameBoard.getCellSize();
            int gridX = (int) ((screenX - gameBoard.getOffsetX()) / cellSize);
            int gridY = (int) ((screenY - gameBoard.getOffsetY()) / cellSize);

            if (gameBoard.isValidPlacement(gridX, gridY)) {
                Color color = isRedTurn ? Color.RED : Color.BLUE;
                gameBoard.placeStone(screenX, screenY, color);
                isRedTurn = !isRedTurn;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}