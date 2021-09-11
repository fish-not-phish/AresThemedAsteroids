package com.aresThemeAsteroids;
import java.awt.Color;

import tools.Vector2;

public class ProjectileFactory {
	public static Projectile createBullet(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.BULLET_RADIUS, duration, 1, false, Game.framesBullet, Game.soundBulletFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createMissle(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.MISSILE_RADIUS, duration, 3, true, Game.framesMissile, Game.soundMissileFire, Game.soundMissileHit, Game.framesMissileExplosion, owner);
	}
	public static Projectile createNeutron(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.NEUTRON_RADIUS, duration, 2, false, Game.framesNeutron, Game.soundNeutronFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createAnti(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.ANTI_RADIUS, duration, 2, false, Game.framesAnti, Game.soundFlakFire, Game.soundFlak, Game.framesImpact, owner);
	}
	public static Projectile createOnas(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.ONAS_RADIUS, Game.ONAS_DURATION, 3, false, Game.framesOnas, Game.soundOnasFire, Game.soundMissileHit, Game.framesMissileExplosion, owner);
	}
	public static Projectile createInasa(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.INASA_RADIUS, Game.INASA_DURATION, 2, false, Game.framesInasa, Game.soundBulletFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
}
