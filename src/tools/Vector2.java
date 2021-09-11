package tools;
import java.awt.Point;

public class Vector2 {

    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(double minX, double maxX, double minY, double maxY) {
        this.x = Math.random() * (maxX - minX) + minX;
        this.y = Math.random() * (maxY - minY) + minY;
    }

    public Vector2(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double dist(Vector2 other) {
        return Math.sqrt((other.x - this.x) * (other.x - this.x)
                + (other.y - this.y) * (other.y - this.y));
    }

    public double length() {
        return Math.abs(dist(new Vector2(0, 0)));
    }

    public double dot(Vector2 other) {
        return x * other.x + y * other.y;
    }
    
    public static Vector2 zero() {
        return new Vector2(0, 0);
    }

    public Vector2 copy() {
        return new Vector2(x, y);
    }

    public Vector2 neg() {
        return this.mul(-1);
    }

    public Vector2 unit() {
        double length = length();
        if (length == 0)
            return copy();
        return new Vector2(x / length, y / length);
    }

    public Vector2 mul(double val) {
        return new Vector2(x * val, y * val);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 rot(double theta) {
        double c = Math.cos(theta);
        double s = Math.sin(theta);
        return new Vector2(x * c - y * s, x * s + y * c);
    }
    
    public double angleBetween(Vector2 vector) {
    	double result =  Math.atan2(vector.getY(), vector.getX()) - Math.atan2(this.getY(), this.getX());
    	if (result > Math.PI) {
    		return (Math.PI * 2 - result) * (-1);
    	}
    	return result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void setX(double x) {
    	this.x = x;
    }

    public void setY(double y) {
    	this.y = y;
    }
    
    public int intX() {
        return (int) x;
    }

    public int intY() {
        return (int) y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public double getAngle() {
    	return Math.atan2(y, x);
    }
}