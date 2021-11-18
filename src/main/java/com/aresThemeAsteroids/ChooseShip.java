package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ChooseShip {

//	add png of current ship image below current ship rectangle (if possible)
	public Rectangle currentShip;
	public Rectangle nextShip;
	public Rectangle previousShip;
	public Rectangle backButton;
	
	public void draw (Graphics g) {
		if (Game.WIDTH >= 1920) {
			currentShip = new Rectangle(Game.WIDTH / 3 + 155, 551, 350, 50);
			nextShip = new Rectangle(Game.WIDTH / 3 + 693, 551, 50, 50);
			previousShip = new Rectangle(Game.WIDTH / 3 - 107, 551, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 107, 800, 850, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 107, 551, 850, 476);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString(Game.SHIP_NAME, currentShip.x + 80, currentShip.y + 40);
			g2d.draw(currentShip);
			g.drawString(">", nextShip.x + 15, nextShip.y + 40);
			g2d.draw(nextShip);
			g.drawString("<", previousShip.x + 15, previousShip.y + 35);
			g2d.draw(previousShip);
			
			g.drawImage(Game.getShipImage(), Game.WIDTH / 3 + 230, 611, 200, 100, null, null);
			
			g.drawString("Back", backButton.x + 390, backButton.y + 40);
			g2d.draw(backButton);
		}
		else if (Game.WIDTH == 1600) {
			currentShip = new Rectangle(Game.WIDTH / 3 + 100, 459, 350, 50);
			nextShip = new Rectangle(Game.WIDTH / 3 + 571, 459, 50, 50);
			previousShip = new Rectangle(Game.WIDTH / 3 - 89, 459, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 89, 755, 709, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 89, 459, 709, 397);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString(Game.SHIP_NAME, currentShip.x + 80, currentShip.y + 40);
			g2d.draw(currentShip);
			g.drawString(">", nextShip.x + 15, nextShip.y + 40);
			g2d.draw(nextShip);
			g.drawString("<", previousShip.x + 15, previousShip.y + 35);
			g2d.draw(previousShip);
			
			g.drawImage(Game.getShipImage(), Game.WIDTH / 3 + 185, 519, 200, 100, null, null);
			
			g.drawString("Back", backButton.x + 320, backButton.y + 40);
			g2d.draw(backButton);
		}
		else if (Game.WIDTH == 1366) {
			currentShip = new Rectangle(Game.WIDTH / 3 + 55, 392, 350, 50);
			nextShip = new Rectangle(Game.WIDTH / 3 + 479, 392, 50, 50);
			previousShip = new Rectangle(Game.WIDTH / 3 - 76, 392, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 76, 550, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString(Game.SHIP_NAME, currentShip.x + 80, currentShip.y + 40);
			g2d.draw(currentShip);
			g.drawString(">", nextShip.x + 15, nextShip.y + 40);
			g2d.draw(nextShip);
			g.drawString("<", previousShip.x + 15, previousShip.y + 35);
			g2d.draw(previousShip);
			
			g.drawImage(Game.getShipImage(), Game.WIDTH / 3 + 130, 452, 200, 100, null, null);
			
			g.drawString("Back", backButton.x + 265, backButton.y + 40);
			g2d.draw(backButton);
		} 
		else {
			currentShip = new Rectangle(Game.WIDTH / 3 + 55, 392, 350, 50);
			nextShip = new Rectangle(Game.WIDTH / 3 + 479, 392, 50, 50);
			previousShip = new Rectangle(Game.WIDTH / 3 - 76, 392, 50, 50);
			backButton = new Rectangle(Game.WIDTH / 3 - 76, 550, 605, 50);
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 3 - 76, 392, 605, 338);
			
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.green);
			
			Font fnt1 = new Font("arial", Font.BOLD, 35);
			g.setFont(fnt1);
			
			g.drawString(Game.SHIP_NAME, currentShip.x + 40, currentShip.y + 40);
			g2d.draw(currentShip);
			g.drawString(">", nextShip.x + 15, nextShip.y + 40);
			g2d.draw(nextShip);
			g.drawString("<", previousShip.x + 15, previousShip.y + 35);
			g2d.draw(previousShip);
			
			g.drawImage(Game.getShipImage(), Game.WIDTH / 3 + 130, 452, 200, 100, null, null);
			
			g.drawString("Back", backButton.x + 265, backButton.y + 40);
			g2d.draw(backButton);
		}
	}
}
