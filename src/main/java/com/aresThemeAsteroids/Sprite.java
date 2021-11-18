package com.aresThemeAsteroids;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Sprite {
	private Frames frames;
	private long frameTime;
	private int startFrame;

	public Sprite(Frames frames, long frameTime, int startFrame) {
		this.frames = frames;
		this.frameTime = frameTime;
		this.startFrame = startFrame;
		if (startFrame < 0) {
			Random rand = new Random();
			this.startFrame = rand.nextInt(frames.getFrames().size());
		}
	}
	
	public BufferedImage getFrame() {
		long now = System.currentTimeMillis();
		int currentFrame = (int)((now / frameTime + startFrame) % frames.getFrames().size());
		return frames.getFrames().get(currentFrame);
	}
	
	public BufferedImage getFrameFromAngle(double angle) {
		angle = angle + Math.PI; // angle from Vector2.rot is neg 180 to 180
		angle = angle - (Math.PI / 2);
		double inc = (Math.PI * 2) / 24;
		double halfInc = inc / 2;
		int currentFrame = (int) (((angle) / inc));
//		hack
		if(currentFrame == 24) {
			currentFrame = 0;
		}
		return frames.getFrames().get(currentFrame);
	}
	
	public int getStartFrame() {
		return startFrame;
	}
}
