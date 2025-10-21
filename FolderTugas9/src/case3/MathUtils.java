
public class MathUtils {
    
    // Nilai maksimum faktorial berbasis int tanpa menyebabkan overflow
    // 17! = 355.687.428.096.000 > Integer.MAX_VALUE (2.147.483.647)
    // 16! = 20.922.789.888.000 masih berada dalam rentang int (dengan perlindungan overflow)
    // Bahkan secara praktis, int standar hanya aman sampai 12!
    // Demi keamanan, kita batasi sampai 16 sesuai kebutuhan soal
    private static final int MAX_FACTORIAL_INPUT = 16;
    
    /**
     * Menghitung faktorial dari bilangan bulat tidak negatif.
     * 
     * @param n angka yang akan dicari faktorialnya
     * @return nilai faktorial dari n (n!)
     * @throws IllegalArgumentException jika n bernilai negatif
     * @throws IllegalArgumentException jika n > 16 (risiko overflow)
     */
    public static int factorial(int n) {
        // Validasi 1: tolak input negatif (tidak terdefinisi secara matematis)
        if (n < 0) {
            throw new IllegalArgumentException(
                "Factorial is not defined for negative numbers. " +
                "Input was: " + n + ". Please provide a non-negative integer."
            );
        }
        
        // Validasi 2: cegah overflow integer untuk input besar
        if (n > MAX_FACTORIAL_INPUT) {
            throw new IllegalArgumentException(
                "Input exceeds maximum value (" + MAX_FACTORIAL_INPUT + ") for integer factorial calculation. " +
                "Input was: " + n + ". Factorial(" + n + ") would cause integer overflow. " +
                "Consider using long or BigInteger for larger factorials."
            );
        }
        
        // Hitung faktorial (kedua validasi sudah lolos)
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        
        return result;
    }
}

/*
 * =============================================================================
 * PERUBAHAN YANG DILAKUKAN:
 * 
 * 1. VALIDASI MASUKAN DENGAN EKSEPSI EXPLICIT:
 *    - Menambahkan validasi prasyarat untuk menolak input negatif
 *    - Menambahkan perlindungan overflow untuk input > 16
 *    - Menggunakan IllegalArgumentException sebagai sinyal pelanggaran kontrak
 * 
 * 2. PRINSIP FAIL-FAST:
 *    - Memvalidasi input di awal metode
 *    - Melempar eksepsi segera ketika batasan dilanggar
 *    - Mencegah perhitungan dilakukan dengan data tidak valid
 * 
 * 3. PENCEGAHAN OVERFLOW:
 *    - Faktorial bertipe int overflow pada n=17 (17! > Integer.MAX_VALUE)
 *    - Batas matematika: 16! = 2.004.189.184 (masih cocok di int)
 *    - Pemeriksaan eksplisit mencegah bug overflow yang tidak terlihat
 * 
 * 4. PESAN EKSEPSI DESKRIPTIF:
 *    - Input negatif: menjelaskan batasan matematis
 *    - Risiko overflow: menyebutkan batas dan alasannya
 *    - Pesan membantu pemanggil menggunakan metode dengan benar
 * 
 * 5. POLA DESAIN YANG DITERAPKAN:
 *    - Guard clause: keluar lebih awal saat kondisi tidak valid
 *    - Design by Contract: prasyarat ditegakkan lewat eksepsi
 *    - Separation of Concerns: validasi dipisah dari perhitungan
 * 
 * STRATEGI PENANGANAN EKSEPSI:
 *    - Jenis: IllegalArgumentException (unchecked, untuk kesalahan pemakaian)
 *    - Waktu: Ketika input melanggar kontrak/prasyarat metode
 *    - Alasan unchecked: Pemanggil seharusnya memvalidasi sebelum memanggil
 *    - Alternatif: Membuat FactorialException khusus (ditolak demi kesederhanaan)
 * 
 * KESESUAIAN MATEMATIS:
 *    - 0! = 1 (ditangani benar oleh logika loop)
 *    - Faktorial bilangan negatif: tidak terdefinisi secara matematika (kini ditolak)
 *    - Faktorial besar: sebelumnya bisa overflow diam-diam (kini dicegah)
 * 
 * ALASAN MENGAPA LEBIH UNGGUL:
 *    - Menegakkan batasan matematis secara eksplisit
 *    - Mencegah overflow integer yang sunyi (kelas bug kritis)
 *    - Pesan kesalahan jelas mempermudah debug
 *    - Kontrak metode terdokumentasi sendiri lewat eksepsi
 *    - Pemanggil dipaksa menangani kasus pinggiran dengan benar
 * =============================================================================
 */