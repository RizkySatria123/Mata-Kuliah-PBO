package Kasus3;

public class Salesperson implements Comparable<Salesperson> {
    private String firstName;
    private String lastName;
    private int totalSales;

    public Salesperson(String firstName, String lastName, int totalSales) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSales = totalSales;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ": " + totalSales;
    }

    @Override
    public int compareTo(Salesperson other) {
        if (other == null) {
            return 1;
        }

        int salesComparison = Integer.compare(this.totalSales, other.totalSales);
        if (salesComparison != 0) {
            return salesComparison;
        }

        int lastNameComparison = -this.lastName.compareToIgnoreCase(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = -this.firstName.compareToIgnoreCase(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return 0;
    }
}
