package nl.joppe.game;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import nl.joppe.listeners.KeyboardListener;
import nl.joppe.listeners.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static nl.joppe.utilz.Constants.PlayerConstants.*;
import static nl.joppe.utilz.Constants.PlayerConstants.GetSpriteAmount;
import static nl.joppe.utilz.Constants.Directions.*;



public class GamePanel extends JPanel {
    private int xDelta = 0, yDelta = 0;
    private BufferedImage image;
    private BufferedImage[][] animations;

    private int aniTick, aniIndex, aniSpeed = 150;
    private int playerAction = IDLE;
    private static int playerDir = -1;
    private static boolean moving = false;


    public GamePanel() throws IOException {
        MouseListener mouseListener = new MouseListener();

        importImg();
        loadAnimations();

        KeyboardListener keyboardListener = new KeyboardListener(this);
        setPanelSize();
        addKeyListener(keyboardListener);
        addMouseListener(mouseListener);
        this.requestFocus();
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
                animations[j][i] = image.getSubimage(i * 64,  j * 10, 64, 40);


    }


    private void importImg() throws IOException {
        InputStream is = getClass().getResourceAsStream("/Player_sprites.png");
        try {
            image = ImageIO.read(is);
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

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

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
                    xDelta-=5;
                    break;
                case UP:
                    yDelta-=5;
                    break;
                case RIGHT:
                    xDelta+= 5;
                    break;
                case DOWN:
                    yDelta+= 5;
                    break;
            }
        }
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        UpdateAnimationTick();
        setAnimation();
        updatePos();

        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
        repaint();
    }
}