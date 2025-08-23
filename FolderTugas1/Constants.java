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
//
// 1. Bagaimana output dari masing masing class Constants dan Constants2
// jawab: Output sama, yaitu: `Paper size in centimeters: 21.59 by 27.94`
// Kedua kelas menghasilkan output yang sama karena meskipun cara mendeklarasikan konstanta CM_PER_INCH berbeda, 
// nilainya tetap sama (2.54) dan digunakan dalam perhitungan yang identik.
//
// 2. Apa perbedaan penggunaan final double dengan public static final double?
// jawab: Perbedaan utama antara `final double` dan `public static final double` terletak pada cakupan akses dan sifat variabel tersebut.
// - `final double` mendeklarasikan variabel sebagai konstanta yang nilainya tidak dapat diubah setelah inisialisasi, tetapi variabel ini bersifat instance-level,
//   yang berarti setiap instance dari kelas memiliki salinan sendiri dari variabel tersebut.
// - `public static final double` mendeklarasikan variabel sebagai konstanta yang juga tidak dapat diubah, tetapi variabel ini bersifat class-level (static),
//   yang berarti hanya ada satu salinan variabel tersebut yang dibagikan di antara semua instance dari kelas. Selain itu, karena variabel ini bersifat public,
//   ia dapat diakses dari luar kelas.