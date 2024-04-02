package Compulsory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawingPanel extends Canvas {
    public DrawingPanel(double width, double height) {
        super(width, height);
    }

    public void drawBoard(int gridWidth, int gridHeight) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        double cellWidth = getWidth() / gridWidth;
        double cellHeight = getHeight() / gridHeight;

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        for (int i = 0; i <= gridWidth; i++) {
            gc.strokeLine(i * cellWidth, 0, i * cellWidth, getHeight());
        }
        for (int j = 0; j <= gridHeight; j++) {
            gc.strokeLine(0, j * cellHeight, getWidth(), j * cellHeight);
        }
    }
}
