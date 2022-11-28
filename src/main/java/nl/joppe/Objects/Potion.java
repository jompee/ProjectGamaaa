package nl.joppe.Objects;


import nl.joppe.game.Game;

public class Potion extends GameObject {

    public float hoverOffSet;
    private int maxHoverOffSet, hoverDir = 1;

    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        initHitbox(7, 14);
        xDrawOffset = (int)(3 * Game.SCALE);
        yDrawOffset = (int)(2 * Game.SCALE);

        maxHoverOffSet = (int)(10 * Game.SCALE);
        
    }

    public void update() {
        updateAnimationTick();
        updateHover();
    }

    private void updateHover() {
        hoverOffSet += (0.050f * Game.SCALE * hoverDir);
        if (hoverOffSet >= maxHoverOffSet)
            hoverDir = -1;
        else if (hoverOffSet < 0)
            hoverDir = 1;

        hitbox.y = y + hoverOffSet;


    }
}
