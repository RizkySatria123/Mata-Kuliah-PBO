package task2;

/**
 * Abstract superclass Shape representing general properties of shapes.
 */
public abstract class Shape {
    private String color;
    private boolean filled;

    protected Shape() {
        this("red", true);
    }

    protected Shape(String color, boolean filled) {
        this.color = color == null ? "red" : color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? this.color : color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("Shape[color=%s,filled=%s]", color, filled);
    }
}
