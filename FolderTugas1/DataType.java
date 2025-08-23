// File: FolderTugas1/DataType.java
// Deskripsi: Program Java untuk menentukan tipe data yang dapat menampung angka yang diberikan
// Pembuat: Rizky Satria Gunawan

import java.util.Scanner;
public class DataType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            try {
                // Baca angka sebagai tipe data long untuk menghindari overflow
                long n = scanner.nextLong();
                System.out.println(n + " can be fitted in:");

                // Cek dan cetak untuk setiap tipe data secara berurutan
                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                 // long selalu bisa muat di long
                System.out.println("* long");

            } catch (Exception e) {
                // Blok ini menangani kasus di mana input terlalu besar bahkan untuk long
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }
        }
        // Tutup objek Scanner untuk membebaskan 
        scanner.close();
    }
}
