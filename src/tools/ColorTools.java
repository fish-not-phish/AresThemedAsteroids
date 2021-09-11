package tools;

import java.awt.Color;

public class ColorTools {
    public static Color randomColor() {
        return new Color((float) Math.random(), (float) Math.random(),
                (float) Math.random());
    }

    public static double difference(Color a, Color b) {
        double redDiff = a.getRed() - b.getRed();
        double greenDiff = a.getGreen() - b.getGreen();
        double blueDiff = a.getBlue() - b.getBlue();
        double distance = Math.sqrt(redDiff * redDiff + greenDiff * greenDiff
                + blueDiff * blueDiff);
        double percent = distance
                / Math.sqrt(255 * 255 + 255 * 255 + 255 * 255);
        return percent;
    }
}
