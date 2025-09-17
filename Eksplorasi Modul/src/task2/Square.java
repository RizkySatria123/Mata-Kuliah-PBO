package task2;

/**
 * Square is a special Rectangle where width == length (side).
 * Demonstrates overriding setters to keep invariant.
 */
public class Square extends Rectangle {

    public Square() {
        this(1.0, "red", true);
    }

    public Square(double side) {
        this(side, "red", true);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    // Override to enforce width=length when someone calls setWidth or setLength directly
    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return String.format("Square[%s,side=%.2f]", super.toString(), getSide());
    }
}
