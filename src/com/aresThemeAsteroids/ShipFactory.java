package com.aresThemeAsteroids;
import java.util.Set;

public class ShipFactory {
	public static Ship createEleCruiser(Set<Integer> keys, Set<Integer> processed, Frames frame, Frames overlay) {
		return new Ship(keys, processed, Game.ELE_SHIP_RADIUS, Game.framesShip, Game.framesShipOverlay, Game.SHIP_HEALTH, "Ele Cruiser");
	}
	public static Ship createEscort(Set<Integer> keys, Set<Integer> processed, Frames frame, Frames overlay) {
		return new Ship(keys, processed, Game.ESCORT_SHIP_RADIUS, Game.framesEscortShip, Game.framesEscortShipOverlay, Game.SHIP_HEALTH, "Escort");
	}
	public static Ship createGaiHvd(Set<Integer> keys, Set<Integer> processed, Frames frame, Frames overlay) {
		return new Ship(keys, processed, Game.GAI_HVD_SHIP_RADIUS, Game.framesGaiHvdShip, Game.framesGaiHvdShipOverlay, Game.SHIP_HEALTH, "Gai HVD");
	}
	public static Ship createIshHvd(Set<Integer> keys, Set<Integer> processed, Frames frame, Frames overlay) {
		return new Ship(keys, processed, Game.ISH_HVD_SHIP_RADIUS, Game.framesIshHvdShip, Game.framesIshHvdShipOverlay, Game.SHIP_HEALTH, "Ish HVD");
	}
}