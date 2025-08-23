// File: FolderTugas1/Constants.java
// Deskripsi: Program Java untuk mengonversi ukuran kertas dari inci ke sentimeter
// Pembuat: Rizky Satria Gunawan

public class Constants {
  public static void main(String[] args) {
    final double CM_PER_INCH = 2.54;

    double paperWidth = 8.5;
    double paperHeight = 11;

    System.out.println("Paper size in centimeters: " + paperWidth *
        CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
  }
}

// Tugas 1 soal no 2
// soal 1
// Variables 1
// 
// Dari 2 contoh baris program diatas, jawablah pertanyaan dibawah ini:? 
// Bagaimana output dari masing masing class Constants dan Constants2
// jawab: Output sama, yaitu: `Paper size in centimeters: 21.59 by 27.94`
// Kedua kelas menghasilkan output yang sama karena meskipun cara mendeklarasikan konstanta CM_PER_INCH berbeda, 
// nilainya tetap sama (2.54) dan digunakan dalam perhitungan yang identik.
//
//