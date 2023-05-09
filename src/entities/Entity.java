package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	
	protected float x, y; //only classes that extend Entity may use
	
	protected Rectangle hitbox;

	private int width, height;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = x;
		this.width = width;
		this.height = height; 
		
		initHitbox();
	}
	//generating hitbox to debug, link with collision
	protected void drawHitbox(Graphics g) {
	g.setColor(Color.PINK);
	g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}

	private void initHitbox() {
		hitbox = new Rectangle((int) x, (int) y, width, height);
		
	}
	
	protected void updateHitbox() {
		hitbox.x = (int)x;
		hitbox.y = (int)y;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
}
