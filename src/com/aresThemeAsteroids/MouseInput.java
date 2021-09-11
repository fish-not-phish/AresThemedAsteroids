package com.aresThemeAsteroids;


import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class MouseInput implements MouseListener {
	
	private int i;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();
		
		if (Game.State == Game.STATE.MENU) {
//			play
			if (mx >= Game.WIDTH / 3 + 150 && mx <= Game.WIDTH / 3 + 350) {
				if (my >= 150 && my <= 200) {
					Game.State = Game.STATE.GAME;
				}
			}
//			settings
			if (mx >= Game.WIDTH / 3 + 150 && mx <= Game.WIDTH / 3 + 350) {
				if (my >= 250 && my <= 300) {
					Game.State = Game.STATE.SETTINGS;
				}
			}
//			choose ship
			if (mx >= Game.WIDTH / 3 + 125 && mx <= Game.WIDTH / 3 + 375) {
				if (my >= 350 && my <= 400) {
					Game.State = Game.STATE.CHOOSE_SHIP;
				}
			}
//			quit
			if (mx >= Game.WIDTH / 3 + 150 && mx <= Game.WIDTH / 3 + 350) {
				if (my >= 450 && my <= 500) {
					System.exit(1);
					
				}
			}
		}
		
		if (Game.State == Game.STATE.SETTINGS) {
//			player add hp
			if (mx >= Game.WIDTH / 3 + 500 && mx <= Game.WIDTH / 3 + 550) {
				if (my >= 150 && my <= 200) {
					Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() + 1);
				}
			}
//			player minus hp
			if (mx >= Game.WIDTH / 3 - 75 && mx <= Game.WIDTH / 3 - 25) {
				if (my >= 150 && my <= 200) {
					Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() - 1);
				}
			}
//			big ast add hp
			if (mx >= Game.WIDTH / 3 + 500 && mx <= Game.WIDTH / 3 + 550) {
				if (my >= 250 && my <= 300) {
					Game.BIG_AST_HEALTH += 1;
				}
			}
//			big ast minus hp
			if (mx >= Game.WIDTH / 3 - 75 && mx <= Game.WIDTH / 3 - 25) {
				if (my >= 250 && my <= 300) {
					Game.BIG_AST_HEALTH -= 1;
				}
			}
//			med ast add hp
			if (mx >= Game.WIDTH / 3 + 500 && mx <= Game.WIDTH / 3 + 550) {
				if (my >= 350 && my <= 400) {
					Game.MED_AST_HEALTH += 1;
				}
			}
//			med ast minus hp
			if (mx >= Game.WIDTH / 3 - 75 && mx <= Game.WIDTH / 3 - 25) {
				if (my >= 350 && my <= 400) {
					Game.MED_AST_HEALTH -= 1;
				}
			}
//			small ast add hp
			if (mx >= Game.WIDTH / 3 + 500 && mx <= Game.WIDTH / 3 + 550) {
				if (my >= 450 && my <= 500) {
					Game.SMALL_AST_HEALTH += 1;
				}
			}
//			small ast minus hp
			if (mx >= Game.WIDTH / 3 - 75 && mx <= Game.WIDTH / 3 - 25) {
				if (my >= 450 && my <= 500) {
					Game.SMALL_AST_HEALTH -= 1;
				}
			}
//			back button
			if (mx >= Game.WIDTH / 3 + 150 && mx <= Game.WIDTH / 3 + 350) {
				if (my >= 600 && my <= 650) {
					Game.State = Game.STATE.MENU;
				}
			}
		}
		if (Game.State == Game.STATE.CHOOSE_SHIP) {
//			next ship
			if (mx >= Game.WIDTH / 3 + 500 && mx <= Game.WIDTH / 3 + 550) {
				if (my >= 150 && my <= 200) {
					i++;
					if (i <= 3) {
						if (i == 0) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
							Game.ships.add(player);
						} else if (i == 1) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
							Game.ships.add(player); 
							
						} else if (i == 2){
							Game.ships.remove(0);
							Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
							Game.ships.add(player); 
							
						} else if (i == 3) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
							Game.ships.add(player); 
						}
					}
					else if (i >= 3) {
						i = 3;
					}
				}
			}
//			previous ship
			if (mx >= Game.WIDTH / 3 - 75 && mx <= Game.WIDTH / 3 - 25) {
				if (my >= 150 && my <= 200) {
					i--;
					if (i < 0) {
						i = 0;
					} else if (i >= 0) {
						if (i == 0) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
							Game.ships.add(player);
						} else if (i == 1) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
							Game.ships.add(player);
							
						} else if (i == 2){
							Game.ships.remove(0);
							Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
							Game.ships.add(player); 
							
						} else if (i == 3) {
							Game.ships.remove(0);
							Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
							Game.ships.add(player); 			
						}
					}
				}
			}
			
//			back button
			if (mx >= Game.WIDTH / 3 + 150 && mx <= Game.WIDTH / 3 + 350) {
				if (my >= 600 && my <= 650) {
					Game.State = Game.STATE.MENU;
				}
			}
		}
		if (Game.ships.isEmpty()) {
			if (mx >= Game.WIDTH / 3 + 100 && mx <= Game.WIDTH / 3 + 600) {
				if (my >= 540 && my <= 575) {

					Game.asteroids.clear();
					for (int i = 0; i < 12; i++) {
						Game.addAsteroid(0, 0, Game.WIDTH, Game.HEIGHT, Game.BIG_AST_RADIUS);
					}
					Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
					Game.ships.add(player);
					Game.State = Game.STATE.MENU;
				}
			}
		}
	}
	
	public Rectangle backButton = new Rectangle(Game.WIDTH / 3 + 150, 600, 200, 50);
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
