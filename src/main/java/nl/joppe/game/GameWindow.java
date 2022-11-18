package nl.joppe.game;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame frame;

    public GameWindow(GamePanel panel){
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
