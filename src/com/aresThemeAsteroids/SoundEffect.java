package com.aresThemeAsteroids;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tools.SoundTools;


public class SoundEffect {
	private File sound;
	
	public SoundEffect(String name) {
		String wav = "./resources/sounds/" + name + ".wav";
		sound = new File(wav);
	}
	
	public void play() {
		SoundTools.playSound(sound);
	}
	
	public void playCont() throws IOException, UnsupportedAudioFileException {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
