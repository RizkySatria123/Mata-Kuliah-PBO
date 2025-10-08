public class Paint {
    private double coverage;

    public Paint(double coverage) {
        this.coverage = coverage;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}
