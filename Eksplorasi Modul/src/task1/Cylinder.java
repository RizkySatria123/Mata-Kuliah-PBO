package task1;

/**
 * Cylinder extends Circle by adding height and computing volume.
 * Demonstrates use of super() to call parent constructors and method reuse.
 */
public class Cylinder extends Circle {
    private double height; // must be >= 0

    public Cylinder() {
        this(1.0, 1.0, "red");
    }

    public Cylinder(double radius) {
        this(radius, 1.0, "red");
    }

    public Cylinder(double radius, double height) {
        this(radius, height, "red");
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color); // call superclass constructor
        if (height < 0) {
            throw new IllegalArgumentException("Height must be non-negative");
        }
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height must be non-negative");
        }
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height; // reuse Circle's getArea()
    }

    @Override
    public String toString() {
        // Augment parent's toString by prefixing subclass name & adding height
        return String.format("Cylinder[%s,height=%.2f,volume=%.2f]", super.toString(), height, getVolume());
    }
}
