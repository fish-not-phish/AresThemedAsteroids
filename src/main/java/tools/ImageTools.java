package tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.HashMap;

public class ImageTools {
    public static BufferedImage copyImage(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage resizeImage(BufferedImage image,
            int targetWidth, int targetHeight) {
        Image resized = image.getScaledInstance(targetWidth, targetHeight,
                Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight,
                BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resized, 0, 0, null);
        return outputImage;
    }

    public static BufferedImage resizeImage(BufferedImage image,
            double percent) {
        return resizeImage(image, (int) (image.getWidth() * percent),
                (int) (image.getHeight() * percent));
    }
    
    public static BufferedImage rotateImage(BufferedImage image, double radians) {
        double sin = Math.abs(Math.sin(radians)), cos = Math.abs(Math.cos(radians));
        int w = image.getWidth();
        int h = image.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(radians, x, y);
        g2d.setTransform(at);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return rotated;
    }
    
    public static BufferedImage rotateImageDegrees(BufferedImage image, double degrees) {
        double radians = Math.toRadians(degrees);
        return rotateImage(image, radians);
    }

    public static HashMap<Color, BufferedImage> tintImage(BufferedImage image,
            Color tintTarget, Color[] tints, double tolerance) {
        HashMap<Color, BufferedImage> tintsMap = new HashMap<Color, BufferedImage>();
        for (Color tint : tints) {
            tintsMap.put(tint, tintImage(image, tintTarget, tint, tolerance));
        }
        return tintsMap;
    }

    public static BufferedImage tintImage(BufferedImage image, Color tintTarget,
            Color tint, double tolerance) {
        BufferedImage tinted = copyImage(image);
        for (int x = 0; x < tinted.getWidth(); x++) {
            for (int y = 0; y < tinted.getHeight(); y++) {
                Color pixel = new Color(tinted.getRGB(x, y));

                if (ColorTools.difference(tintTarget, pixel) < tolerance) {
                    float[] hsb = Color.RGBtoHSB(pixel.getRed(),
                            pixel.getGreen(), pixel.getBlue(), null);
                    float[] tinthsb = Color.RGBtoHSB(tint.getRed(),
                            tint.getGreen(), tint.getBlue(), null);
                    float h = tinthsb[0];
                    float s = tinthsb[1];
                    float b = hsb[2];
                    int tintedColor = Color.HSBtoRGB(h, s, b);

                    tinted.setRGB(x, y, tintedColor);
                }
            }
        }
        return tinted;
    }
}
