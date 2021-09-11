package tools;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class DrawTools {
    public static void drawString(Graphics g, String text, double centerx,
            double centery) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (int) (centerx - metrics.stringWidth(text) / 2);
        int y = (int) (centery - metrics.getHeight() / 2 + metrics.getAscent());
        g.drawString(text, x, y);
    }

    public static void drawCircle(Graphics g, double radius,
            double centerx, double centery) {
        int d = (int) (radius * 2);
        int x = (int) (centerx - radius);
        int y = (int) (centery - radius);
        g.drawOval(x, y, d, d);
    }

    public static void fillCircle(Graphics g, double radius,
            double centerx, double centery) {
        int d = (int) (radius * 2);
        int x = (int) (centerx - radius);
        int y = (int) (centery - radius);
        g.fillOval(x, y, d, d);
    }
    
    public static void drawImage(Graphics g, Image image, double centerx, double centery) {
        int x = (int) (centerx - image.getWidth(null));
        int y = (int) (centery - image.getHeight(null));
        g.drawImage(image, x, y, null);
    }
    
    public static void drawImageRotated(Graphics g, Image image, double centerx, double centery, double radians) {
        Graphics2D g2 = (Graphics2D)g.create();

        g2.translate(centerx, centery);
        g2.rotate(radians);
        g2.translate(-image.getWidth(null) / 2, -image.getHeight(null) / 2);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();
    }
    
    public static void drawImageRotatedDegrees(Graphics g, Image image, double centerx, double centery, double degrees) {
        double radians = Math.toRadians(degrees);
        drawImageRotated(g, image, centerx, centery, radians);
    }
}