package task4;

public class Main {
    public static void main(String[] args) {
        Goods generic = new Goods(10000, "Generic Goods");
        Food food = new Food(25000, "Chocolate Bar", 230);
        Toy toy = new Toy(150000, "Remote Car", 8);
        Book book = new Book(80000, "Java Programming", "John Doe");

        System.out.println("-- Goods --");
        generic.display();

        System.out.println("\n-- Food --");
        food.display();

        System.out.println("\n-- Toy --");
        toy.display();
        System.out.println("Tax (Toy): " + toy.calculateTax());

        System.out.println("\n-- Book --");
        book.display();
        System.out.println("Tax (Book): " + book.calculateTax());
    }
}
