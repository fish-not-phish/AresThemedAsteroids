package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ChooseShip {

//	add png of current ship image below current ship rectangle (if possible)
	public Rectangle currentShip = new Rectangle(Game.WIDTH / 3 + 130, 515, 350, 50);
	public Rectangle nextShip = new Rectangle(Game.WIDTH / 3 + 650, 515, 50, 50);
	public Rectangle previousShip = new Rectangle(Game.WIDTH / 3 - 100, 515, 50, 50);
	public Rectangle backButton = new Rectangle(Game.WIDTH / 3 - 100, 800, 800, 50);
	
	public void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		g.fillRect(Game.WIDTH / 3 - 100, 515, 800, 450);
		
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
		
		g.drawImage(Game.getShipImage(), Game.WIDTH / 3 + 205, 575, 200, 100, null, null);
		
		g.drawString("Back", backButton.x + 350, backButton.y + 40);
		g2d.draw(backButton);
	}
}
