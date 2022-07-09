package asteroids;
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
import java.util.Random;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tools.DrawTools;
import tools.ImageTools;
import tools.Vector2;

public class Ship extends GameObject {
	private Set<Integer> processed;
	private Set<Integer> keys;
	private int health;
	private Vector2 direction;
	private long lastHitTime;
	private Sprite hitSprite;
	private Frames hitFrame;
	private String name;
	private int ricochet = 0;
	
//	fire rates
	private long missleFireRate;
	private long missleLastFired;
	private long onasFireRate;
	private long onasLastFired;
	private long inasaFireRate;
	private long inasaLastFired;
	private long gLaserFireRate;
	private long gLaserLastFired;
	private long neutronFireRate;
	private long neutronLastFired;
	private long magnetoFireRate;
	private long magnetoLastFired;
	private long lectroFireRate;
	private long lectroLastFired;
	private long eleLaserFireRate;
	private long eleLaserLastFired;
	private long gunshotFireRate;
	private long gunshotLastFired;
	
	public Ship(Set<Integer> keys, Set<Integer> processed, double radius, Frames frame, Frames overlay, int health, String name) {
		super(new Vector2 (Game.WIDTH / 2, Game.HEIGHT / 2), Vector2.zero(), radius, Color.white, frame, Game.FRAME_TIME);
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
		this.missleFireRate = 1075;
		this.missleLastFired = 0;
		this.onasFireRate = 225;
		this.onasLastFired = 0;
		this.inasaFireRate = 275;
		this.inasaLastFired = 0;
		this.gLaserFireRate = 275;
		this.gLaserLastFired = 0;
		this.neutronFireRate = 200;
		this.neutronLastFired = 0;
		this.magnetoFireRate = 175;
		this.magnetoLastFired = 0;
		this.lectroFireRate = 150;
		this.lectroLastFired = 0;
		this.eleLaserFireRate = 375;
		this.eleLaserLastFired = 0;
		this.gunshotFireRate = 75;
		this.gunshotLastFired = 0;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		if (sprite == null) {
			g2.fill(new Ellipse2D.Double(pos.getX() - radius, pos.getY() - radius, radius * 2, radius * 2));
		} else {
			BufferedImage image = getSprite().getFrame();

			DrawTools.drawImageRotated(g2, image, pos.getX(), pos.getY(), direction.getAngle() + (Math.PI / 2));
		}
	}
	
	public void update(ArrayList<Ship> ships, ArrayList<Projectile> projectiles, ArrayList<Asteroid> asteroids, ArrayList<FlakDrone> flakDrones, ArrayList<Debris> debris, ArrayList<Particles> particles) {
		super.update(ships, projectiles, asteroids, flakDrones, debris, particles);

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
			
			if (code == KeyEvent.VK_DOWN) {
//				temp fix for stopping slowly instead of instantaniously
				if (vel != Vector2.zero()) {
					if (vel.getX() > 0.00) {
						vel.setX(vel.getX()-Game.SHIP_THRUST);
					}
					else if (vel.getX() < 0.00) {
						vel.setX(vel.getX()+Game.SHIP_THRUST);
					}
					if (vel.getY() > 0.00) {
						vel.setY(vel.getY()-Game.SHIP_THRUST);
					}
					else if (vel.getY() < 0.00) {
						vel.setY(vel.getY()+Game.SHIP_THRUST);
					}
					if (((vel.getX() <= 0.05) && (vel.getX() >= -0.05)) && ((vel.getY() <= 0.05) && (vel.getY() >= -0.05))) {
						vel = Vector2.zero();
					}
				}
			}
		}
		
		if (this.getName() == "Ele Cruiser") {
			if (keys.contains(KeyEvent.VK_SPACE)) {
				if (System.currentTimeMillis() - onasLastFired > onasFireRate) {
			        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createOnas(projectilePos, direction.mul(Game.ONAS_VELOCITY).add(this.getVel()), Game.ONAS_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					onasLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
			
			if (keys.contains(KeyEvent.VK_SHIFT)) {
				if (System.currentTimeMillis() - eleLaserLastFired > eleLaserFireRate) {
			        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createEleLaser(projectilePos, direction.mul(Game.ELELASER_VELOCITY).add(this.getVel()), Game.ELELASER_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					eleLaserLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
			
		} else if (this.getName() == "Escort") {
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
				if (System.currentTimeMillis() - inasaLastFired > inasaFireRate) {
			        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createInasa(projectilePos, direction.mul(Game.INASA_VELOCITY).add(this.getVel()), Game.INASA_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					inasaLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
			
			if (keys.contains(KeyEvent.VK_SHIFT) && !processed.contains(KeyEvent.VK_SHIFT)) {
				if (System.currentTimeMillis() - gLaserLastFired > gLaserFireRate) {
					Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createGLaser(projectilePos, direction.mul(Game.G_LASER_VELOCITY).add(this.getVel()), Game.G_LASER_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					gLaserLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SHIFT);
			}
		} else if (this.getName() == "Gai HVD") {			
			if (keys.contains(KeyEvent.VK_C) && !processed.contains(KeyEvent.VK_C)) {
				if (System.currentTimeMillis() - missleLastFired > missleFireRate) {
//					Vector2 tempPos = new Vector2(pos.getX() + 20, pos.getY());
					Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createMissle(projectilePos, direction.mul(Game.MISSILE_VELOCITY).add(this.getVel()), Game.MISSILE_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					missleLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SHIFT);
			}
			
			if (keys.contains(KeyEvent.VK_SHIFT) && !processed.contains(KeyEvent.VK_SHIFT)) {
				if (System.currentTimeMillis() - gunshotLastFired > gunshotFireRate) {
					Vector2 projectilePos = pos.add(direction.mul((sprite.getFrame().getHeight() / 2)  + 10));
					if (ricochet == 0) {
						Projectile p = ProjectileFactory.createGunshot1(projectilePos, direction.mul(Game.GUN_VELOCITY).add(this.getVel()), Game.GUN_DURATION, this.getClass());
						Projectile p1 = ProjectileFactory.createGunsmoke1(projectilePos, direction.mul(0.1), 1, this.getClass());
						projectiles.add(p);
						projectiles.add(p1);
						p.getFireSound().play();
					} else {
						Projectile p = ProjectileFactory.createGunshot2(projectilePos, direction.mul(Game.GUN_VELOCITY).add(this.getVel()), Game.GUN_DURATION, this.getClass());
						Projectile p1 = ProjectileFactory.createGunsmoke2(projectilePos, direction.mul(1), 1, this.getClass());
						projectiles.add(p);
						projectiles.add(p1);
						p.getFireSound().play();
					}
					gunshotLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
			
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
				if (System.currentTimeMillis() - neutronLastFired > neutronFireRate) {
					Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createNeutron(projectilePos, direction.mul(Game.NEUTRON_VELOCITY).add(this.getVel()), Game.NEUTRON_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					neutronLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
		} else if (this.getName() == "Ish HVD") {
			if (keys.contains(KeyEvent.VK_SPACE) && !processed.contains(KeyEvent.VK_SPACE)) {
				if (System.currentTimeMillis() - magnetoLastFired > magnetoFireRate) {
			        Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createMagneto(projectilePos, direction.mul(Game.MAGNETO_VELOCITY).add(this.getVel()), Game.MAGNETO_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					magnetoLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SPACE);
			}
			
			if (keys.contains(KeyEvent.VK_C) && !processed.contains(KeyEvent.VK_C)) {
				if (System.currentTimeMillis() - missleLastFired > missleFireRate) {
					Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createMissle(projectilePos, direction.mul(Game.MISSILE_VELOCITY).add(this.getVel()), Game.MISSILE_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					missleLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_C);
			}
			
			if (keys.contains(KeyEvent.VK_SHIFT) && !processed.contains(KeyEvent.VK_SHIFT)) {
				if (System.currentTimeMillis() - lectroLastFired > lectroFireRate) {
					Vector2 projectilePos = pos.add(direction.mul(sprite.getFrame().getHeight() / 2));
					Projectile p = ProjectileFactory.createLectro(projectilePos, direction.mul(Game.LECTRO_VELOCITY).add(this.getVel()), Game.LECTRO_DURATION, this.getClass());
					projectiles.add(p);
					p.getFireSound().play();
					lectroLastFired = System.currentTimeMillis();
				}
//				processed.add(KeyEvent.VK_SHIFT);
			}
		}
	}
	
	public void resolveCollision(GameObject other) {
		if (other instanceof Projectile && ((Projectile) other).getOwner() != Ship.class) {
			lastHitTime = System.currentTimeMillis();
			Projectile p = (Projectile) other;
			p.getHitSound().play();
			ParticleEffect impact = new ParticleEffect(p.getPos(), p.getRadius(), p.getHitFrame(), Game.FRAME_TIME, Game.EXPLOSION_DURATION);
			Game.particleEffects.add(impact);
			health -= p.getDamage();
			p.setAlive(false);
			RectangleParticleEffect flash = new RectangleParticleEffect(new Vector2(Game.WIDTH / 2, Game.HEIGHT /2), Game.WIDTH / 2, Color.white, Game.WIDTH, Game.HEIGHT, Game.SCREEN_FLASH_DURATION);
			Game.particleEffects.add(flash);
		}
		
		if (other instanceof Asteroid) {
			GameObject.changePositions(this, other);
			GameObject.changeVelocities(this, other, 1);
			this.vel = vel.mul(0.25);
			lastHitTime = System.currentTimeMillis();
			health -= 1;
			RectangleParticleEffect flash = new RectangleParticleEffect(new Vector2(Game.WIDTH / 2, Game.HEIGHT /2), Game.WIDTH / 2, Color.white, Game.WIDTH, Game.HEIGHT, Game.SCREEN_FLASH_DURATION);
			Game.particleEffects.add(flash);
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
