package nl.joppe.Levels;

import nl.joppe.utilz.Loadsave;

public class Level {

    private int[][] lvlData;

    public Level(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }

}

