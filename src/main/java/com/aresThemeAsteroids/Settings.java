package com.aresThemeAsteroids;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Settings {
	
	public Rectangle shipHealth = new Rectangle(Game.WIDTH / 3 + 125, 515, 350, 50);
	public Rectangle shipHealthAdd = new Rectangle(Game.WIDTH / 3 + 650, 515, 50, 50);
	public Rectangle shipHealthSub = new Rectangle(Game.WIDTH / 3 - 100, 515, 50, 50);
	
//	public Rectangle bigAstHealth = new Rectangle(Game.WIDTH / 3 + 80, 575, 450, 50);
//	public Rectangle bigAstHealthAdd = new Rectangle(Game.WIDTH / 3 + 650, 575, 50, 50);
//	public Rectangle bigAstHealthSub = new Rectangle(Game.WIDTH / 3 - 100, 575, 50, 50);
//	
//	public Rectangle medAstHealth = new Rectangle(Game.WIDTH / 3 + 80, 635, 450, 50);
//	public Rectangle medAstHealthAdd = new Rectangle(Game.WIDTH / 3 + 650, 635, 50, 50);
//	public Rectangle medAstHealthSub = new Rectangle(Game.WIDTH / 3 - 100, 635, 50, 50);
//	
//	public Rectangle smallAstHealth = new Rectangle(Game.WIDTH / 3 + 80, 695, 450, 50);
//	public Rectangle smallAstHealthAdd = new Rectangle(Game.WIDTH / 3 + 650, 695, 50, 50);
//	public Rectangle smallAstHealthSub = new Rectangle(Game.WIDTH / 3 - 100, 695, 50, 50);
	
	public Rectangle backButton = new Rectangle(Game.WIDTH / 3 - 100, 755, 800, 50);

	public void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		g.fillRect(Game.WIDTH / 3 - 100, 515, 800, 450);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.green);
//		g.drawString("Settings", Game.WIDTH / 3 + 145, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 35);
		g.setFont(fnt1);
		
		g.drawString("Player Health: " + Game.ships.get(0).getHealth(), shipHealth.x + 40, shipHealth.y + 40);
		g2d.draw(shipHealth);
		g.drawString("+", shipHealthAdd.x + 15, shipHealthAdd.y + 40);
		g2d.draw(shipHealthAdd);
		g.drawString("-", shipHealthSub.x + 18, shipHealthSub.y + 35);
		g2d.draw(shipHealthSub);
		
//		g.drawString("Big Asteroid Health: " + Integer.toString(Game.BIG_AST_HEALTH), bigAstHealth.x + 35, bigAstHealth.y + 40);
//		g2d.draw(bigAstHealth);
//		g.drawString("+", bigAstHealthAdd.x + 15, bigAstHealthAdd.y + 40);
//		g2d.draw(bigAstHealthAdd);
//		g.drawString("-", bigAstHealthSub.x + 18, bigAstHealthSub.y + 35);
//		g2d.draw(bigAstHealthSub);
//		
//		g.drawString("Med Asteroid Health: " + Integer.toString(Game.MED_AST_HEALTH), medAstHealth.x + 35, medAstHealth.y + 40);
//		g2d.draw(medAstHealth);
//		g.drawString("+", medAstHealthAdd.x + 15, medAstHealthAdd.y + 40);
//		g2d.draw(medAstHealthAdd);
//		g.drawString("-", medAstHealthSub.x + 18, medAstHealthSub.y + 35);
//		g2d.draw(medAstHealthSub);
//		
//		g.drawString("Small Asteroid Health: " + Integer.toString(Game.SMALL_AST_HEALTH), smallAstHealth.x + 35, smallAstHealth.y + 40);
//		g2d.draw(smallAstHealth);
//		g.drawString("+", smallAstHealthAdd.x + 15, smallAstHealthAdd.y + 40);
//		g2d.draw(smallAstHealthAdd);
//		g.drawString("-", smallAstHealthSub.x + 18, smallAstHealthSub.y + 35);
//		g2d.draw(smallAstHealthSub);
//		
		g.drawString("Back", backButton.x + 350, backButton.y + 40);
		g2d.draw(backButton);
	}
}
