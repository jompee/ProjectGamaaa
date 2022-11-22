package nl.joppe.entities;

import java.awt.*;

public abstract class Entity {

    protected float x,y;
    protected int width, height;
    protected Rectangle hitbox;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initHitBox();
    }
    protected void drawhitbox(Graphics g){
        // de bugging hitbox
        g.setColor(Color.pink);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    private void initHitBox() {
        hitbox = new Rectangle((int)x ,(int ) y, width, height);
    }
    protected void updateHitbox(){
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }
    public Rectangle getHitbox() {
        return hitbox;
    }
}
