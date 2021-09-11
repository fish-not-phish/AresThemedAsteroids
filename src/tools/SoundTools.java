package tools;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundTools {
    public static void playSound(String filename) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File(filename));
                    Clip clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void playSound(File file) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
