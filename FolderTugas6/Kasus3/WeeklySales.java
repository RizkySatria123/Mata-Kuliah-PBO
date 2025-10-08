package Kasus3;

public class WeeklySales {
    public static void main(String[] args) {
        Salesperson[] salesStaff = new Salesperson[10];

        salesStaff[0] = new Salesperson("Jane", "Jones", 3000);
        salesStaff[1] = new Salesperson("Daffy", "Duck", 4935);
        salesStaff[2] = new Salesperson("James", "Jones", 3000);
        salesStaff[3] = new Salesperson("Mickey", "Mouse", 5840);
        salesStaff[4] = new Salesperson("Clara", "Oswald", 3700);
        salesStaff[5] = new Salesperson("Donald", "Duck", 7600);
        salesStaff[6] = new Salesperson("Minnie", "Mouse", 5350);
        salesStaff[7] = new Salesperson("Betty", "Boop", 2450);
        salesStaff[8] = new Salesperson("Walt", "Smith", 3000);
        salesStaff[9] = new Salesperson("Ginny", "Poe", 2850);

        Sorting.insertionSort(salesStaff);

        System.out.println("\nRanking of Sales for the Week\n");
        for (Salesperson salesperson : salesStaff) {
            System.out.println(salesperson);
        }
    }
}
