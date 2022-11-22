package nl.joppe.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nl.joppe.game.Game;
import nl.joppe.game.GamePanel;
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
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                GamePanel.getGame().getPlayer().setUp(false);
                System.out.println("w");
                break;
            case KeyEvent.VK_A:
                GamePanel.getGame().getPlayer().setLeft(false);
                System.out.println("a");
                break;
            case KeyEvent.VK_S:
                GamePanel.getGame().getPlayer().setDown(false);
                System.out.println("s");
                break;
            case KeyEvent.VK_D:
                GamePanel.getGame().getPlayer().setRight(false);
                System.out.println("d");
                break;
                case KeyEvent.VK_SPACE:
                    GamePanel.getGame().getPlayer().setUp(true);
                    break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                GamePanel.getGame().getPlayer().setUp(true);
                System.out.println("w");
                break;
            case KeyEvent.VK_A:
                GamePanel.getGame().getPlayer().setLeft(true);
                System.out.println("a");
                break;
            case KeyEvent.VK_S:
                GamePanel.getGame().getPlayer().setDown(true);
                System.out.println("s");
                break;
            case KeyEvent.VK_D:
                GamePanel.getGame().getPlayer().setRight(true);
                System.out.println("d");
                break;
            case KeyEvent.VK_SPACE:
                GamePanel.getGame().getPlayer().setUp(true);
                break;
        }
    }
}
