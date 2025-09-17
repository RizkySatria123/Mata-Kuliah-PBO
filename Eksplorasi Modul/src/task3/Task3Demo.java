package task3;

/**
 * Demo for multiple inheritance via interfaces and class hierarchy.
 */
public class Task3Demo {
    public static void main(String[] args) {
        Employee e = new Employee("Alice", 50);
        e.addHours(8);
        e.attendTraining("Safety");

        Manager m = new Manager("Bob", 80, 500);
        m.addHours(10);
        m.attendTraining("Leadership");

        Trainer t = new Trainer("Charlie", 60);
        t.addHours(6);
        t.leadSession("Java Inheritance");

        System.out.println("-- Employees --");
        System.out.println(e);
        System.out.println(m);
        System.out.println(t);

        // Polymorphism through interface references
        Payable[] payroll = { e, m, t };
        double total = 0;
        for (Payable p : payroll) {
            total += p.computePay();
        }
        System.out.println("Total payroll: " + total);

        // WorkLog reference
        WorkLog wl = t; // Trainer implements WorkLog via Employee
        System.out.println("Trainer hours via WorkLog ref: " + wl.getTotalHours());
    }
}
