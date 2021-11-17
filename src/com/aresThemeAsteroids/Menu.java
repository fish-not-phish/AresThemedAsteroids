package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 3 - 100, 515, 800, 50);
	public Rectangle settingsButton = new Rectangle(Game.WIDTH / 3 - 100, 575, 800, 50);
	public Rectangle chooseShip = new Rectangle(Game.WIDTH / 3 - 100, 635, 800, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 3 - 100, 695, 800, 50);
	
	
	public void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		g.fillRect(Game.WIDTH / 3 - 100, 515, 800, 450);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.green);
//		g.drawString("Asteroids - Ares Version", Game.WIDTH / 3, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 35);
		g.setFont(fnt1);
		
		g.drawString("Play", playButton.x + 350, playButton.y + 40);
		g2d.draw(playButton);
		
		g.drawString("Settings", settingsButton.x + 320, settingsButton.y + 40);
		g2d.draw(settingsButton);
		
		g.drawString("Choose Ship", chooseShip.x + 285, chooseShip.y + 40);
		g2d.draw(chooseShip);
		
		g.drawString("Quit", quitButton.x + 350, quitButton.y + 40);
		g2d.draw(quitButton);
		
		Font fnt2 = new Font("arial", Font.BOLD, 25);
		g.setFont(fnt2);
		g.drawString("Credit Nathan Lamont - Images/Music/Sprites", quitButton.x + 125, quitButton.y + 200);
		g.drawString("This game is for personal use only. Not to be redistributed.", quitButton.x + 50, quitButton.y + 250);
	}
}
