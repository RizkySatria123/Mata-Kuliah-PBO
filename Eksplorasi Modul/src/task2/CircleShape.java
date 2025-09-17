package task2;

/**
 * CircleShape extends Shape implementing area & perimeter.
 */
public class CircleShape extends Shape {
    private double radius;

    public CircleShape() {
        this(1.0, "red", true);
    }

    public CircleShape(double radius) {
        this(radius, "red", true);
    }

    public CircleShape(double radius, String color, boolean filled) {
        super(color, filled);
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        this.radius = radius;
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

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("CircleShape[%s,radius=%.2f]", super.toString(), radius);
    }
}
