package Homework;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawingPanel extends Pane {
    private Canvas canvas;
    private final double stickWidth = 5.0;


    public DrawingPanel(double width, double height) {
        canvas = new Canvas(width, height);
        this.getChildren().add(canvas);

        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());

        this.setPrefSize(width, height);
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    public void drawBoard(List<Stick> sticks, List<Stone> stones, int gridWidth, int gridHeight, double cellSize) {
        GraphicsContext gc = getGraphicsContext();
        gc.clearRect(0, 0, getWidth(), getHeight());

        double startX = (getWidth() - (cellSize * gridWidth)) / 2;
        double startY = (getHeight() - (cellSize * gridHeight)) / 2;

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);

        for (int i = 0; i <= gridWidth; i++) {
            gc.strokeLine(startX + i * cellSize, startY, startX + i * cellSize, startY + gridHeight * cellSize);
        }
        for (int j = 0; j <= gridHeight; j++) {
            gc.strokeLine(startX, startY + j * cellSize, startX + gridWidth * cellSize, startY + j * cellSize);
        }

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(stickWidth);

        for (Stick stick : sticks) {
            double modifiedStartX = startX + (stick.startX * cellSize);
            double modifiedStartY = startY + (stick.startY * cellSize);
            double modifiedEndX = startX + (stick.endX * cellSize);
            double modifiedEndY = startY + (stick.endY * cellSize);

            if (stick.isHorizontal) {
                modifiedEndX += cellSize;
            } else {
                modifiedEndY += cellSize;
            }

            gc.strokeLine(modifiedStartX, modifiedStartY, modifiedEndX, modifiedEndY);
        }

        for (Stone stone : stones) {
            stone.draw(gc);
        }
    }
}