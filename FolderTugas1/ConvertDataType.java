// File: FolderTugas1/ConvertDataType.java
// Deskripsi: Program Java untuk mengonversi tipe data dengan casting
// Pembuat: Rizky Satria Gunawan

public class ConvertDataType {
  static short methodOne(long l) {
    int i = (int) l;
    return (short) i;
  }
  public static void main(String[] args) {
    double d = 10.25;
    float f = (float) d;
    byte b = (byte) methodOne((long) f);
    System.out.println(b);
  }
} 
    

// Operators 1
//
// Program berikut melakukan convert tipe data yang berukuran besar ke kecil
// (long -> int ->
// short) dan (double -> float -> byte).
// 1. Jelaskan output nilai dari variable b.
// Jawab: Output nilai dari variabel b adalah 10. Proses konversi tipe data dimulai dengan nilai double 10.25 yang dikonversi menjadi float,
// menghasilkan nilai float 10.25. Kemudian, nilai float ini dikonversi menjadi long melalui casting, yang menghasilkan nilai long 10 (karena bagian desimal dihilangkan).
//
// 2. Jelaskan apa yang berubah dari variable d menjadi variable b setelah
// dilakukan cast? variabel d berubah saat memanggil methodOne dengan parameter
// f yang dicasting ke long sehingga keluaran menjadi bilangan bulat. methodOne
// mengonversi long ke int lalu ke short tidak mengubah nilai
// Jawab: Perubahan dari variabel d ke variabel b terjadi melalui beberapa tahap konversi tipe data:
// - Variabel d awalnya bertipe double dengan nilai 10.25.
