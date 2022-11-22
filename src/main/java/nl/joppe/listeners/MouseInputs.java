package nl.joppe.listeners;

import nl.joppe.game.GamePanel;
import nl.joppe.gamestats.Gamestate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements java.awt.event.MouseListener, MouseMotionListener {
    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING:
                GamePanel.getGame().getPlaying().mouseClicked(e);
                break;
            default:
                break;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state) {
            case MENU:
                GamePanel.getGame().getMenu().mousePressed(e);
                break;
            case PLAYING:
                GamePanel.getGame().getPlaying().mousePressed(e);
                break;
            default:
                break;

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state) {
            case MENU:
                GamePanel.getGame().getMenu().mouseReleased(e);
                break;
            case PLAYING:
                GamePanel.getGame().getPlaying().mouseReleased(e);
                break;
            default:
                break;

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state) {
            case MENU:
                GamePanel.getGame().getMenu().mouseMoved(e);
                break;
            case PLAYING:
                GamePanel.getGame().getPlaying().mouseMoved(e);
                break;
            default:
                break;

        }

    }
}
