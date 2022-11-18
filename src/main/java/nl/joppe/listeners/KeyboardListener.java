package nl.joppe.listeners;

import nl.joppe.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private GamePanel panel;

    public KeyboardListener(GamePanel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                panel.changeYDelta(-5);
                System.out.println("w");
                break;
            case KeyEvent.VK_A:
                panel.changeXDelta(-5);
                System.out.println("a");
                break;
            case KeyEvent.VK_S:
                panel.changeYDelta(5);
                System.out.println("s");
                break;
            case KeyEvent.VK_D:
                panel.changeXDelta(5);
                System.out.println("d");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
