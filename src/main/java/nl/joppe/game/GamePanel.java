package nl.joppe.game;

import nl.joppe.listeners.KeyboardListener;
import nl.joppe.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int xDelta = 0, yDelta = 0;
    public GamePanel(){
        MouseListener mouseListener = new MouseListener();
        KeyboardListener keyboardListener = new KeyboardListener(this);
        addKeyListener(keyboardListener);
        addMouseListener(mouseListener);
        this.requestFocus();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }

    public void changeXDelta(int value){
        this.xDelta += value;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
        repaint();
    }
}
