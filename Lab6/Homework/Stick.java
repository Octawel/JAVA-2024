package Homework;

import java.io.Serializable;

public class Stick implements Serializable {
    final double startX;
    final double startY;
    final double endX;
    final double endY;
    final boolean isHorizontal;


    public Stick(int startX, int startY, int endX, int endY, boolean isHorizontal) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.isHorizontal = isHorizontal;
    }

    public boolean connectsPoints(int cellX1, int cellY1, int cellX2, int cellY2, double cellSize) {
        double canvasX1 = cellX1 * cellSize + cellSize / 2;
        double canvasY1 = cellY1 * cellSize + cellSize / 2;
        double canvasX2 = cellX2 * cellSize + cellSize / 2;
        double canvasY2 = cellY2 * cellSize + cellSize / 2;

        boolean matchesStart = (startX == canvasX1 && startY == canvasY1) || (startX == canvasX2 && startY == canvasY2);
        boolean matchesEnd = (endX == canvasX1 && endY == canvasY1) || (endX == canvasX2 && endY == canvasY2);

        return matchesStart && matchesEnd;
    }
}
