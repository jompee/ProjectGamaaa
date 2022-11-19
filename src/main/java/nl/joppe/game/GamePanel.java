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

public class GamePanel extends JPanel {

    private int xDelta = 0, yDelta = 0;
    private BufferedImage image;
    private BufferedImage[][] animations;

    private int aniTick, aniIndex, aniSpeed = 150;

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
                animations[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);


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

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    private void UpdateAnimationTick() {
          aniTick++;
          if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 6)
                  aniIndex = 0;

        }
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        UpdateAnimationTick();

        g.drawImage(animations[1][aniIndex], (int) xDelta, (int) yDelta, 128, 80, null);
        repaint();
    }
}