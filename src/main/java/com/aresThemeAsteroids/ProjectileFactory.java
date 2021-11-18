package com.aresThemeAsteroids;
import java.awt.Color;

import tools.Vector2;

public class ProjectileFactory {
	public static Projectile createMissle(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.MISSILE_RADIUS, Game.MISSLE_MASS, duration, 3, true, false, Game.framesMissile, Game.soundMissileFire, Game.soundMissileHit, Game.framesMissileExplosion, owner);
	}
	public static Projectile createNeutron(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.NEUTRON_RADIUS, Game.NEUTRON_MASS, duration, 2, false, false, Game.framesNeutron, Game.soundNeutronFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createAnti(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.ANTI_RADIUS, Game.ANTI_MASS, duration, 2, false, false, Game.framesAnti, Game.soundFlakFire, Game.soundFlak, Game.framesImpact, owner);
	}
	public static Projectile createOnas(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.ONAS_RADIUS, Game.ONAS_MASS, Game.ONAS_DURATION, 3, false, false, Game.framesOnas, Game.soundOnasFire, Game.soundMissileHit, Game.framesMissileExplosion, owner);
	}
	public static Projectile createInasa(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.INASA_RADIUS, Game.INASA_MAS, Game.INASA_DURATION, 2, false, false, Game.framesInasa, Game.soundInasaFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createLectro(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.LECTRO_RADIUS, Game.LECTRO_MASS, Game.LECTRO_DURATION, 2, false, true, Game.framesLectro, Game.soundLectroFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createMagneto(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.MAGNETO_RADIUS, Game.MAGNETO_MASS, Game.MAGNETO_DURATION, 2, false, false, Game.framesMagneto, Game.soundInasaFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createGLaser(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.G_LASER_RADIUS, Game.G_LASER_MASS, Game.G_LASER_DURATION, 2, false, true, Game.framesGLaser, Game.soundGLaserFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createFlak(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.FLAK_RADIUS, Game.FLAK_MASS, Game.FLAK_DURATION, 2, false, false, Game.framesFlak, Game.silence, Game.soundFlak, Game.framesImpact, owner);
	}
	public static Projectile createEleLaser(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.ELELASER_RADIUS, Game.ELELASER_MASS, Game.ELELASER_DURATION, 2, false, true, Game.framesEleLaser, Game.soundEleLaserFire, Game.soundAsteroidHit, Game.framesImpact, owner);
	}
	public static Projectile createGunsmoke1(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.GUN_RADIUS, Game.GUN_MASS, 100, 0, false, true, Game.framesGunFire, Game.silence, Game.silence, Game.framesImpact, owner);
	}
	public static Projectile createGunsmoke2(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.GUN_RADIUS, Game.GUN_MASS, 100, 0, false, true, Game.framesGunFire, Game.silence, Game.silence, Game.framesImpact, owner);
	}
	public static Projectile createGunshot1(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.GUN_RADIUS, Game.GUN_MASS, Game.GUN_DURATION, 1, false, true, Game.framesGun, Game.soundGunshotFire, Game.soundRicochet1, Game.framesImpact, owner);
	}
	public static Projectile createGunshot2(Vector2 pos, Vector2 vel, long duration, Class<?> owner) {
		return new Projectile(pos, vel, Game.GUN_RADIUS, Game.GUN_MASS, Game.GUN_DURATION, 1, false, true, Game.framesGun, Game.soundGunshotFire, Game.soundRicochet2, Game.framesImpact, owner);
	}
}
