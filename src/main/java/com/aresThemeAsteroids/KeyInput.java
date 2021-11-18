package com.aresThemeAsteroids;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyInput extends KeyAdapter {
	private Set<Integer> keys = new HashSet<Integer>();
	private Set<Integer> processed = new HashSet<Integer>();
	
	public Set<Integer> getProcessed() {
		return processed;
	}
	
	public Set<Integer> getKeys() {
		return keys;
	}
	
	public KeyInput() {}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		keys.add(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		keys.remove(e.getKeyCode());
		processed.remove(e.getKeyCode());
	}
}
