package com.aresThemeAsteroids;
import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import tools.Vector2;

public class Asteroid extends GameObject {
	private int health;
	private Sprite hitSprite;
	private long lastHitTime;
	private Frames frame;
	private Frames hitFrame;
	private double radius;
	
	public Asteroid (Vector2 pos, Vector2 vel, double radius, Frames frame, Frames overlay, int health) {
		super(pos, vel, radius, Color.gray, frame, Game.FRAME_TIME);
		this.hitFrame = overlay;
		this.radius = radius;
		this.health = health;
		hitSprite = new Sprite(overlay, Game.FRAME_TIME, sprite.getStartFrame());
		lastHitTime = 0;
	}
	
	public void resolveCollision(GameObject other) {
		if (other instanceof Asteroid) {
			GameObject.changePositions(this, other);
			GameObject.changeVelocities(this, other, 1);
		}
		if (other instanceof Projectile) {
			lastHitTime = System.currentTimeMillis();
			Projectile p = (Projectile) other;
			p.getHitSound().play();
			health -= p.getDamage();
			p.setAlive(false);
		}
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public Sprite getSprite() {
		if (System.currentTimeMillis() - lastHitTime < Game.ASTEROID_OVERLAY_DURATION) {
			return hitSprite;
		}
		return sprite;
	}

	public Frames getFrame() {
		return frame;
	}
}
