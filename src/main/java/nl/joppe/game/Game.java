package nl.joppe.game;

import nl.joppe.entities.Player;

import java.awt.*;
import java.io.IOException;

public class Game implements Runnable {

    private GameWindow window;
    private GamePanel panel;
    private Thread thread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Player player;

    public Game() throws Exception {
        initClasses();
        panel = new GamePanel(this);
        window = new GameWindow(panel);
        panel.requestFocus();

        startGameLoop();

        try {
            startGameLoop();
            System.out.println("started game thread.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void update (){
        player.update();

    }
    public void reder(Graphics g){
        player.render(g);


    }

    private void initClasses() {
        player = new Player(200, 200);
    }


    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timepPerUpdate = 1000000000.0 / UPS_SET;
        long lastCheck = System.currentTimeMillis();
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastChecked = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        //noinspection InfiniteLoopStatement
        while (true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timepPerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                 update();
                updates++;
                deltaU--;

            }

            if (deltaF >= 1){
                panel.repaint();
                frames++;
                deltaF--;

            }

            if (System.currentTimeMillis() - lastChecked >= 1000){
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }

    }

    private void startGameLoop() throws Exception {
        thread = new Thread(this);
        thread.start();
    }
    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public Player getPlayer() {
        return player;
    }
}
