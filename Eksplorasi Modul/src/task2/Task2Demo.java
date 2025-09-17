package task2;

/**
 * Demo for Shape hierarchy: Shape -> CircleShape, Rectangle, Square
 */
public class Task2Demo {
    public static void main(String[] args) {
        Shape s1 = new CircleShape(2.0, "blue", true);
        Shape s2 = new Rectangle(2.0, 5.0, "green", false);
        Shape s3 = new Square(3.0, "yellow", true);

        System.out.println("-- Polymorphic Shapes --");
        Shape[] shapes = { s1, s2, s3 };
        for (Shape s : shapes) {
            System.out.printf("%s area=%.2f perimeter=%.2f%n", s, s.getArea(), s.getPerimeter());
        }

        // Downcast example
        if (s3 instanceof Square sq) {
            System.out.println("Square side via downcast pattern: " + sq.getSide());
        }

        // Show invariant enforcement
        Square sq2 = new Square(4.0, "magenta", true);
        sq2.setWidth(10.0); // actually sets both width & length
        System.out.println("After setWidth on Square: " + sq2 + " area=" + sq2.getArea());
    }
}
