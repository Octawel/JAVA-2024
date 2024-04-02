package Compulsory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfigPanel extends VBox {
    private Spinner<Integer> gridWidthSpinner;
    private Spinner<Integer> gridHeightSpinner;
    private Button newGameButton;

    public ConfigPanel() {
        Label gridWidthLabel = new Label("Grid width:");
        gridWidthSpinner = new Spinner<>(3, 20, 10);
        gridWidthSpinner.setEditable(true);

        Label gridHeightLabel = new Label("Grid height:");
        gridHeightSpinner = new Spinner<>(3, 20, 10);
        gridHeightSpinner.setEditable(true);

        newGameButton = new Button("Create");

        HBox inputs = new HBox(10);
        inputs.getChildren().addAll(gridWidthLabel, gridWidthSpinner, gridHeightLabel, gridHeightSpinner);
        inputs.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.getChildren().addAll(inputs, newGameButton);
    }

    public Spinner<Integer> getGridWidthSpinner() {
        return gridWidthSpinner;
    }

    public Spinner<Integer> getGridHeightSpinner() {
        return gridHeightSpinner;
    }

    public Button getNewGameButton() {
        return newGameButton;
    }
}
