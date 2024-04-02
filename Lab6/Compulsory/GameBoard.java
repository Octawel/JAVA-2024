package Compulsory;

import javafx.scene.layout.StackPane;

public class GameBoard extends StackPane {
    private DrawingPanel drawingPanel;
    private int gridWidth = 10; // Default values
    private int gridHeight = 10;

    public GameBoard(ConfigPanel configPanel) {
        // Initialize DrawingPanel with a default size
        drawingPanel = new DrawingPanel(800, 800);
        this.getChildren().add(drawingPanel);

        // Setup action for the new game button
        configPanel.getNewGameButton().setOnAction(e -> {
            gridWidth = configPanel.getGridWidthSpinner().getValue();
            gridHeight = configPanel.getGridHeightSpinner().getValue();
            drawBoard(gridWidth, gridHeight); // Update the drawing based on new dimensions
        });
    }

    public void drawBoard(int gridWidth, int gridHeight) {
        // Assuming you adjust DrawingPanel to support gridWidth and gridHeight
        drawingPanel.drawBoard(gridWidth, gridHeight);
    }
}
