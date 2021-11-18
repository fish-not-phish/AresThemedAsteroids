package com.aresThemeAsteroids;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.UnsupportedAudioFileException;

import tools.Vector2;

public class FlakDrone extends GameObject {
	private int health;
	private Sprite hitSprite;
	private long lastHitTime;
	private long lastFired;
	private long fireRate;
	private boolean isActive;
	
	private Random rand = new Random();
	
	public FlakDrone (Vector2 pos, Vector2 vel, double radius) {
		super(pos, vel, radius, Color.gray, Game.framesFlakDrone, Game.FRAME_TIME);
		this.lastFired = System.currentTimeMillis();
		this.fireRate = 425;
		isActive = false;
		health = Game.FLAK_DRONE_HEALTH;
		hitSprite = new Sprite(Game.framesFlakDroneOverlay, Game.FRAME_TIME, sprite.getStartFrame());
		lastHitTime = 0;
	}
	
	public boolean isInRange(GameObject other) {
		return this.getPos().dist(other.getPos()) < 350;
	}
	
	public void fire(ArrayList<Projectile> projectiles) {
		if (System.currentTimeMillis() - lastFired > fireRate) {
			for (int i = 0; i < 4; i++) {
				spawnProjectile(projectiles);
			}
			lastFired = System.currentTimeMillis();
		}
	}
	
	public void update(ArrayList<Ship> ships, ArrayList<Projectile> projectiles, ArrayList<Asteroid> asteroids, ArrayList<FlakDrone> flakDrones, ArrayList<Debris> debris, ArrayList<Particles> particles) {
		super.update(ships, projectiles, asteroids, flakDrones, debris, particles);
		if (!ships.isEmpty()) {
			if (this.isInRange(ships.get(0))) {
				this.fire(projectiles);
			}
		}	
		
	}
	
	public boolean isActive(GameObject other) {
		if (this.isInRange(other)) {
			return true;
		}
		return false;
	}
	
	private void spawnProjectile(ArrayList<Projectile> projectiles) {
		int projectile = rand.nextInt(3);
		Projectile p = null;
		if (projectile == 0) {
			Vector2 vel = new Vector2(-Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY, -Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY);
			p = ProjectileFactory.createFlak(pos, vel, 500, this.getClass());
			p.getFireSound().play();
		} else if (projectile == 1){
			Vector2 vel = new Vector2(-Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY, -Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY);
			p = ProjectileFactory.createFlak(pos, vel, 750, this.getClass());
			p.getFireSound().play();
		} else if (projectile == 2) {
			Vector2 vel = new Vector2(-Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY, -Game.NEUTRON_VELOCITY, Game.NEUTRON_VELOCITY);
			p = ProjectileFactory.createMissle(pos, vel, Game.MISSILE_DURATION, this.getClass());
			p.getFireSound().play();
		} 
		
		projectiles.add(p);
	}
	
	public void resolveCollision(GameObject other) {
		if (other instanceof Projectile && ((Projectile) other).getOwner() == Ship.class)  {
			lastHitTime = System.currentTimeMillis();
			Projectile p = (Projectile) other;
			p.getHitSound().play();
			ParticleEffect impact = new ParticleEffect(p.getPos(), p.getRadius(), p.getHitFrame(), Game.FRAME_TIME, Game.EXPLOSION_DURATION);
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
}
