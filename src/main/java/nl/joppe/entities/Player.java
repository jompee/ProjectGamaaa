package nl.joppe.entities;

import sun.security.mscapi.CPublicKey;

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
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {

        updatePos();
        UpdateAnimationTick();
        setAnimation();

    }
    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);

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

        moving = false;

        if(left && !right) {
            x-=playerSpeed;
            moving = true;
         }else if(right && !left){
            x += playerSpeed;
            moving = true;
        }
        if(up && !down) {
            y-= playerSpeed;
            moving = true;
        } else if (right && !left) {
            y-= playerSpeed;
            moving = true;

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
    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up){
        this.up = up;
    }
    public boolean isRight(){
        return right;
    }
    public void setRight(boolean right){
        this.right = right;
    }
    public boolean isDown(){
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
}
