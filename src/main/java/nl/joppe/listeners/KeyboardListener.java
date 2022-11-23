package nl.joppe.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nl.joppe.game.Game;
import nl.joppe.game.GamePanel;
import nl.joppe.gamestats.Gamestate;

import static nl.joppe.utilz.Constants.Directions.*;

public class KeyboardListener implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
                break;
            default:
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            default:
                break;
        }
    }
}