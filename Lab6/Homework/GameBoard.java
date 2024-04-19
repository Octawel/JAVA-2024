package Homework;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard extends StackPane {
    private int gridWidth;
    private int gridHeight;
    private DrawingPanel drawingPanel;
    private List<Stick> sticks;
    private List<Stone> stones;
    private double cellSize;
    private final double stickWidth = 5.0;
    private final double stoneRadius = 10.0;
    private Stone lastPlacedStone = null;


    public GameBoard(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        drawingPanel = new DrawingPanel(400, 400);
        drawingPanel.setPrefSize(400, 400);
        this.getChildren().add(drawingPanel);

        drawingPanel.widthProperty().addListener((obs, oldVal, newVal) -> redrawBoard());
        drawingPanel.heightProperty().addListener((obs, oldVal, newVal) -> redrawBoard());

        System.out.println("Initial DrawingPanel size: " + drawingPanel.getWidth() + "x" + drawingPanel.getHeight());

        sticks = new ArrayList<>();
        stones = new ArrayList<>();

        updateCellSize();
        initializeNewGame(width, height);
    }

    public double getCellSize() {
        return cellSize;
    }

    public double getOffsetX() {
        return (drawingPanel.getWidth() - (gridWidth * cellSize)) / 2;
    }

    public double getOffsetY() {
        return (drawingPanel.getHeight() - (gridHeight * cellSize)) / 2;
    }

    private void updateCellSize() {
        double panelWidth = drawingPanel.getWidth();
        double panelHeight = drawingPanel.getHeight();
        this.cellSize = Math.min(panelWidth / gridWidth, panelHeight / gridHeight);
    }

    private void redrawBoard() {
        updateCellSize();

        if (sticks != null && stones != null) {
            drawingPanel.drawBoard(sticks, stones, gridWidth, gridHeight, cellSize);
        }
    }

    private void initializeSticks() {
        Random random = new Random();
        sticks.clear();

        for (int i = 0; i < gridWidth - 1; i++) {
            for (int j = 0; j < gridHeight - 1; j++) {
                // Horizontal stick
                if (random.nextBoolean()) {
                    sticks.add(new Stick(i, j, i + 1, j, true));
                }
                // Vertical stick
                if (random.nextBoolean()) {
                    sticks.add(new Stick(i, j, i, j + 1, false));
                }
            }
        }
    }

    public void placeStone(double screenX, double screenY, Color color) {
        double offsetX = getOffsetX();
        double offsetY = getOffsetY();

        double snappedX = Math.round((screenX - offsetX) / cellSize) * cellSize;
        double snappedY = Math.round((screenY - offsetY) / cellSize) * cellSize;

        double stoneX = snappedX + offsetX - stoneRadius;
        double stoneY = snappedY + offsetY - stoneRadius;

        if (isIntersection(snappedX / cellSize, snappedY / cellSize)) {
            if (!stoneExistsAtIntersection(snappedX, snappedY)) {
                Stone newStone = new Stone(stoneX, stoneY, stoneRadius, color);
                stones.add(newStone);
                lastPlacedStone = newStone;

                drawingPanel.drawBoard(sticks, stones, gridWidth, gridHeight, cellSize);
            }
        }
    }

    boolean isValidPlacement(int gridX, int gridY) {
        if (gridX < 0 || gridX >= gridWidth || gridY < 0 || gridY >= gridHeight) {
            return false;
        }

        for (Stone stone : stones) {
            int stoneGridX = (int) ((stone.getX() - getOffsetX()) / cellSize);
            int stoneGridY = (int) ((stone.getY() - getOffsetY()) / cellSize);
            if (gridX == stoneGridX && gridY == stoneGridY) {
                return false;
            }
        }

        if (lastPlacedStone == null) {
            return true;
        }

        int lastStoneGridX = (int) ((lastPlacedStone.getX() - getOffsetX()) / cellSize);
        int lastStoneGridY = (int) ((lastPlacedStone.getY() - getOffsetY()) / cellSize);
        if (Math.abs(lastStoneGridX - gridX) > 1 || Math.abs(lastStoneGridY - gridY) > 1) {
            return false;
        }

        if (!stickExistsBetween(lastStoneGridX, lastStoneGridY, gridX, gridY)) {
            return false;
        }

        return true;
    }

    private boolean isIntersection(double gridX, double gridY) {
        return gridX >= 0 && gridX < gridWidth && gridY >= 0 && gridY < gridHeight;
    }

    private boolean stoneExistsAtIntersection(double snappedX, double snappedY) {
        double offsetX = getOffsetX();
        double offsetY = getOffsetY();

        for (Stone stone : stones) {
            if (Math.abs(stone.getX() - (snappedX + offsetX)) < stoneRadius &&
                    Math.abs(stone.getY() - (snappedY + offsetY)) < stoneRadius) {
                return true;
            }
        }
        return false;
    }


    private boolean stickExistsBetween(int cellX1, int cellY1, int cellX2, int cellY2) {
        for (Stick stick : sticks) {
            if (stick.connectsPoints(cellX1, cellY1, cellX2, cellY2, cellSize)) {
                return true;
            }
        }
        return false;
    }

    public void initializeNewGame(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        sticks.clear();
        stones.clear();
        initializeSticks();
        drawingPanel.drawBoard(sticks, stones, gridWidth, gridHeight, cellSize);
    }

    public void saveGame() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Game");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files", "*.ser"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(sticks);
                out.writeObject(stones);
            } catch (IOException e) {
                System.err.println("Failed to save the game: " + e.getMessage());
            }
        }
    }

    public void loadGame() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Game");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files", "*.ser"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                sticks = (List<Stick>) in.readObject();
                stones = (List<Stone>) in.readObject();
                drawingPanel.drawBoard(sticks, stones, gridWidth, gridHeight, cellSize);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Failed to load the game: " + e.getMessage());
            }
        }
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        double newCellWidth = drawingPanel.getWidth() / gridWidth;
        double newCellHeight = drawingPanel.getHeight() / gridHeight;
        double newCellSize = Math.min(newCellWidth, newCellHeight);

        if (newCellSize > 0) {
            this.cellSize = newCellSize;
            drawingPanel.drawBoard(sticks, stones, gridWidth, gridHeight, cellSize);
        }
    }
}

