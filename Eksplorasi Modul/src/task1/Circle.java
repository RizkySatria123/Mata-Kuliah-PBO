package task1;

/**
 * Circle class representing a circle with radius and color.
 * Demonstrates encapsulation, constructor overloading, and will be used as superclass of Cylinder.
 */
public class Circle {
    private double radius; // must be >= 0
    private String color;

    public Circle() {
        this(1.0, "red");
    }

    public Circle(double radius) {
        this(radius, "red");
    }

    public Circle(double radius, String color) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        this.radius = radius;
        this.color = color == null ? "red" : color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? this.color : color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f,color=%s]", radius, color);
    }
}
