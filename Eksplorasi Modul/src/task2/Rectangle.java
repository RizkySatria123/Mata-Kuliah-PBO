package task2;

/**
 * Rectangle extends Shape with width & length.
 */
public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        this(1.0, 1.0, "red", true);
    }

    public Rectangle(double width, double length) {
        this(width, length, "red", true);
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        validate(width, length);
        this.width = width;
        this.length = length;
    }

    private void validate(double width, double length) {
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("Width/Length must be non-negative");
        }
    }

    public double getWidth() { return width; }
    public void setWidth(double width) { validate(width, this.length); this.width = width; }

    public double getLength() { return length; }
    public void setLength(double length) { validate(this.width, length); this.length = length; }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[%s,width=%.2f,length=%.2f]", super.toString(), width, length);
    }
}
