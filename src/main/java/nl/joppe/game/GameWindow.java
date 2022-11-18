package nl.joppe.game;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame frame;

    public GameWindow(GamePanel panel){
        frame = new JFrame();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        }
}
