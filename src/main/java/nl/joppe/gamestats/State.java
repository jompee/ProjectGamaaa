package nl.joppe.gamestats;

import nl.joppe.ui.MenuButton;

import java.awt.event.MouseEvent;

public class State {

    protected String game;

    public State(String game) {
        this.game = game;
    }
    public boolean isIn(MouseEvent e, MenuButton menuButton) {
        return menuButton.getBounds().contains(e.getX(), e.getY());
    }

    public String getGame() {
        return game;
    }
}
