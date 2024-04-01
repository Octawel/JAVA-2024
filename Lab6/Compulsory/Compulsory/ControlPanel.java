package Compulsory;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JButton("Load"));
        add(new JButton("Save"));
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }
}
