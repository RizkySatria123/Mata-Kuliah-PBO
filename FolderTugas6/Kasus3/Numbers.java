package Kasus3;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("How many integers do you want to sort? ");
            int size = scan.nextInt();
            Integer[] intList = new Integer[size];

            System.out.println("Enter the numbers...");
            for (int i = 0; i < size; i++) {
                intList[i] = scan.nextInt();
            }

            Sorting.insertionSort(intList);

            System.out.println("\nNumbers in descending order:");
            for (Integer number : intList) {
                System.out.println(number);
            }
        }
    }
}
