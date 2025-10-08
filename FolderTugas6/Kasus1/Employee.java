public class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone, String socialSecurityNumber, double rate) {
        super(name, address, phone);
        this.socialSecurityNumber = socialSecurityNumber;
        this.payRate = rate;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number: " + socialSecurityNumber;
        return result;
    }

    @Override
    public double pay() {
        return payRate;
    }
}
