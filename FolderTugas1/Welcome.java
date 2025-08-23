// File: FolderTugas1/Welcome.java
// Deskripsi: Program Java sederhana untuk menampilkan pesan selamat datang dengan garis pemisah
// Pembuat: Rizky Satria Gunawan
public class Welcome {
    public static void main(String[] args) {
    String greeting = "Welcome to Core Java";
    System.out.println(greeting);

    for (int i = 0; i < greeting.length(); i++) {
      System.out.print("=");
    }
    System.out.println();
  }
}

