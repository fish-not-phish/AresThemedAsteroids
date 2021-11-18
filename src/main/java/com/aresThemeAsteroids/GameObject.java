package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tools.DrawTools;
import tools.Vector2;

import java.awt.geom.Ellipse2D;

public abstract class GameObject {
	protected double radius;
	protected Vector2 pos;
	protected Vector2 vel;
	protected Color color;
	protected Sprite sprite;
	
	public GameObject(Vector2 pos, Vector2 vel, double radius, Color color, Frames frames, long frameTime) {
		this.color = color;
		this.pos = pos;
		this.vel = vel;
		this.radius = radius;
		if (frames != null) {
			this.sprite = new Sprite(frames, frameTime, -1);
			if (radius == -1) {
				this.setRadius(sprite.getFrame().getWidth() / 2);
			}
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void draw(Graphics g) {	
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		if (getSprite() == null) {
			g2.fill(new Ellipse2D.Double(pos.getX() - radius, pos.getY() - radius, radius * 2, radius * 2));
		} else {
			BufferedImage image = getSprite().getFrame();
			DrawTools.drawImageRotated(g2, image, pos.getX(), pos.getY(), vel.getAngle() + (Math.PI / 2));
		}
	}
	
	public void update(ArrayList<Ship> ships, ArrayList<Projectile> projectiles, ArrayList<Asteroid> asteroids, ArrayList<FlakDrone> flakDrones, ArrayList<Debris> deBris, ArrayList<Particles> particles) {
		pos = pos.add(vel);
		checkBounds();
	}

	public abstract boolean isAlive();
	
	public boolean isColliding(GameObject other) {
		return this.getPos().dist(other.getPos()) < this.getRadius() + other.getRadius();
	}
	
	public abstract void resolveCollision(GameObject other);
	
	public boolean isOutBoundsNorth() {
		if (pos.getY() + this.radius <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean isOutBoundsEast() {
		if (pos.getX() - this.radius >= Game.WIDTH - (Game.WIDTH / 50)) {
			return true;
		}
		return false;
	}
	
	public boolean isOutBoundsSouth() {
		if (pos.getY() - this.radius >= Game.HEIGHT) {
			return true;
		}
		return false;
	}
	
	public boolean isOutBoundsWest() {
		if (pos.getX() + this.radius <= Game.UI_WIDTH) {
			return true;
		}
		return false;
	}
	
	public void resolveBoundsNorth() {
		pos.setY(Game.HEIGHT + radius / 2);
	}
	
	public void resolveBoundsEast() {
		pos.setX( 0 - radius / 2 + Game.UI_WIDTH);
	}
	
	public void resolveBoundsSouth() {
		pos.setY(0 - radius / 2);
	}
	
	public void resolveBoundsWest() {
		pos.setX(Game.WIDTH + radius / 2 - (Game.WIDTH / 50));
	}
	
	private void checkBounds() {
		if (isOutBoundsNorth()) {
			resolveBoundsNorth();
		}
		if (isOutBoundsEast()) {
			resolveBoundsEast();
		}
		if (isOutBoundsSouth()) {
			resolveBoundsSouth();
		}
		if (isOutBoundsWest()) {
			resolveBoundsWest();
		}
	}
	
	protected static void changePositions(GameObject c1, GameObject c2) {
        double distance = c1.getPos().dist(c2.getPos());
        double overlap = distance - c1.getRadius() - c2.getRadius();
        Vector2 c1_to_c2_dir = c2.getPos().sub(c1.getPos()).unit();
        Vector2 c2_to_c1_dir = c1.getPos().sub(c2.getPos()).unit();
  
        c1.setPos(c1.getPos().add(c1_to_c2_dir.mul(overlap * .5)));
        c2.setPos(c2.getPos().add(c2_to_c1_dir.mul(overlap * .5)));
    }

    protected static void changeVelocities(GameObject c1, GameObject c2, double restitution) {
        double mass1 = c1.getMass();
        double mass2 = c2.getMass();

        double distance = c1.getPos().dist(c2.getPos());
        double nx = (c2.getPos().getX() - c1.getPos().getX()) / distance;
        double ny = (c2.getPos().getY() - c1.getPos().getY()) / distance;
        double tx = -ny;
        double ty = nx;
        double kx = c1.getVel().getX() - c2.getVel().getX();
        double ky = c1.getVel().getY() - c2.getVel().getY();
        double p = 2.0 * (nx * kx + ny * ky) / (mass1 + mass2);
        Vector2 c1Change = new Vector2(p * mass2 * nx, p * mass2 * ny);
        Vector2 c2Change = new Vector2(p * mass1 * nx, p * mass1 * ny);
      
        c1.setVel(c1.getVel().add(c1Change.neg()));
        c1.setVel(c1.getVel().mul(restitution));
        c2.setVel(c2.getVel().add(c2Change));
        c2.setVel(c2.getVel().mul(restitution));
    }

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel = vel;
	}
	public double getMass() {
		return radius;
	}
	public Sprite getSprite() {
		return sprite;
	}
}
