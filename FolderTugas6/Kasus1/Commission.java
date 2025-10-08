public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String name, String address, String phone, String socialSecurityNumber, double rate, double commissionRate) {
        super(name, address, phone, socialSecurityNumber, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    @Override
    public double pay() {
        double payment = super.pay() + (commissionRate * totalSales);
        totalSales = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}
