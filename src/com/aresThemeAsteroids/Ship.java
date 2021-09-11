package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.sound.sampled.UnsupportedAudioFileException;

import tools.DrawTools;
import tools.ImageTools;
import tools.Vector2;

public class Ship extends GameObject {
	private Set<Integer> processed;
	private Set<Integer> keys;
	private int health;
	private Vector2 direction;
	private long lastFired;
	private long fireRate;
	private long lastHitTime;
	private Sprite hitSprite;
	private Frames hitFrame;
	private String name;
	
	public Ship(Set<Integer> keys, Set<Integer> processed, double radius, Frames frame, Frames overlay, int health, String name) {
		super(new Vector2 (Game.WIDTH / 2, Game.HEIGHT / 2), Vector2.zero(), radius, Color.white, frame, Game.FRAME_TIME);
//		-Math.PI / 2
		lastHitTime = 0;
		this.health =  health;
		this.keys = keys;
		this.processed = processed;
		direction = new Vector2(0, -1);
		Game.SHIP_NAME = name;
		this.name = name;
		this.hitFrame = overlay;
		hitSprite = new Sprite(hitFrame, Game.FRAME_TIME, sprite.getStartFrame());
		lastHitTime = 0;
		this.lastFired = System.currentTimeMillis();
	}

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		if (sprite == null) {
			g2.fill(new Ellipse2D.Double(pos.getX() - radius, pos.getY() - radius, radius * 2, radius * 2));
		} else {
//			BufferedImage image = sprite.getFrame();
			BufferedImage image = getSprite().getFrame();

			DrawTools.drawImageRotated(g2, image, pos.getX(), pos.getY(), direction.getAngle() + (Math.PI / 2));
		}
	}
	
	
	public void update(ArrayList<Ship> ships, ArrayList<Projectile> projectiles, ArrayList<Asteroid> asteroids, ArrayList<FlakDrone> flakDrones, ArrayList<Debris> debris) {
		super.update(ships, projectiles, asteroids, flakDrones, debris);

		for (Integer code : keys) {
			if (code == KeyEvent.VK_UP) {
				vel = vel.add(direction.mul(Game.SHIP_THRUST));
				if (vel.length() > Game.SHIP_MAX_VELOCITY) {
					vel = vel.unit().mul(Game.SHIP_MAX_VELOCITY);
				}
			}
			if (code == KeyEvent.VK_RIGHT) {
				
				direction = direction.rot(Game.SHIP_ROTATION);
			}
			if (code == KeyEvent.VK_LEFT) {
				
				direction = direction.rot(-Game.SHIP_ROTATION);
			}
		}
		if (this.getName() == "Ele Cruiser") {
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
		        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createOnas(projectilePos, direction.mul(Game.ONAS_VELOCITY), Game.ONAS_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SPACE);
			}
		} else if (this.getName() == "Escort") {
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
		        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createInasa(projectilePos, direction.mul(Game.INASA_VELOCITY), Game.INASA_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SPACE);
			}
		} else if (this.getName() == "Gai HVD") {			
			if (keys.contains(KeyEvent.VK_SHIFT) && !processed.contains(KeyEvent.VK_SHIFT)) {
				Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createMissle(projectilePos, direction.mul(Game.MISSILE_VELOCITY), Game.MISSILE_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SHIFT);
			}
			
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
				Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createNeutron(projectilePos, direction.mul(Game.NEUTRON_VELOCITY), Game.NEUTRON_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SPACE);
			}
		} else if (this.getName() == "Ish HVD") {
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
		        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createBullet(projectilePos, direction.mul(Game.BULLET_VELOCITY), Game.BULLET_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SPACE);
			}
			
			if (keys.contains(KeyEvent.VK_C) && !processed.contains(KeyEvent.VK_C)) {
				Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createMissle(projectilePos, direction.mul(Game.MISSILE_VELOCITY), Game.MISSILE_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_C);
			}
			
			if (keys.contains(KeyEvent.VK_SHIFT) && !processed.contains(KeyEvent.VK_SHIFT)) {
				Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
				Projectile p = ProjectileFactory.createNeutron(projectilePos, direction.mul(Game.NEUTRON_VELOCITY), Game.NEUTRON_DURATION, this.getClass());
				projectiles.add(p);
				p.getFireSound().play();
				processed.add(KeyEvent.VK_SHIFT);
			}
		}
	}
	
	public void resolveCollision(GameObject other) {
		if (other instanceof Projectile && ((Projectile) other).getOwner() != Ship.class) {
			lastHitTime = System.currentTimeMillis();
			Projectile p = (Projectile) other;
			p.getHitSound().play();
			health -= p.getDamage();
			p.setAlive(false);
		}
		if (other instanceof Asteroid) {
			GameObject.changePositions(this, other);
			GameObject.changeVelocities(this, other, 1);
			this.vel = vel.mul(0.25);
			lastHitTime = System.currentTimeMillis();
			health -= 1;
		}
	}
	
	public int getHealth() {
		return health;
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


	public void setHealth(int health) {
		this.health = health;
	}


	public String getName() {
		return name;
	}
}
