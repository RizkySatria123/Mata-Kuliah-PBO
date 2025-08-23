// File: FolderTugas1/Strings.java
// Deskripsi: Program Java untuk mengelola operasi pada string
// Pembuat: Rizky Satria Gunawan
import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        // Objek Scanner untuk membaca input dari pengguna
        Scanner input = new Scanner(System.in);
        
        // Membaca dua baris input string
        String stringA = input.next();
        String stringB = input.next();

        // Menutup objek scanner setelah selesai
        input.close();

        // 1. Menghitung dan mencetak jumlah panjang string
        // Menggunakan method .length() untuk mendapatkan panjang
        int totalLength = stringA.length() + stringB.length();
        System.out.println(totalLength);

        // 2. Membandingkan string secara leksikografis
        // Menggunakan method .compareTo() untuk perbandingan
        boolean isAGreater = stringA.compareTo(stringB) > 0;
        if (isAGreater) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 3. Mengkapitalisasi huruf pertama dan mencetak
        // Menggunakan substring() dan toUpperCase()
        String capitalizedA = capitalizeFirstLetter(stringA);
        String capitalizedB = capitalizeFirstLetter(stringB);
        System.out.println(capitalizedA + " " + capitalizedB);
    }
    
    /**
     * Metode pembantu untuk mengkapitalisasi huruf pertama dari sebuah string.
     * * @param str string yang akan dikapitalisasi
     * @return string dengan huruf pertama yang dikapitalisasi
     */
    private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}