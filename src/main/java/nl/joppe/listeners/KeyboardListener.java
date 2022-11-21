package nl.joppe.listeners;

import nl.joppe.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static nl.joppe.utilz.Constants.Directions.*;


public class KeyboardListener implements KeyListener {

    private GamePanel panel;

    public KeyboardListener(GamePanel panel){
        this.panel = null;
        assert this.panel == null;
        this.panel = panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                GamePanel.setDirection(UP);
                System.out.println("w");
                break;
            case KeyEvent.VK_A:
                GamePanel.setDirection(LEFT);
                System.out.println("a");
                break;
            case KeyEvent.VK_S:
                GamePanel.setDirection(DOWN);
                System.out.println("s");
                break;
            case KeyEvent.VK_D:
                GamePanel.setDirection(RIGHT);
                System.out.println("d");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                GamePanel.setMoving(false);
                break;

        }
    }
}
