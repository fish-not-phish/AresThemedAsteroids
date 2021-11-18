package com.aresThemeAsteroids;
import java.awt.Color;

import tools.Vector2;

public class AsteroidFactory {
	public static Asteroid createBigAsteroid(Vector2 pos, Vector2 vel, Frames frame, Frames overlay) {
		return new Asteroid(pos, vel, Game.BIG_AST_RADIUS, Game.framesBigAsteroid, Game.framesBigAsteroidOverlay, Game.BIG_AST_HEALTH);
	}
	public static Asteroid createMediumAsteroid(Vector2 pos, Vector2 vel, Frames frame, Frames overlay) {
		return new Asteroid(pos, vel, Game.MED_AST_RADIUS, Game.framesMediumAsteroid, Game.framesMediumAsteroidAsteroidOverlay, Game.MED_AST_HEALTH);
	}
	public static Asteroid createSmallAsteroid(Vector2 pos, Vector2 vel, Frames frame, Frames overlay) {
		return new Asteroid(pos, vel, Game.SMALL_AST_RADIUS, Game.framesSmallAsteroid, Game.framesSmallAsteroidAsteroidOverlay, Game.SMALL_AST_HEALTH);
	}
}
