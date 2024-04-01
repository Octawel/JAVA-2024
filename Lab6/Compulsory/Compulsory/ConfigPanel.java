package Compulsory;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    private final JTextField gridSizeField;
    private final JButton newGameButton;
    private final GameFrame frame;

    public ConfigPanel(GameFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JLabel("Grid size:"));
        gridSizeField = new JTextField("10", 5);
        add(gridSizeField);
        newGameButton = new JButton("Create");
        newGameButton.addActionListener(new NewGameAction());
        add(newGameButton);
    }

    private class NewGameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int gridSize = Integer.parseInt(gridSizeField.getText());
                frame.getCanvas().setGridSize(gridSize);
                frame.getCanvas().repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the grid size.");
            }
        }
    }
}