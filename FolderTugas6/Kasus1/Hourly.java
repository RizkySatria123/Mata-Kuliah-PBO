public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone, String socialSecurityNumber, double rate) {
        super(name, address, phone, socialSecurityNumber, rate);
        hoursWorked = 0;
    }

    public void addHours(int moreHours) {
        hoursWorked += moreHours;
    }

    @Override
    public double pay() {
        double payment = payRate * hoursWorked;
        hoursWorked = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCurrent Hours: " + hoursWorked;
    }
}
