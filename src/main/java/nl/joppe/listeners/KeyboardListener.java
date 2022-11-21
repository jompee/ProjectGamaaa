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
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                GamePanel.getGame().getPlayer().setUp(false);
                System.out.println("w");
            case KeyEvent.VK_A:
                GamePanel.getGame().getPlayer().setLeft(false);
                System.out.println("a");
            case KeyEvent.VK_S:
                GamePanel.getGame().getPlayer().setDown(false);
                System.out.println("s");
            case KeyEvent.VK_D:
                GamePanel.getGame().getPlayer().setRight(false);
                System.out.println("d");
                break;
        }
        }
            @Override
    public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        GamePanel.getGame().getPlayer().setUp(true);
                        System.out.println("w");
                    case KeyEvent.VK_A:
                        GamePanel.getGame().getPlayer().setLeft(true);
                        System.out.println("a");
                    case KeyEvent.VK_S:
                        GamePanel.getGame().getPlayer().setDown(true);
                        System.out.println("s");
                    case KeyEvent.VK_D:
                        GamePanel.getGame().getPlayer().setRight(true);
                        System.out.println("d");
                        break;
                }
    }

}
