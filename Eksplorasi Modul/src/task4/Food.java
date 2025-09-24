package task4;

public class Food extends Goods {
    private int calories;

    public Food(double price, String description, int calories) {
        super(price, description);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Calories: " + calories);
    }
}
