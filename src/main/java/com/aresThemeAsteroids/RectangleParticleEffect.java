package com.aresThemeAsteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import tools.DrawTools;
import tools.Vector2;

public class RectangleParticleEffect extends ParticleEffect {
	
	private double width;
	private double height;

	public RectangleParticleEffect(Vector2 pos, double radius, Color color, double width, double height, long duration) {
		super(pos, radius, color, duration);
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void draw(Graphics g) {	
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		DrawTools.fillRect(g2, width, height, pos.getX(), pos.getY());
	}
}
