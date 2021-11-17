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
			GameObject.changeVelocities(this, other, 1);
			Projectile p = (Projectile) other;
			p.getHitSound().play();
			ParticleEffect impact;
			if (p.isHoming()) {
				impact = new ParticleEffect(p.getPos(), p.getRadius(), p.getHitFrame(), Game.FRAME_TIME, 1000);
			}
			else if (p.isLaser()) {
				impact = new ParticleEffect(p.getPos(), p.getRadius(), p.getHitFrame(), Game.FRAME_TIME, 0);
			}
			else {
				impact = new ParticleEffect(p.getPos(), p.getRadius(), p.getHitFrame(), Game.FRAME_TIME, 400);
			}
			Game.particleEffects.add(impact);
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
