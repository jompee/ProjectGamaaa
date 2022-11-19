package nl.joppe.game;

import java.io.IOException;

public class Game implements Runnable {

    private GameWindow window;
    private GamePanel panel;
    private Thread thread;
    private final int FPS_SET = 120;

    public Game() throws IOException {
        panel = new GamePanel();
        window = new GameWindow(panel);
        panel.requestFocus();
        try {
            startGameLoop();
            System.out.println("started game thread.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastChecked = System.currentTimeMillis();

        //noinspection InfiniteLoopStatement
        while (true){
            now = System.nanoTime();
            if (System.nanoTime() - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastChecked >= 1000){
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    private void startGameLoop() throws Exception {
        thread = new Thread(this);
        thread.start();
    }
}
