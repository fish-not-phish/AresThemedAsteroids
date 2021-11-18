package com.aresThemeAsteroids;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import tools.Vector2;

public class Game extends Canvas implements Runnable {

//	Main game settings
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = WIDTH * 9 / 16; // aspect ratio
	public static final long FRAME_TIME = 100;
	private Menu menu;
	private Settings settings;
	private ChooseShip chooseShip;
	public static final int UI_WIDTH = WIDTH / 10;
	
//	Ship settings
	public static final double ELE_SHIP_RADIUS = 17;
	public static final double ESCORT_SHIP_RADIUS = 17;
	public static final double GAI_HVD_SHIP_RADIUS = 22;
	public static final double ISH_HVD_SHIP_RADIUS = 22;
	
	public static final double SHIP_MAX_VELOCITY = 4;
	public static int SHIP_HEALTH = 20;
	public static final double SHIP_THRUST = 0.05;
	public static final double SHIP_ROTATION = 2 * Math.PI / 100;
	public static String SHIP_NAME;
	
//	Asteroid settings
	public static final double BIG_AST_RADIUS = 25;
	public static int BIG_AST_HEALTH = 36;
	public static final double MED_AST_RADIUS = 10;
	public static int MED_AST_HEALTH = 24;
	public static final double SMALL_AST_RADIUS = 5;
	public static int SMALL_AST_HEALTH = 12;
	
	public static final int ASTEROID_HEALTH = 12;
	public static final long ASTEROID_OVERLAY_DURATION = 100;
	
//	Debris settings
	public static final double DEBRIS_RADIUS = 5;
	public static final long DEBRIS_DURATION = 250;
	
//	Weapon settings
	public static final double BULLET_VELOCITY = 6;
	public static final long BULLET_DURATION = 750;
	public static final double BULLET_RADIUS = 8;
	
	public static final double MISSILE_VELOCITY = 8;
	public static final long MISSILE_DURATION = 1500;
	public static final double MISSILE_RADIUS = 6;
	public static final double MISSLE_MASS = 1;
	
	public static final double ANTI_RADIUS = 3;
	public static final double ANTI_MASS = 0.4;
	
	public static final double ONAS_RADIUS = 3;
	public static final double ONAS_VELOCITY = 11;
	public static final long ONAS_DURATION = 1200;
	public static final double ONAS_MASS = 1;
	
	public static final double NEUTRON_VELOCITY = 8;
	public static final long NEUTRON_DURATION = 900;
	public static final double NEUTRON_RADIUS = 9;
	public static final double NEUTRON_MASS = 0.4;
	
	public static final double LECTRO_VELOCITY = 13;
	public static final long LECTRO_DURATION = 450;
	public static final double LECTRO_RADIUS = 4;
	public static final double LECTRO_MASS = 0.4;
	
	public static final double ELELASER_VELOCITY = 11;
	public static final long ELELASER_DURATION = 450;
	public static final double ELELASER_RADIUS = 4;
	public static final double ELELASER_MASS = 0.4;
	
	public static final double MAGNETO_VELOCITY = 12;
	public static final long MAGNETO_DURATION = 900;
	public static final double MAGNETO_RADIUS = 9;
	public static final double MAGNETO_MASS = 0.4;
	
	public static final double G_LASER_VELOCITY = 11;
	public static final long G_LASER_DURATION = 500;
	public static final double G_LASER_RADIUS = 4;
	public static final double G_LASER_MASS = 0.4;
	
	public static final double INASA_VELOCITY = 11;
	public static final long INASA_DURATION = 900;
	public static final double INASA_RADIUS = 6;
	public static final double INASA_MAS = 0.4;
	
	public static final double GUN_VELOCITY = 30;
	public static final long GUN_DURATION = 100;
	public static final double GUN_RADIUS = 1;
	public static final double GUN_MASS = 0.2;
	
	public static final double FLAK_VELOCITY = 8;
	public static final long FLAK_DURATION = 600;
	public static final double FLAK_RADIUS = 2;
	public static final double FLAK_MASS = 0.4;
	
	public static final long PARTICLE_DURATION = 250;
	
	public static final double PROJECTILE_MAX_ROTATION = 0.02;
	
//	Flak Drone settings
	public static final double FLAK_DRONE_RADIUS = 15;
	public static final int FLAK_DRONE_HEALTH = 120;
	
//	Misc settings
	public static final long EXPLOSION_DURATION = 1000;
	
//	Main Object Sprites & Overlays
	public static Frames framesBigAsteroid = new Frames("bigAsteroid");
	public static Frames framesBigAsteroidOverlay = new Frames("bigAsteroidOverlay");
	
	public static Frames framesMediumAsteroid = new Frames("mediumAsteroid");
	public static Frames framesMediumAsteroidAsteroidOverlay = new Frames("mediumAsteroidOverlay");
	
	public static Frames framesSmallAsteroid = new Frames("smallAsteroid");
	public static Frames framesSmallAsteroidAsteroidOverlay = new Frames("smallAsteroidOverlay");
	
//	SHIPS SPRITES
	public static Frames framesShip = new Frames("eleCruiser");
	public static Frames framesShipOverlay = new Frames("eleCruiserOverlay");
	
	public static Frames framesEscortShip = new Frames("escortShip");
	public static Frames framesEscortShipOverlay = new Frames("escortShipOverlay");
	
	public static Frames framesGaiHvdShip = new Frames("gaiHvdShip");
	public static Frames framesGaiHvdShipOverlay = new Frames("gaiHvdShipOverlay");
	
	public static Frames framesIshHvdShip = new Frames("ishHvdShip");
	public static Frames framesIshHvdShipOverlay = new Frames("ishHvdShipOverlay");
	
	public static Frames framesFlakDrone = new Frames("flakDrone");
	public static Frames framesFlakDroneOverlay = new Frames("flakDroneOverlay");
	
	public static Frames framesDebris = new Frames("debris");
	
	public static Frames framesParticle = new Frames("particle");
	
//	Weapon Sprites
	public static Frames framesBullet = new Frames("bullet");
	public static Frames framesMissile = new Frames("missle");
	public static Frames framesNeutron = new Frames("neutron");
	public static Frames framesAnti = new Frames("anti");
	public static Frames framesOnas = new Frames("onas");
	public static Frames framesInasa = new Frames("greenPhoton");
	public static Frames framesLectro = new Frames("lectro");
	public static Frames framesMagneto = new Frames("magneto");
	public static Frames framesGLaser = new Frames("greenLaser");
	public static Frames framesFlak = new Frames("flakBullet");
	public static Frames framesEleLaser = new Frames("eleLaser");
	public static Frames framesGun = new Frames("gunfire");
	public static Frames framesGunFire = new Frames("gunsmoke");
	
//	Explosions / hit markers
	public static Frames framesMissileExplosion = new Frames("missileHit");
	public static Frames framesImpact = new Frames("flak");
	public static Frames framesShipExplosion = new Frames("superNova");
	public static Frames framesObjExplosion = new Frames("destroyedExplosion");
	
//	Weapon fire sound effects
	public static SoundEffect soundBulletFire = new SoundEffect("bulletFire");
	public static SoundEffect soundMissileFire = new SoundEffect("missle");
	public static SoundEffect soundNeutronFire = new SoundEffect("neutron");
	public static SoundEffect soundFlakFire = new SoundEffect("flakFireSound");
	public static SoundEffect soundOnasFire = new SoundEffect("onasFire");
	public static SoundEffect soundInasaFire = new SoundEffect("inasaFire");
	public static SoundEffect soundLectroFire = new SoundEffect("lectroFire");
	public static SoundEffect soundGLaserFire = new SoundEffect("greenLaserFire");
	public static SoundEffect soundEleLaserFire = new SoundEffect("eleLaser");
	public static SoundEffect soundGunshotFire = new SoundEffect("gunshotFire");
	public static SoundEffect silence = new SoundEffect("silence");
	
//	ship  low health sound
	public static final SoundEffect lowHealth = new SoundEffect("lowHealth");
	
//	Weapon hit sound effect
	public static SoundEffect soundAsteroidHit = new SoundEffect("astHit");
	public static SoundEffect soundMissileHit = new SoundEffect("missleExplosion");
	public static SoundEffect soundFlak = new SoundEffect("flak");
	public static SoundEffect soundRicochet1 = new SoundEffect("ricochet1");
	public static SoundEffect soundRicochet2 = new SoundEffect("ricochet2");
	
//	Explosion sound effect
	public static SoundEffect soundAsteroidExplosion = new SoundEffect("astExplosion");
	
//	Music
	public static SoundEffect music = new SoundEffect("aresMix");

	public static long startTime = System.currentTimeMillis();
	public boolean running = false;
	public Thread gameThread;
	
	private BufferedImage image;
	private BufferedImage image2;
	public static BufferedImage image3;
	private BufferedImage leftUI;
	private BufferedImage rightUI;
	public static BufferedImage miniMenu;
	
	public static ArrayList<Ship>ships;
	private ArrayList<Projectile> projectiles;
	public static ArrayList<Asteroid> asteroids;
	public static ArrayList<ParticleEffect> particleEffects;
	private ArrayList<FlakDrone> flakDrones;
	private ArrayList<Debris> debris;
	private ArrayList<Particles> particles;
	public static KeyInput input;
	
	private static Random rand = new Random();
	
	public static enum STATE {
		MENU,
		SETTINGS,
		CHOOSE_SHIP,
		LOSE,
		GAME
	};
	
	public static STATE State = STATE.MENU;
	
	public Game() {
		if (WIDTH > 1920) {
			WIDTH = 1920;
		}
		CanvasSetup();
		input = new KeyInput();
		this.addKeyListener(input);
		this.setFocusable(true);
		initialize();
		new Window("Asteroids - Ares v1.2", this);
	}
	
	public static BufferedImage getShipImage() {
		if (SHIP_NAME == "Ele Cruiser") {
			File file = new File("./resources/sprites/eleCruiserPic.png");
			try {
				image3 = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image3;
		}
		if (SHIP_NAME == "Escort") {
			File file = new File("./resources/sprites/escortPic.png");
			try {
				image3 = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image3;
		}
		if (SHIP_NAME == "Gai HVD") {
			File file = new File("./resources/sprites/gaiHVDPic.png");
			try {
				image3 = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image3;
		}
		if (SHIP_NAME == "Ish HVD") {
			File file = new File("./resources/sprites/ishHVDPic.png");
			try {
				image3 = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image3;
		}
		
		return image3;
	}
	
	private void playMusic() {
			try {
				music.playCont();
			} catch (IOException | UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
	}

	private void initialize() {
		File file = new File("./resources/sprites/background.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file2 = new File("./resources/sprites/ares-main.png");
		try {
			image2 = ImageIO.read(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file3 = new File("./resources/sprites/aresLeftUI1.png");
		try {
			leftUI = ImageIO.read(file3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file4 = new File("./resources/sprites/aresRightUI1.png");
		try {
			rightUI = ImageIO.read(file4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file5 = new File("./resources/sprites/aresYouLost.png");
		try {
			miniMenu = ImageIO.read(file5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(new MouseInput());
		
		menu = new Menu();
		settings = new Settings();
		chooseShip = new ChooseShip();
		projectiles = new ArrayList<Projectile>();
		ships = new ArrayList<Ship>();
		asteroids = new ArrayList<Asteroid>();
		particleEffects = new ArrayList<ParticleEffect>();
		flakDrones = new ArrayList<FlakDrone>();
		debris = new ArrayList<Debris>();
		particles = new ArrayList<Particles>();
		
		Ship player = ShipFactory.createEleCruiser(input.getKeys(), input.getProcessed(), framesShip, framesShipOverlay);
		ships.add(player);
		
		addFlakDrone(0, 0, Game.WIDTH, Game.HEIGHT, FLAK_DRONE_RADIUS);
		// places asteroids on x and y coordinates
		for (int i = 0; i < 12; i++) {
			addAsteroid(0, 0, Game.WIDTH, Game.HEIGHT, BIG_AST_RADIUS);
		}
		playMusic();
	}
	
	public void addFlakDrone(double left, double top, double right, double bottom, double radius) {
		double width = right - left;
		double height = bottom - top;
		double x = rand.nextDouble() * (width - 2 * radius) + radius + left;
		double y = rand.nextDouble() * (height - 2 * radius) + radius + top;
		Vector2 pos = new Vector2(x, y);
		Vector2 velocity = Vector2.zero();
		
		FlakDrone flakDrone = new FlakDrone(pos, velocity, radius);
		
		flakDrones.add(flakDrone);
	}
	
	public static void addAsteroid(double left, double top, double right, double bottom, double radius) {
		int oldSize = asteroids.size();
		while (oldSize == asteroids.size()) {
			double width = right - left;
			double height = bottom - top;
			double x = rand.nextDouble() * (width - 2 * radius) + radius + left;
			double y = rand.nextDouble() * (height - 2 * radius) + radius + top;
			Vector2 pos = new Vector2(x, y);
			Vector2 velocity = new Vector2(-3, 3, -3, 3);
			Asteroid asteroid = AsteroidFactory.createBigAsteroid(pos, velocity, framesBigAsteroid, framesBigAsteroidOverlay);
			if (!ships.isEmpty()) {
				if (ships.get(0).isColliding(asteroid)) {
					continue;
				}
			}
			for (Asteroid other : asteroids) {
				if (other.isColliding(asteroid)) {
					continue;
				}
			}
			asteroids.add(asteroid);
		}
	}
	
	public void addAsteroids(Asteroid asteroid) {
		double angle = rand.nextDouble() * Math.PI * 2;
		Vector2 direction1 = new Vector2(asteroid.getRadius() * .5, 0).rot(angle);
		Vector2 direction2 = direction1.rot(Math.PI);
		Vector2 pos = asteroid.getPos().add(direction1);
		Vector2 velocity = new Vector2(-3, 3, -3, 3);
		double radius = asteroid.getRadius() / 2;
		
		if (asteroid.getRadius() == 25) {
			Asteroid newAsteroid = AsteroidFactory.createMediumAsteroid(pos, velocity, framesMediumAsteroid, framesMediumAsteroidAsteroidOverlay);
			asteroids.add(newAsteroid);
			Vector2 otherVelocity = new Vector2(-3, 3, -3, 3);
			newAsteroid = AsteroidFactory.createMediumAsteroid(asteroid.getPos().add(direction2), otherVelocity, framesMediumAsteroid, framesMediumAsteroidAsteroidOverlay);
			newAsteroid.setRadius(asteroid.getRadius() / 2);
			asteroids.add(newAsteroid);
		} else {
			Asteroid newAsteroid = AsteroidFactory.createSmallAsteroid(pos, velocity, framesSmallAsteroid, framesSmallAsteroidAsteroidOverlay);
			asteroids.add(newAsteroid);
			Vector2 otherVelocity = new Vector2(-3, 3, -3, 3);
			newAsteroid = AsteroidFactory.createSmallAsteroid(asteroid.getPos().add(direction2), otherVelocity, framesSmallAsteroid, framesSmallAsteroidAsteroidOverlay);
			asteroids.add(newAsteroid);
		}
	}
	
	public void addDebris(Projectile projectile) {
		double angle = rand.nextDouble() * Math.PI * 2;
		Vector2 direction1 = new Vector2(projectile.getRadius() * .5, 0).rot(angle);
		Vector2 direction2 = direction1.rot(Math.PI);
		Vector2 pos = projectile.getPos().add(direction1);
		Vector2 velocity = new Vector2(-3, 3, -3, 3);
		double radius = DEBRIS_RADIUS;
		
		Debris deBris = new Debris(pos, velocity, radius, DEBRIS_DURATION);
		debris.add(deBris);
		
		Vector2 otherVelocity = new Vector2(-3, 3, -3, 3);
		
		deBris = new Debris(projectile.getPos().add(direction2), otherVelocity, radius, DEBRIS_DURATION);
		debris.add(deBris);
		
		Vector2 otherVelocity2 = new Vector2(-3, 3, -3, 3);
		deBris = new Debris(projectile.getPos().add(direction2), otherVelocity2, radius, DEBRIS_DURATION);
		debris.add(deBris);
		
		Vector2 otherVelocity3 = new Vector2(-3, 3, -3, 3);
		deBris = new Debris(projectile.getPos().add(direction2), otherVelocity3, radius, DEBRIS_DURATION);
		debris.add(deBris);
	}
	
	public void addParticles(Projectile projectile) {
		double angle = rand.nextDouble() * Math.PI * 2;
		Vector2 direction1 = new Vector2(projectile.getRadius() * .5, 0).rot(angle);
		Vector2 direction2 = direction1.rot(Math.PI);
		Vector2 pos = projectile.getPos().add(direction1);
		Vector2 velocity = new Vector2(-3, 3, -3, 3);
		double radius = DEBRIS_RADIUS;
		
		Particles particle = new Particles(pos, velocity, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity = new Vector2(-3, 3, -3, 3);
		
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity2 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity2, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity3 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity3, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity4 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity4, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity5 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity5, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity6 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity6, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity7 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity7, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity8 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity8, radius, PARTICLE_DURATION);
		particles.add(particle);
		
		Vector2 otherVelocity9 = new Vector2(-3, 3, -3, 3);
		particle = new Particles(projectile.getPos().add(direction2), otherVelocity9, radius, PARTICLE_DURATION);
		particles.add(particle);
	}
	
	private void CanvasSetup() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void run() {
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running) {
			long now = System.nanoTime();
			
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while (delta >= 1) {
//				Hacky pause functionality
				if (!isPaused()) {
					update();
					remove();
				} 
				delta--;
			}
			if (running) 
				if (!isPaused()) {
					draw();
					frames++;
				}
				
			if (System.currentTimeMillis() - timer > 1000) {
				if (!isPaused()) {
					timer += 1000;
					frames = 0;
				}
			}
		}
		stop();
	}
	
	private boolean isPaused() {
		if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
			return true;
		}
		return false;
}

	private void draw() {
		BufferStrategy buffer = this.getBufferStrategy();
		
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		drawMenuBackground(g);
		
		
		if (State == STATE.GAME) {
			drawBackground(g);
				for (Projectile projectile : projectiles) {
					projectile.draw(g);
				}
				for (Debris flakDebris : debris) {
					flakDebris.draw(g);
				}
				for (Ship ship : ships) {
					ship.draw(g);
				}
				for (Asteroid asteroid : asteroids) {
					asteroid.draw(g);
				}
				for (ParticleEffect particleEffect : particleEffects) {
					particleEffect.draw(g);
				}
				for (FlakDrone flakDrone : flakDrones) {
					flakDrone.draw(g);
				}
				for (Particles particle : particles) {
					particle.draw(g);
				}
				if (ships.isEmpty()) {
					drawLose(g);
				}
				drawLeftUI(g);
				drawRightUI(g);
				drawHealthBar(g);
		}
		else if (State == STATE.MENU) {
			menu.draw(g);
		}
		else if (State == STATE.SETTINGS) {
			settings.draw(g);
		}
		else if (State == STATE.CHOOSE_SHIP) {
			chooseShip.draw(g);
		}
		g.dispose();
		buffer.show();
	}
	
	private void drawLose(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Game.miniMenu, Game.WIDTH / 3, Game.HEIGHT / 3, Game.WIDTH / 3, Game.HEIGHT / 4, null);
	}
	
	private void tookDamage(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	private void drawHealthBar(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		if (!ships.isEmpty()) {
			int w = 11;
			int h = ships.get(0).getHealth() * 7;
			int x = WIDTH - (WIDTH / 61);
			int y = (HEIGHT / 2 - 183) + (130 - h);
			if (WIDTH >= 1920) {
				w = 11;
				h = ships.get(0).getHealth() * 7;
				x = WIDTH - (WIDTH / 61);
				y = (HEIGHT / 2 - 173) + (120 - h);
			}
			else if (WIDTH == 1366) {
				w = 7;
				h = ships.get(0).getHealth() * 5 - 1;
				x = WIDTH - (WIDTH / 61);
				y = (HEIGHT / 2 - 128) + (90 - h);
			}
			else if (WIDTH == 1600) {
				w = 9;
				h = ships.get(0).getHealth() * 5 + 17;
				x = WIDTH - (WIDTH / 61);
				y = (HEIGHT / 2 - 173) + (130 - h);
			}
			else {
				w = 7;
				h = ships.get(0).getHealth() * 5 - 1;
				x = WIDTH - (WIDTH / 61);
				y = (HEIGHT / 2 - 128) + (90 - h);
			}
			g2.fillRect(x, y, w, h);
		}
	}

	private void drawLeftUI(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(leftUI, 0, 0, UI_WIDTH, Game.HEIGHT, null);
	}
	
	private void drawRightUI(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(rightUI, WIDTH - (WIDTH / 50), 0, WIDTH / 50, Game.HEIGHT, null);
	}
	
	private void drawBackground(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
	
	private void drawMenuBackground(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image2, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
	
	private void remove() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile projectile = projectiles.get(i);
			if (!projectile.isAlive() && projectile.getOwner() == FlakDrone.class && projectile.getFrame() == framesFlak) {
				projectiles.remove(projectile);
				projectile.getHitSound().play();
				i--;
				ParticleEffect impact = new ParticleEffect(projectile.getPos(), projectile.getRadius(), projectile.getHitFrame(), FRAME_TIME, 400);
				particleEffects.add(impact);
				addDebris(projectile);
			} else if (!projectile.isAlive()) {
				projectiles.remove(projectile);
				i--;
			}
		}
		for (int i = 0; i < ships.size(); i++) {
			Ship ship = ships.get(i);
			if (!ship.isAlive()) {

			}
		}
		for (int i = 0; i < asteroids.size(); i++) {
			Asteroid asteroid = asteroids.get(i);
			if (!asteroid.isAlive()) {
				asteroids.remove(asteroid);
				i--;
				soundAsteroidExplosion.play();
				ParticleEffect p = new ParticleEffect(asteroid.getPos(), asteroid.getRadius(), framesShipExplosion, FRAME_TIME, EXPLOSION_DURATION);
				particleEffects.add(p);
				if (asteroid.getRadius() <= 25 && asteroid.getRadius() > 6) {
					addAsteroids(asteroid);
				}
			}
		}
		for (int i = 0; i < particleEffects.size(); i++) {
			ParticleEffect particleEffect = particleEffects.get(i);
			if (!particleEffect.isAlive()) {
				particleEffects.remove(particleEffect);
				i--;
			}
		}
		for (int i = 0; i < debris.size(); i++) {
			Debris flakDebris = debris.get(i);
			if (!flakDebris.isAlive()) {
				debris.remove(flakDebris);
				i--;
			}
		}
		for (int i = 0; i < particles.size(); i++) {
			Particles particle = particles.get(i);
			if (!particle.isAlive()) {
				particles.remove(particle);
				i--;
			}
		}
		for (int i = 0; i < flakDrones.size(); i++) {
			FlakDrone flakDrone = flakDrones.get(i);
			if (!flakDrone.isAlive()) {
				flakDrones.remove(flakDrone);
				i--;
				soundAsteroidExplosion.play();
				ParticleEffect p = new ParticleEffect(flakDrone.getPos(), flakDrone.getRadius(), framesShipExplosion, FRAME_TIME, EXPLOSION_DURATION);
				particleEffects.add(p);
			}
		}
	}
	
	private void update() {
		if (State == STATE.GAME) {
			for (FlakDrone flakDrone : flakDrones) {
				flakDrone.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (Debris flakDebris : debris) {
				flakDebris.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (Particles particle : particles) {
				particle.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (Ship ship : ships) {
				ship.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (Projectile projectile : projectiles) {
				projectile.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (ParticleEffect particleEffect : particleEffects) {
				particleEffect.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
			for (Asteroid asteroid : asteroids) {
				asteroid.update(ships, projectiles, asteroids, flakDrones, debris, particles);
			}
		}

//		All collision resolution	
		for (int i = 0; i < asteroids.size(); i++) {
			Asteroid asteroid = asteroids.get(i);
			for (int j = i + 1; j < asteroids.size(); j++) {
				Asteroid otherAsteroid = asteroids.get(j);
				if (asteroid.isColliding(otherAsteroid)) {
					asteroid.resolveCollision(otherAsteroid);
				}
			}
			for (FlakDrone flakDrone : flakDrones) {	
				if (asteroid.isColliding(flakDrone)) {
					flakDrone.resolveCollision(asteroid);
				}
			}
			for (Ship ship : ships) {
				if (ship.isColliding(asteroid)) {					
					ship.resolveCollision(asteroid);
				}
			}
		}
		
		for (Projectile projectile : projectiles) {
			for (Asteroid asteroid : asteroids) {
				if (asteroid.isColliding(projectile)) {
					asteroid.resolveCollision(projectile);
					if (projectile.isLaser()) {
						addParticles(projectile);
					}
				}
			}
			for (FlakDrone flakDrone : flakDrones) {	
				if (projectile.isColliding(flakDrone)) {
					flakDrone.resolveCollision(projectile);
					if (projectile.isLaser()) {
						addParticles(projectile);
					}
				}
			}
			for (Ship ship : ships) {
				if (ship.isColliding(projectile)) {					
					ship.resolveCollision(projectile);
					
				}
			}
		}
		if (!ships.isEmpty()) {
			if (!ships.get(0).isAlive()) {
				soundAsteroidExplosion.play();
				ParticleEffect p = new ParticleEffect(ships.get(0).getPos(), ships.get(0).getRadius(), framesObjExplosion, FRAME_TIME, EXPLOSION_DURATION);
				ships.remove(0);
				particleEffects.add(p);
			}
		}
	}
	
	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
	}
	public void stop() {
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new Game();
	}
}
