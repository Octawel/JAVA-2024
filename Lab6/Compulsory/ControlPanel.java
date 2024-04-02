package Compulsory;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPanel extends HBox {
    private Button saveButton;
    private Button loadButton;
    private Button exitButton;

    public ControlPanel() {
        saveButton = new Button("Save");
        loadButton = new Button("Load");
        exitButton = new Button("Exit");

        exitButton.setOnAction(event -> Platform.exit());

        String buttonStyle = "-fx-font-size: 14px; -fx-padding: 5px 10px;";
        saveButton.setStyle(buttonStyle);
        loadButton.setStyle(buttonStyle);
        exitButton.setStyle(buttonStyle);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        this.getChildren().addAll(saveButton, loadButton, exitButton);
    }
}

