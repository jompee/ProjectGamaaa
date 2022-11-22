package nl.joppe.gamestats;

import nl.joppe.game.Game;
import nl.joppe.ui.MenuButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu extends State implements Statemethods {

    public MenuButton[] buttons = new MenuButton[3];

    public Menu(String game) {
        super(game);
        loadButtons();

    }

    private void loadButtons() {
        buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0,Gamestate.PLAYING);
        buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1,Gamestate.OPTIONS);
        buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2,Gamestate.QUIT);

    }

    @Override
    public void update() {
        for (MenuButton menuButton : buttons)
            menuButton.update();

    }

    @Override
    public void draw(Graphics g) {
        for (MenuButton menuButton : buttons)
            menuButton.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MenuButton menuButton : buttons){
            if(isIn(e,menuButton)){
                menuButton.setMousePressed(true);
                break;
            }
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton menuButton : buttons){
            if (isIn(e,menuButton)) {
                if (menuButton.isMousePressed())
                    menuButton.applyGameState();
                break;
            }
        }
        resetButtons();

    }

    private void resetButtons() {
        for (MenuButton menuButton : buttons)
            menuButton.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton menuButton : buttons)
            menuButton.setMouseOver(false);

        for (MenuButton menuButton : buttons)
            if (isIn(e, menuButton)) {
                menuButton.setMouseOver(true);
                break;
            }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            Gamestate.state = Gamestate.PLAYING;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
