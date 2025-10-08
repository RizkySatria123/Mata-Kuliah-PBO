package Kasus3;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("How many strings do you want to sort? ");
            int size = Integer.parseInt(scan.nextLine().trim());
            String[] strList = new String[size];

            System.out.println("Enter the strings...");
            for (int i = 0; i < size; i++) {
                strList[i] = scan.nextLine();
            }

            Sorting.insertionSort(strList);

            System.out.println("\nStrings in descending order:");
            for (String value : strList) {
                System.out.println(value);
            }
        }
    }
}
