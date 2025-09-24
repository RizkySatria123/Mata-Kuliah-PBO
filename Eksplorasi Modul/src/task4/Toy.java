package task4;

public class Toy extends Goods implements Taxable {
    private int minimumAge;

    public Toy(double price, String description, int minimumAge) {
        super(price, description);
        this.minimumAge = minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Minimum Age: " + minimumAge);
    }
}
