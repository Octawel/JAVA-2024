package Homework;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPanel extends HBox {
    private Button saveButton;
    private Button loadButton;
    private Button exitButton;

    public ControlPanel(GameBoard gameBoard) {
        saveButton = new Button("Save");
        loadButton = new Button("Load");
        exitButton = new Button("Exit");

        saveButton.setOnAction(event -> gameBoard.saveGame());
        loadButton.setOnAction(event -> gameBoard.loadGame());
        exitButton.setOnAction(event -> Platform.exit());

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        this.getChildren().addAll(saveButton, loadButton, exitButton);
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}

