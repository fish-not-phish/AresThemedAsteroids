package com.aresThemeAsteroids;
import java.awt.Color;
import java.util.ArrayList;

import tools.Vector2;

public class Projectile extends GameObject {
	private long startTime;
	private long duration;
	private int damage;
	private SoundEffect fireSound;
	private SoundEffect hitSound;
	private Class<?> owner;
	private boolean isAlive;
	private Frames hitFrame;
	private boolean isHoming;
	private boolean isLaser;
	private Frames projFrame;
	private double mass;
	
	public Projectile(Vector2 pos, Vector2 vel, double radius, double mass, long duration, int damage, boolean homing, boolean laser, Frames frame, SoundEffect fireSound, SoundEffect hitSound, Frames hitFrame, Class<?> owner) {
		super(pos, vel, radius, Color.white, frame, Game.FRAME_TIME);
		this.duration = duration;
		this.fireSound = fireSound;
		this.hitSound = hitSound;
		this.damage = damage;
		this.owner = owner;
		this.projFrame = frame;
		this.hitFrame = hitFrame;
		this.isHoming = homing;
		this.isLaser = laser;
		this.mass = mass;
		isAlive = true;
		startTime = System.currentTimeMillis();
	}
	
	public void resolveCollision(GameObject other) {
		if (other instanceof Asteroid) {
			GameObject.changePositions(this, other);
			GameObject.changeVelocities(this, other, 1);
		}
	}
	
	@Override
	public void update(ArrayList<Ship> ships, ArrayList<Projectile> projectiles, ArrayList<Asteroid> asteroids, ArrayList<FlakDrone> flakDrones, ArrayList<Debris> deBris, ArrayList<Particles> particles) {
		if (isHoming) {
			if (owner != Ship.class) {
				double min = Double.MAX_VALUE;
				Ship closest = null;
				for (Ship ship: ships) {
					if (this.getPos().dist(ship.getPos()) < min) {
						min = this.getPos().dist(ship.getPos());
						closest = ship;
					}
				}
				if (closest != null) {
					Vector2 missle_to_asteroid = closest.getPos().sub(this.getPos()).unit();
					double angleBetween = this.getVel().angleBetween(missle_to_asteroid);
					double angle = Math.min(Math.abs(angleBetween), Game.PROJECTILE_MAX_ROTATION);
					if (angleBetween < 0) {
						angle *= -1;
					}
					this.setVel(this.getVel().rot(angle));
				}
			}
			else {
				double min = Double.MAX_VALUE;
				Asteroid closest = null;
				for (Asteroid asteroid: asteroids) {
					if (this.getPos().dist(asteroid.getPos()) < min) {
						min = this.getPos().dist(asteroid.getPos());
						closest = asteroid;
					}
				}
				if (closest != null) {
					Vector2 missle_to_asteroid = closest.getPos().sub(this.getPos()).unit();
					double angleBetween = this.getVel().angleBetween(missle_to_asteroid);
					double angle = Math.min(Math.abs(angleBetween), Game.PROJECTILE_MAX_ROTATION);
					if (angleBetween < 0) {
						angle *= -1;
					}
					this.setVel(this.getVel().rot(angle));
				}
			}
		}
		super.update(ships, projectiles, asteroids, flakDrones, deBris, particles);
	}
	
	public Frames getFrame() {
		return projFrame;
	}
	
	public boolean isLaser() {
		return isLaser;
	}
	
	public boolean isAlive() {
		return isAlive && startTime + duration >= System.currentTimeMillis();
	}

	public int getDamage() {
		return damage;
	}
	public double getMass() {
		return mass;
	}

	public SoundEffect getFireSound() {
		return fireSound;
	}

	public boolean isHoming() {
		return isHoming;
	}

	public SoundEffect getHitSound() {
		return hitSound;
	}

	public Class<?> getOwner() {
		return owner;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Frames getHitFrame() {
		return hitFrame;
	}

}
