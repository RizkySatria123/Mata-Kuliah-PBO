import java.util.HashMap;
import java.util.Map;

public class Fulltime implements Employee {
    private static final double OVERTIME_RATE = 30_000;
    private static final double COMMUNICATION_ALLOWANCE = 500_000;
    private static final double MANAGER_POSITION_ALLOWANCE = 5_000_000;
    private static final double CHILD_ALLOWANCE = 500_000;
    private static final int MAX_CHILDREN_ALLOWANCE = 2;

    private static final Map<String, Double> DEFAULT_BASE_SALARY;

    static {
        DEFAULT_BASE_SALARY = new HashMap<>();
        DEFAULT_BASE_SALARY.put("Staff Manager", 5_000_000d);
        DEFAULT_BASE_SALARY.put("Staff Programmer", 3_000_000d);
        DEFAULT_BASE_SALARY.put("Staff Analis", 4_000_000d);
    }

    private String name;
    private String position;
    private double baseSalary;
    private int numberOfChildren; 
    private int yearsOfService;
    private double cooperativeLoanInstallment;
    private double overtimeHours;

    public Fulltime(String name,
                    String position,
                    int yearsOfService,
                    int numberOfChildren,
                    double cooperativeLoanInstallment,
                    double overtimeHours) {
        this.name = name;
        this.position = position;
        this.baseSalary = resolveBaseSalary(position);
        this.yearsOfService = yearsOfService;
        this.numberOfChildren = numberOfChildren;
        this.cooperativeLoanInstallment = cooperativeLoanInstallment;
        this.overtimeHours = overtimeHours;
                        
    }

    private double resolveBaseSalary(String position) {
        return DEFAULT_BASE_SALARY.getOrDefault(position, 0d);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        this.baseSalary = resolveBaseSalary(position);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public double getCooperativeLoanInstallment() {
        return cooperativeLoanInstallment;
    }

    public void setCooperativeLoanInstallment(double cooperativeLoanInstallment) {
        this.cooperativeLoanInstallment = cooperativeLoanInstallment;
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

    private double calculatePositionAllowance() {
        return "Staff Manager".equalsIgnoreCase(position) ? MANAGER_POSITION_ALLOWANCE : 0;
    }

    private double calculateChildAllowance() {
        int eligibleChildren = Math.min(numberOfChildren, MAX_CHILDREN_ALLOWANCE);
        return eligibleChildren * CHILD_ALLOWANCE;
    }

    private double calculateCommunicationAllowance() {
        return COMMUNICATION_ALLOWANCE;
    }

    @Override
    public double getSalary() {
        double allowances = calculateOvertimeAllowance()
                + calculatePositionAllowance()
                + calculateChildAllowance()
                + calculateCommunicationAllowance();
        return baseSalary + allowances - cooperativeLoanInstallment;
    }
}
