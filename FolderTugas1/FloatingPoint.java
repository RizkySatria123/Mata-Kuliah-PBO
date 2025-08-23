// File: FolderTugas1/FloatingPoint.java
// Deskripsi: Program Java untuk menentukan tipe data yang dapat menampung angka yang diberikan
// Pembuat: Rizky Satria Gunawan
class FloatingPoint {
  public static void main(String[] args) {
    double x = 92.98;
    int nx = (int) Math.round(x);

    System.out.println(nx);
  }
}

// Operators
//
// Math Class berisi bermacam-macam fungsi matematika seperti pada contoh diatas
// pada penggunaan round(x), terdapat beberapa pertanyaan yang perlu untuk
// dijelaskan:
// 1. Pada kasus berikut jelaskan nilai nx setelah digunakan Math.round(x)?
// Jawab: Nilai nx setelah digunakan Math.round(x) adalah 93. Fungsi Math.round(x) membulatkan nilai x (92.98) ke bilangan bulat terdekat,
// sehingga hasilnya adalah 93. Kemudian, hasil ini dikonversi menjadi tipe data int dan disimpan dalam variabel nx.
//
// 2. Kenapa dibutuhkan cast (int) dalam penggunaan Math.round(x)?
// Jawab: Dibutuhkan cast (int) dalam penggunaan Math.round(x) karena fungsi Math.round(x) mengembalikan nilai bertipe long.
// Untuk menyimpan nilai ini ke dalam variabel bertipe int (nx), perlu dilakukan konversi tipe data (casting) dari long ke int.