package Compulsory;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GameFrame extends JFrame {
    private final ConfigPanel configPanel;
    private final DrawingPanel canvas;
    private final ControlPanel controlPanel;

    public GameFrame() {

        setTitle("My Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel();
        controlPanel = new ControlPanel();

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}
