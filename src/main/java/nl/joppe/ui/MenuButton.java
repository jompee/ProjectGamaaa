package nl.joppe.ui;

import nl.joppe.gamestats.Gamestate;
import nl.joppe.utilz.Loadsave;

import java.awt.*;
import java.awt.image.BufferedImage;
import static nl.joppe.utilz.Constants.UI.Buttons.*;

public class MenuButton {
    private int xPos, yPos, rowIndex ,index;
    private int xOffSetCenter = B_WIDTH / 2;
    private Gamestate state;
    private BufferedImage[] images;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImages();
        initBounds();

    }

    private void initBounds() {
        bounds = new Rectangle(xPos - xOffSetCenter ,yPos, B_WIDTH, B_HEIGHT);
    }

    private void loadImages() {
        images = new BufferedImage[3];
        BufferedImage temp = Loadsave.GetSpriteAtlas(Loadsave.MENU_BUTTONS);
        for (int i = 0; i < images.length; i++)
            images[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }

    public void draw(Graphics g){
        g.drawImage(images[index], xPos - xOffSetCenter, yPos, B_WIDTH, B_HEIGHT, null);

    }
    public void update() {
        index = 0;
        if (mouseOver)
            index = 1;
        if (mousePressed)
            index = 2;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public void applyGameState() {
        Gamestate.state = state;
    }
    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }
}