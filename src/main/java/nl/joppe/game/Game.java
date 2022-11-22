package nl.joppe.game;

import nl.joppe.Levels.LevelManager;
import nl.joppe.entities.Player;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow window;
    private GamePanel panel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Player player;
    private LevelManager levelManager;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static int SCALE = (int) 2f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = TILES_DEFAULT_SIZE * SCALE;
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game() throws Exception {
        initClasses();
        panel = new GamePanel(this);
        window = new GameWindow(panel);
        panel.setFocusable(true);
        panel.requestFocus();

        startGameLoop();
         try {
          startGameLoop();
          System.out.println("started game thread.");
       ; } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
    public void update (){
        player.update();
        levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
    }

    private void initClasses() {
        player = new Player(200, 200, (int)(64 * SCALE), (int)(40 * SCALE));
        levelManager = new LevelManager(this);
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
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public Player getPlayer() {
        return player;
    }
}
