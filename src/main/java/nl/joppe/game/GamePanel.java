package nl.joppe.game;

import nl.joppe.listeners.KeyboardListener;
import nl.joppe.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static nl.joppe.game.Game.GAME_HEIGHT;
import static nl.joppe.game.Game.GAME_WIDTH;


public class GamePanel extends JPanel {
    private static Game game;

    public GamePanel(Game game)  {
        MouseListener mouseListener = new MouseListener();
        this.game = game;
        addKeyListener(new KeyboardListener(this));
        addMouseListener(mouseListener);
        setPanelSize();
        this.setFocusable(true);
        this.requestFocus();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void updateGame(){
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public static Game getGame(){
        return game;
    }
}