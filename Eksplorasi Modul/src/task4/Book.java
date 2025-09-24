package task4;

public class Book extends Goods implements Taxable {
    private String author;

    public Book(double price, String description, String author) {
        super(price, description);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Author: " + author);
    }
}
