public class Parttime implements Employee {
    private static final double OVERTIME_RATE = 30_000;

    private String name;
    private double baseSalary;
    private double overtimeHours;

    public Parttime(String name, double baseSalary, double overtimeHours) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.overtimeHours = overtimeHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    private double calculateOvertimeAllowance() {
        return overtimeHours * OVERTIME_RATE;
    }

    @Override
    public double getSalary() {
        return baseSalary + calculateOvertimeAllowance();
    }
}
