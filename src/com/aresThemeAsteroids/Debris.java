package com.aresThemeAsteroids;
import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import tools.Vector2;

public class Debris extends GameObject {
	
	private long duration;
	private long startTime;
	private boolean isAlive;
	
	public Debris (Vector2 pos, Vector2 vel, double radius, long duration) {
		super(pos, vel, radius, Color.gray, Game.framesDebris, Game.FRAME_TIME);
		this.duration = duration;
		startTime = System.currentTimeMillis();
		isAlive = true;
	}
	
	public void resolveCollision(GameObject other) {
	}
	
	public boolean isAlive() {
		return isAlive && startTime + duration >= System.currentTimeMillis();
	}
}
