package com.aresThemeAsteroids;
import java.awt.Color;

import tools.Vector2;

public class ParticleEffect extends GameObject {
	private long startTime;
	private long duration;
	
	public ParticleEffect(Vector2 pos, double radius, Frames frames, long frameTime, long duration) {
		super(pos, Vector2.zero(), radius, Color.red, frames, frameTime);
		this.duration = duration;
		startTime = System.currentTimeMillis();
	}
	
	public boolean isAlive() {
		return startTime + duration >= System.currentTimeMillis();
	}
	
	public void resolveCollision(GameObject other) {}
}
