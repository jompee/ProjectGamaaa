package nl.joppe.entities;

import nl.joppe.game.Game;

import static nl.joppe.utilz.Constants.Directions.LEFT;
import static nl.joppe.utilz.Constants.EnemyConstants.*;
import static nl.joppe.utilz.HelpMethods.*;

public class Crabby extends Enemy {

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));

    }

    public void update(int[][] lvlData) {
        updateMove(lvlData);
        updateAnimationTick();

    }
    private void updateMove(int[][] lvlData) {
        if (firstUpdate)
            firstUpdateCheck(lvlData);
        if (inAir)
            updateInAir(lvlData);
        else {
            switch (enemyState) {
                case IDLE:
                    enemyState = RUNNING;
                    break;
                case RUNNING:
                    move(lvlData);
                    break;
            }
        }
    }
}



