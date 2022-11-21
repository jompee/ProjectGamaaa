package nl.joppe.entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static nl.joppe.utilz.Constants.Directions.*;
import static nl.joppe.utilz.Constants.Directions.DOWN;
import static nl.joppe.utilz.Constants.PlayerConstants.*;

public class Player extends Entity{

    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 30;
    private int playerAction = IDLE;
    private static int playerDir = -1;
    private static boolean moving = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        UpdateAnimationTick();
        setAnimation();
        updatePos();
    }
    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);


    }
    public static void setDirection(int direction) {
        playerDir = direction;
        moving = true;
    }
    public static void setMoving(boolean moving){
        moving = moving;
    }

    private void UpdateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount (playerAction))
                aniIndex = 0;

        }
    }
    private void setAnimation() {
        if (moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }
    private void updatePos() {
        if(moving) {
            switch (playerDir) {
                case LEFT:
                    x-=5;
                    break;
                case UP:
                    y-=5;
                    break;
                case RIGHT:
                    x+= 5;
                    break;
                case DOWN:
                    y+= 5;
                    break;
            }
        }
    }
    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/Player_sprites.png");
        try {
            BufferedImage image = ImageIO.read(is);

            animations = new BufferedImage[9][6];

            for (int j = 0; j < animations.length; j++)
                for (int i = 0; i < animations[j].length; i++)
                    animations[j][i] = image.getSubimage(i * 64, j * 10, 64, 40);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
