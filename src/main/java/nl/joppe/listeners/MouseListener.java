package nl.joppe.listeners;

import nl.joppe.game.GamePanel;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                GamePanel gamePanel = null;
                if(e.getButton() == MouseEvent.BUTTON1)
                    GamePanel.getGame().getPlayer().setAttacking(true);
                System.out.println("Left button");
                break;
            case MouseEvent.BUTTON2:
                //middle button
                System.out.println("Middle button");
                break;
            case MouseEvent.BUTTON3:
                //right button
                System.out.println("Right button");
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
