package task1;

/**
 * Demo class for Task 1 showing usage of Circle and Cylinder classes.
 */
public class Task1Demo {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5, "blue");

        Cylinder cyl1 = new Cylinder();
        Cylinder cyl2 = new Cylinder(2.5, 5.0, "green");

        System.out.println("-- Circle Objects --");
        System.out.println(c1);
        System.out.println(c2 + ", area=" + String.format("%.2f", c2.getArea()));

        System.out.println("\n-- Cylinder Objects --");
        System.out.println(cyl1);
        System.out.println(cyl2);

        // Polymorphism: a Cylinder IS-A Circle
        Circle poly = new Cylinder(3.0, 4.0, "yellow");
        System.out.println("\nPolymorphism example (declared as Circle, actual Cylinder):" );
        System.out.println(poly); // calls Cylinder.toString() due to dynamic binding

        // Downcast example (safe with instanceof)
        if (poly instanceof Cylinder) {
            double volume = ((Cylinder) poly).getVolume();
            System.out.println("Volume via downcast: " + String.format("%.2f", volume));
        }
    }
}
