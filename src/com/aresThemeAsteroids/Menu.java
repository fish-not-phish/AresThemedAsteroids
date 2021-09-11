package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 3 + 150, 150, 200, 50);
	public Rectangle settingsButton = new Rectangle(Game.WIDTH / 3 + 150, 250, 200, 50);
	public Rectangle chooseShip = new Rectangle(Game.WIDTH / 3 + 125, 350, 250, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 3 + 150, 450, 200, 50);
	
	
	public void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Asteroids - Ares Version", Game.WIDTH / 3, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 35);
		g.setFont(fnt1);
		
		g.drawString("Play", playButton.x + 60, playButton.y + 40);
		g2d.draw(playButton);
		
		g.drawString("Settings", settingsButton.x + 35, settingsButton.y + 40);
		g2d.draw(settingsButton);
		
		g.drawString("Choose Ship", chooseShip.x + 25, chooseShip.y + 40);
		g2d.draw(chooseShip);
		
		g.drawString("Quit", quitButton.x + 60, quitButton.y + 40);
		g2d.draw(quitButton);
		
		Font fnt2 = new Font("arial", Font.BOLD, 25);
		g.setFont(fnt2);
		g.drawString("All media credit goes to Nathan Lamont", quitButton.x - 100, quitButton.y + 200);
		g.drawString("This game is for personal use only. Not to be redistributed.", quitButton.x - 195, quitButton.y + 300);
	}
}
