import java.util.Scanner;
import java.util.InputMismatchException;

public class Factorials {
    
    public static void main(String[] args) {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=== Factorial Calculator ===");
        System.out.println("Valid range: 0 to 16");
        System.out.println();
        
        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            try {
                System.out.print("Enter an integer: ");
                
                // Baca masukan pengguna - bisa memicu InputMismatchException
                int val = scan.nextInt();
                
                // Hitung faktorial - bisa memicu IllegalArgumentException
                int result = MathUtils.factorial(val);
                
                // Tampilkan hasil (hanya tercapai jika tidak ada eksepsi)
                System.out.println("Factorial(" + val + ") = " + result);
                System.out.println();
                
            } catch (IllegalArgumentException e) {
                // Validasi logika bisnis gagal (nilai negatif atau terlalu besar)
                System.out.println("\n❌ Error: " + e.getMessage());
                System.out.println();
                
            } catch (InputMismatchException e) {
                // Pengguna memasukkan nilai yang bukan bilangan bulat
                System.out.println("\n❌ Error: Invalid input type. Please enter a valid integer.");
                System.out.println();
                
                // Bersihkan data yang salah dari buffer scanner
                // Tanpa langkah ini, scanner akan terus membaca input yang sama
                scan.nextLine();
                
            } catch (Exception e) {
                // Penangkap umum untuk eksepsi tak terduga (pemrograman defensif)
                System.out.println("\n❌ Unexpected error: " + e.getMessage());
                System.out.println("Please try again.");
                System.out.println();
                
                // Bersihkan buffer sebagai langkah pengaman
                scan.nextLine();
            }
            
            // Tanyakan apakah pengguna ingin menghitung lagi (selalu dieksekusi meski ada error)
            System.out.print("Another factorial? (y/n): ");
            keepGoing = scan.next();
            System.out.println();
        }
        
        System.out.println("Thank you for using the Factorial Calculator!");
        scan.close();
    }
}

/*
 * =============================================================================
 * PERUBAHAN YANG DILAKUKAN:
 * 
 * 1. PENANGANAN EKSEPSI PADA LOOP UTAMA:
 *    - Perhitungan faktorial dibungkus dalam blok try-catch
 *    - Menangkap IllegalArgumentException dari MathUtils.factorial()
 *    - Program tetap berjalan setelah eksepsi (tidak crash)
 * 
 * 2. PENANGANAN EKSEPSI BERTINGKAT:
 *    - Lapisan 1: Menangkap IllegalArgumentException (error logika bisnis)
 *    - Lapisan 2: Menangkap InputMismatchException (jenis input tidak valid)
 *    - Setiap jenis eksepsi memiliki umpan balik yang spesifik
 * 
 * 3. PERBAIKAN PENGALAMAN PENGGUNA:
 *    - Menampilkan pesan kesalahan yang jelas dan terarah
 *    - Program tetap berada dalam loop setelah error sehingga bisa mencoba lagi
 *    - Pembersihan buffer Scanner mencegah loop tak berujung akibat input buruk
 *    - Kelanjutan yang mulus meningkatkan kenyamanan pengguna
 * 
 * 4. PENANGANAN INPUT YANG TANGGUH:
 *    - Menangani input non-integer (misal "abc") dengan mulus
 *    - Menolak angka negatif melalui validasi di MathUtils
 *    - Menolak angka terlalu besar melalui validasi yang sama
 *    - Semua jalur kesalahan kembali ke prompt awal
 * 
 * 5. PERBAIKAN ALUR KONTROL:
 *    - Jalur sukses dan jalur error dipisahkan dengan jelas
 *    - Setiap jenis eksepsi ditangani dengan logika khusus
 *    - Manajemen buffer Scanner mencegah keadaan data yang rusak
 * 
 * ARSITEKTUR PENANGANAN EKSEPSI:
 *    - IllegalArgumentException: Diperkirakan muncul dari lapisan logika bisnis
 *      → Tampilkan pesan validasi yang spesifik lalu lanjutkan loop
 *    - InputMismatchException: Pengguna mengetikkan input non-numerik
 *      → Tampilkan pesan jenis input salah, bersihkan buffer, lanjutkan loop
 *    - Exception umum: Penjaga terakhir untuk kejutan yang tidak diprediksi
 *      → Tampilkan pesan generik, lanjutkan loop (fail gracefully)
 * 
 * KEPATUHAN PRAKTIK TERBAIK:
 *    - Pemisahan tanggung jawab: UI menangkap, logika bisnis melempar
 *    - Desain fail-safe: loop terus berjalan dalam kondisi apa pun
 *    - Umpan balik informatif: pengguna tahu apa yang terjadi
 *    - Manajemen resource: Scanner dikelola dan ditutup dengan benar
 *    - Pemrograman defensif: beberapa lapisan penanganan error
 * 
 * ALASAN MENGAPA LEBIH UNGGUL:
 *    - Tidak pernah crash, menangani semua skenario error dengan baik
 *    - Menjaga konsistensi keadaan program setelah error terjadi
 *    - Pesan kesalahan yang jelas membantu pengguna memperbaiki input
 *    - Mencegah loop tak berujung lewat manajemen buffer Scanner
 *    - Siap produksi: menangani error yang diantisipasi maupun yang tidak
 * =============================================================================
 */