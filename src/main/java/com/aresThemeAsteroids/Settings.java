package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Settings {
	
	private Rectangle shipHealth;
	private Rectangle shipHealthAdd;
	private Rectangle shipHealthSub;
	private Rectangle backButton;

	public void draw (Graphics g) {
		if (Game.WIDTH >= 1920) {
			shipHealth = new Rectangle(Game.WIDTH / 3 + 136, 551, 350, 50);
			shipHealthAdd = new Rectangle(Game.WIDTH / 3 + 692, 551, 50, 50);
			shipHealthSub = new Rectangle(Game.WIDTH / 3 - 107, 551, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 107, 755, 850, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 107, 551, 850, 476);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Player Health: " + Game.ships.get(0).getHealth(), shipHealth.x + 40, shipHealth.y + 40);
			g2d.draw(shipHealth);
			g.drawString("+", shipHealthAdd.x + 15, shipHealthAdd.y + 40);
			g2d.draw(shipHealthAdd);
			g.drawString("-", shipHealthSub.x + 18, shipHealthSub.y + 35);
			g2d.draw(shipHealthSub);
		
			g.drawString("Back", backButton.x + 375, backButton.y + 40);
			g2d.draw(backButton);
		}
		else if (Game.WIDTH == 1600) {
			shipHealth = new Rectangle(Game.WIDTH / 3 + 100, 459, 350, 50);
			shipHealthAdd = new Rectangle(Game.WIDTH / 3 + 571, 459, 50, 50);
			shipHealthSub = new Rectangle(Game.WIDTH / 3 - 89, 459, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 89, 755, 709, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 89, 459, 709, 397);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Player Health: " + Game.ships.get(0).getHealth(), shipHealth.x + 40, shipHealth.y + 40);
			g2d.draw(shipHealth);
			g.drawString("+", shipHealthAdd.x + 15, shipHealthAdd.y + 40);
			g2d.draw(shipHealthAdd);
			g.drawString("-", shipHealthSub.x + 18, shipHealthSub.y + 35);
			g2d.draw(shipHealthSub);
		
			g.drawString("Back", backButton.x + 320, backButton.y + 40);
			g2d.draw(backButton);
		}
		else if (Game.WIDTH == 1366) {
			shipHealth = new Rectangle(Game.WIDTH / 3 + 55, 392, 350, 50);
			shipHealthAdd = new Rectangle(Game.WIDTH / 3 + 479, 392, 50, 50);
			shipHealthSub = new Rectangle(Game.WIDTH / 3 - 76, 392, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 76, 550, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Player Health: " + Game.ships.get(0).getHealth(), shipHealth.x + 40, shipHealth.y + 40);
			g2d.draw(shipHealth);
			g.drawString("+", shipHealthAdd.x + 15, shipHealthAdd.y + 40);
			g2d.draw(shipHealthAdd);
			g.drawString("-", shipHealthSub.x + 18, shipHealthSub.y + 35);
			g2d.draw(shipHealthSub);
		
			g.drawString("Back", backButton.x + 270, backButton.y + 40);
			g2d.draw(backButton);
		}
		else {
			shipHealth = new Rectangle(Game.WIDTH / 3 + 55, 392, 350, 50);
			shipHealthAdd = new Rectangle(Game.WIDTH / 3 + 479, 392, 50, 50);
			shipHealthSub = new Rectangle(Game.WIDTH / 3 - 76, 392, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 76, 550, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString("Player Health: " + Game.ships.get(0).getHealth(), shipHealth.x + 40, shipHealth.y + 40);
			g2d.draw(shipHealth);
			g.drawString("+", shipHealthAdd.x + 15, shipHealthAdd.y + 40);
			g2d.draw(shipHealthAdd);
			g.drawString("-", shipHealthSub.x + 18, shipHealthSub.y + 35);
			g2d.draw(shipHealthSub);
		
			g.drawString("Back", backButton.x + 270, backButton.y + 40);
			g2d.draw(backButton);
		}
	}
}
