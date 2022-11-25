package nl.joppe.entities;

import nl.joppe.game.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static nl.joppe.utilz.Constants.Directions.RIGHT;
import static nl.joppe.utilz.Constants.EnemyConstants.*;

public class Crabby extends Enemy {

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));

    }

}


