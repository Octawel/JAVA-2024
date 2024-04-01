package Compulsory;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawingPanel extends JPanel {
    private int gridSize = 10;

    public DrawingPanel() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    public void setGridSize(int size) {
        this.gridSize = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        int cellWidth = getWidth() / gridSize;
        int cellHeight = getHeight() / gridSize;
        for (int i = 0; i <= gridSize; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }
    }
}
