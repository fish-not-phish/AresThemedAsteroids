package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton;
	public Rectangle settingsButton;
	public Rectangle chooseShip;
	public Rectangle quitButton;
	
	
	public void draw (Graphics g) {
		if (Game.WIDTH >= 1920) {
			playButton = new Rectangle(Game.WIDTH / 3 - 107, 551, 850, 50);
			settingsButton = new Rectangle(Game.WIDTH / 3 - 107, 611, 850, 50);
			chooseShip = new Rectangle(Game.WIDTH / 3 - 107, 671, 850, 50);
			quitButton = new Rectangle(Game.WIDTH / 3 - 107, 731, 850, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 107, 551, 850, 476);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Play", playButton.x + 385, playButton.y + 40);
			g2d.draw(playButton);
			
			g.drawString("Settings", settingsButton.x + 361, settingsButton.y + 40);
			g2d.draw(settingsButton);
			
			g.drawString("Choose Ship", chooseShip.x + 326, chooseShip.y + 40);
			g2d.draw(chooseShip);
			
			g.drawString("Quit", quitButton.x + 391, quitButton.y + 40);
			g2d.draw(quitButton);
			
			Font fnt2 = new Font("arial", Font.BOLD, 25);
			g.setFont(fnt2);
			g.drawString("Credit Nathan Lamont - Images/Music/Sprites", quitButton.x + 136, quitButton.y + 200);
			g.drawString("This game is for personal use only. Not to be redistributed.", quitButton.x + 71, quitButton.y + 250);
		}
		else if (Game.WIDTH == 1600) {
			playButton = new Rectangle(Game.WIDTH / 3 - 89, 455, 709, 50);
			settingsButton = new Rectangle(Game.WIDTH / 3 - 89, 515, 709, 50);
			chooseShip = new Rectangle(Game.WIDTH / 3 - 89, 575, 709, 50);
			quitButton = new Rectangle(Game.WIDTH / 3 - 89, 635, 709, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 89, 459, 709, 397);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Play", playButton.x + 330, playButton.y + 40);
			g2d.draw(playButton);
			
			g.drawString("Settings", settingsButton.x + 300, settingsButton.y + 40);
			g2d.draw(settingsButton);
			
			g.drawString("Choose Ship", chooseShip.x + 265, chooseShip.y + 40);
			g2d.draw(chooseShip);
			
			g.drawString("Quit", quitButton.x + 330, quitButton.y + 40);
			g2d.draw(quitButton);
			
			Font fnt2 = new Font("arial", Font.BOLD, 25);
			g.setFont(fnt2);
			g.drawString("Credit Nathan Lamont - Images/Music/Sprites", quitButton.x + 95, quitButton.y + 150);
			g.drawString("This game is for personal use only. Not to be redistributed.", quitButton.x + 5, quitButton.y + 200);
		}
		else if (Game.WIDTH == 1366) {
			playButton = new Rectangle(Game.WIDTH / 3 - 76, 392, 605, 50);
			settingsButton = new Rectangle(Game.WIDTH / 3 - 76, 452, 605, 50);
			chooseShip = new Rectangle(Game.WIDTH / 3 - 76, 512, 605, 50);
			quitButton = new Rectangle(Game.WIDTH / 3 - 76, 572, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Play", playButton.x + 270, playButton.y + 40);
			g2d.draw(playButton);
			
			g.drawString("Settings", settingsButton.x + 240, settingsButton.y + 40);
			g2d.draw(settingsButton);
			
			g.drawString("Choose Ship", chooseShip.x + 205, chooseShip.y + 40);
			g2d.draw(chooseShip);
			
			g.drawString("Quit", quitButton.x + 270, quitButton.y + 40);
			g2d.draw(quitButton);
			
			Font fnt2 = new Font("arial", Font.BOLD, 25);
			g.setFont(fnt2);
			g.drawString("Credit Nathan Lamont - Images/Music/Sprites", quitButton.x + 40, quitButton.y + 75);
			g.drawString("This game is for personal use only.", quitButton.x + 100, quitButton.y + 115);
			g.drawString("Not to be redistributed.", quitButton.x + 175, quitButton.y + 155);
		}
		else {
			playButton = new Rectangle(Game.WIDTH / 3 - 76, 392, 605, 50);
			settingsButton = new Rectangle(Game.WIDTH / 3 - 76, 452, 605, 50);
			chooseShip = new Rectangle(Game.WIDTH / 3 - 76, 512, 605, 50);
			quitButton = new Rectangle(Game.WIDTH / 3 - 76, 572, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Play", playButton.x + 270, playButton.y + 40);
			g2d.draw(playButton);
			
			g.drawString("Settings", settingsButton.x + 240, settingsButton.y + 40);
			g2d.draw(settingsButton);
			
			g.drawString("Choose Ship", chooseShip.x + 205, chooseShip.y + 40);
			g2d.draw(chooseShip);
			
			g.drawString("Quit", quitButton.x + 270, quitButton.y + 40);
			g2d.draw(quitButton);
			
			Font fnt2 = new Font("arial", Font.BOLD, 25);
			g.setFont(fnt2);
			g.drawString("Credit Nathan Lamont - Images/Music/Sprites", quitButton.x + 40, quitButton.y + 75);
			g.drawString("This game is for personal use only.", quitButton.x + 100, quitButton.y + 115);
			g.drawString("Not to be redistributed.", quitButton.x + 175, quitButton.y + 155);
		}
	}
}
