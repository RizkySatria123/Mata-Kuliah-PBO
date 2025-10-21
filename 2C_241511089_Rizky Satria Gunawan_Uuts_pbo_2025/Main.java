import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
    double asepOvertimeHours = calculateHours(LocalTime.of(9, 0), LocalTime.of(12, 0));
        double ujangOvertimeHours = calculateHours(LocalTime.of(13, 0), LocalTime.of(18, 0));

        Fulltime asep = new Fulltime(
                "Asep",
        "Staff Programmer",
                3,
        2,
                500_000,
                asepOvertimeHours
        );

        Parttime ujang = new Parttime(
                "Ujang",
                3_000_000,
                ujangOvertimeHours
        );

        double asepSalary = asep.getSalary();
        double ujangSalary = ujang.getSalary();

        System.out.println("Nota Gaji Bulan April 2025");
        System.out.println("==========================");
        printSlip(asep.getName(), "Fulltime", asep.getPosition(), asepOvertimeHours, asepSalary);
        printSlip(ujang.getName(), "Parttime", "-", ujangOvertimeHours, ujangSalary);
        System.out.printf("Total Gaji Dibayarkan : Rp %,.0f%n", asepSalary + ujangSalary);
    }

    private static double calculateHours(LocalTime start, LocalTime end) {
        return (end.toSecondOfDay() - start.toSecondOfDay()) / 3600.0;
    }

    private static void printSlip(String name, String status, String position, double overtimeHours, double salary) {
        System.out.println("Nama            : " + name);
        System.out.println("Status          : " + status);
        System.out.println("Jabatan         : " + position);
        System.out.printf("Jam Lembur       : %.1f jam%n", overtimeHours);
        System.out.printf("Total Gaji       : Rp %,.0f%n", salary);
    }
}
