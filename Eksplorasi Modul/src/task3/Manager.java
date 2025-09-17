package task3;

/**
 * Manager extends Employee adding bonus and overriding computePay while using super.computePay().
 */
public class Manager extends Employee {
    private double bonus; // one-time bonus added to pay

    public Manager(String name, double hourlyRate, double bonus) {
        super(name, hourlyRate);
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus must be non-negative");
        }
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { if (bonus < 0) throw new IllegalArgumentException("Bonus must be non-negative"); this.bonus = bonus; }

    @Override
    public double computePay() {
        return super.computePay() + bonus; // augment base logic
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() + ",bonus=" + bonus + '}';
    }
}
