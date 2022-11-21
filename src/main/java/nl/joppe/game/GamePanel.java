package nl.joppe.game;

import nl.joppe.listeners.KeyboardListener;
import nl.joppe.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static Game game;
    public GamePanel(Game game) throws IOException {
        KeyboardListener keyboardListener = new KeyboardListener(this);
        MouseListener mouseListener = new MouseListener();
        this.game = game;

        addKeyListener(keyboardListener);
        addMouseListener(mouseListener);


        setPanelSize();
        this.requestFocus();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void updateGame(){
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        game.reder(g);

        repaint();
    }
    public static Game getGame(){
        return game;
    }
}