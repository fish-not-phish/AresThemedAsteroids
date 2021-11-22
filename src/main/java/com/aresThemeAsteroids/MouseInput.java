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
		
		if (Game.WIDTH >= 1920) {
			if (Game.State == Game.STATE.MENU) {
//				play
				if (mx >= 533 && mx <= 1380) {
					if (my >= 551 && my <= 601) {
						Game.State = Game.STATE.PREGAME;
					}
				}
//				settings
				if (mx >= 533 && mx <= 1380) {
					if (my >= 611 && my <= 661) {
						Game.State = Game.STATE.SETTINGS;
					}
				}
//				choose ship
				if (mx >= 533 && mx <= 1380) {
					if (my >= 671 && my <= 721) {
						Game.State = Game.STATE.CHOOSE_SHIP;
					}
				}
//				quit
				if (mx >= 533 && mx <= 1380) {
					if (my >= 731 && my <= 781) {
						System.exit(1);
					}
				}
			}
			
			if (Game.State == Game.STATE.SETTINGS) {
//				player add hp
				if (mx >= 1330 && mx <= 1380) {
					if (my >= 551 && my <= 601) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() + 1);
					}
				}
//				player minus hp
				if (mx >= 533 && mx <= 583) {
					if (my >= 551 && my <= 601) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() - 1);
					}
				}
//				back button
				if (mx >= 533 && mx <= 1380) {
					if (my >= 750 && my <= 800) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.State == Game.STATE.CHOOSE_SHIP) {
//				next ship
				if (mx >= 1330 && mx <= 1380) {
					if (my >= 551 && my <= 601) {
						i++;
						if (i <= 3) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player); 
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 
							}
						}
						else if (i >= 3) {
							i = 3;
						}
					}
				}
//				previous ship
				if (mx >= 533 && mx <= 583) {
					if (my >= 551 && my <= 601) {
						i--;
						if (i < 0) {
							i = 0;
						} else if (i >= 0) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player);
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 			
							}
						}
					}
				}
				
//				back button
				if (mx >= 533 && mx <= 1380) {
					if (my >= 800 && my <= 850) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.ships.isEmpty()) {
				if (mx >= 705 && mx <= 1215) {
					if (my >= 474 && my <= 513) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
		}
		else if (Game.WIDTH == 1600) {
			if (Game.State == Game.STATE.MENU) {
//				play
				if (mx >= 443 && mx <= 1155) {
					if (my >= 455 && my <= 505) {
						Game.State = Game.STATE.PREGAME;
					}
				}
//				settings
				if (mx >= 443 && mx <= 1155) {
					if (my >= 515 && my <= 565) {
						Game.State = Game.STATE.SETTINGS;
					}
				}
//				choose ship
				if (mx >= 443 && mx <= 1155) {
					if (my >= 575 && my <= 625) {
						Game.State = Game.STATE.CHOOSE_SHIP;
					}
				}
//				quit
				if (mx >= 443 && mx <= 1155) {
					if (my >= 635 && my <= 685) {
						System.exit(1);
					}
				}
			}
			
			if (Game.State == Game.STATE.SETTINGS) {
//				player add hp
				if (mx >= 1103 && mx <= 1153) {
					if (my >= 459 && my <= 509) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() + 1);
					}
				}
//				player minus hp
				if (mx >= 443 && mx <= 493) {
					if (my >= 459 && my <= 509) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() - 1);
					}
				}
//				back button
				if (mx >= 443 && mx <= 1153) {
					if (my >= 750 && my <= 800) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.State == Game.STATE.CHOOSE_SHIP) {
//				next ship
				if (mx >= 1103 && mx <= 1153) {
					if (my >= 459 && my <= 509) {
						i++;
						if (i <= 3) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player); 
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 
							}
						}
						else if (i >= 3) {
							i = 3;
						}
					}
				}
//				previous ship
				if (mx >= 443 && mx <= 493) {
					if (my >= 459 && my <= 509) {
						i--;
						if (i < 0) {
							i = 0;
						} else if (i >= 0) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player);
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 			
							}
						}
					}
				}
				
//				back button
				if (mx >= 443 && mx <= 1153) {
					if (my >= 750 && my <= 800) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.ships.isEmpty()) {
				if (mx >= 588 && mx <= 1013) {
					if (my >= 396 && my <= 427) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
		}
		else if (Game.WIDTH == 1366) {
			if (Game.State == Game.STATE.MENU) {
//				play
				if (mx >= 378 && mx <= 986) {
					if (my >= 392 && my <= 442) {
						Game.State = Game.STATE.PREGAME;
					}
				}
//				settings
				if (mx >= 378 && mx <= 986) {
					if (my >= 452 && my <= 502) {
						Game.State = Game.STATE.SETTINGS;
					}
				}
//				choose ship
				if (mx >= 378 && mx <= 986) {
					if (my >= 512 && my <= 562) {
						Game.State = Game.STATE.CHOOSE_SHIP;
					}
				}
//				quit
				if (mx >= 378 && mx <= 986) {
					if (my >= 572 && my <= 622) {
						System.exit(1);
					}
				}
			}
			
			if (Game.State == Game.STATE.SETTINGS) {
//				player add hp
				if (mx >= 935 && mx <= 985) {
					if (my >= 390 && my <= 440) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() + 1);
					}
				}
//				player minus hp
				if (mx >= 380 && mx <= 430) {
					if (my >= 390 && my <= 440) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() - 1);
					}
				}
//				back button
				if (mx >= 380 && mx <= 985) {
					if (my >= 550 && my <= 600) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.State == Game.STATE.CHOOSE_SHIP) {
//				next ship
				if (mx >= 934 && mx <= 984) {
					if (my >= 392 && my <= 442) {
						i++;
						if (i <= 3) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player); 
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 
							}
						}
						else if (i >= 3) {
							i = 3;
						}
					}
				}
//				previous ship
				if (mx >= 380 && mx <= 430) {
					if (my >= 392 && my <= 442) {
						i--;
						if (i < 0) {
							i = 0;
						} else if (i >= 0) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player);
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 			
							}
						}
					}
				}
				
//				back button
				if (mx >= 380 && mx <= 984) {
					if (my >= 550 && my <= 600) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.ships.isEmpty()) {
				if (mx >= 501 && mx <= 864) {
					if (my >= 337 && my <= 364) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
		}
		else {
			if (Game.State == Game.STATE.MENU) {
//				play
				if (mx >= 378 && mx <= 986) {
					if (my >= 392 && my <= 442) {
						Game.State = Game.STATE.GAME;
					}
				}
//				settings
				if (mx >= 378 && mx <= 986) {
					if (my >= 452 && my <= 502) {
						Game.State = Game.STATE.SETTINGS;
					}
				}
//				choose ship
				if (mx >= 378 && mx <= 986) {
					if (my >= 512 && my <= 562) {
						Game.State = Game.STATE.CHOOSE_SHIP;
					}
				}
//				quit
				if (mx >= 378 && mx <= 986) {
					if (my >= 572 && my <= 622) {
						System.exit(1);
					}
				}
			}
			
			if (Game.State == Game.STATE.SETTINGS) {
//				player add hp
				if (mx >= 935 && mx <= 985) {
					if (my >= 390 && my <= 440) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() + 1);
					}
				}
//				player minus hp
				if (mx >= 380 && mx <= 430) {
					if (my >= 390 && my <= 440) {
						Game.ships.get(0).setHealth(Game.ships.get(0).getHealth() - 1);
					}
				}
//				back button
				if (mx >= 380 && mx <= 985) {
					if (my >= 550 && my <= 600) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.State == Game.STATE.CHOOSE_SHIP) {
//				next ship
				if (mx >= 934 && mx <= 984) {
					if (my >= 392 && my <= 442) {
						i++;
						if (i <= 3) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player); 
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 
							}
						}
						else if (i >= 3) {
							i = 3;
						}
					}
				}
//				previous ship
				if (mx >= 380 && mx <= 430) {
					if (my >= 392 && my <= 442) {
						i--;
						if (i < 0) {
							i = 0;
						} else if (i >= 0) {
							if (i == 0) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEleCruiser(Game.input.getKeys(), Game.input.getProcessed(), Game.framesShip, Game.framesShipOverlay);
								Game.ships.add(player);
							} else if (i == 1) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createEscort(Game.input.getKeys(), Game.input.getProcessed(), Game.framesEscortShip, Game.framesEscortShipOverlay);
								Game.ships.add(player);
								
							} else if (i == 2){
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createGaiHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesGaiHvdShip, Game.framesGaiHvdShip);
								Game.ships.add(player); 
								
							} else if (i == 3) {
								if (!Game.ships.isEmpty()) {
									Game.ships.remove(0);
								}
								Ship player = ShipFactory.createIshHvd(Game.input.getKeys(), Game.input.getProcessed(), Game.framesIshHvdShip, Game.framesIshHvdShipOverlay);
								Game.ships.add(player); 			
							}
						}
					}
				}
				
//				back button
				if (mx >= 380 && mx <= 984) {
					if (my >= 550 && my <= 600) {
						Game.State = Game.STATE.MENU;
					}
				}
			}
			if (Game.ships.isEmpty()) {
				if (mx >= 501 && mx <= 864) {
					if (my >= 337 && my <= 364) {
						Game.State = Game.STATE.MENU;
					}
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
