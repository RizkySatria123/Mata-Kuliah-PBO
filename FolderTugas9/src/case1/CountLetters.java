import java.util.Scanner;

public class CountLetters {
    
    private static final int ALPHABET_SIZE = 26;
    
    public static void main(String[] args) {
        int[] counts = new int[ALPHABET_SIZE];
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a single word (letters only, please): ");
        String word = scan.nextLine();
        
        // Validasi masukan
        if (word == null || word.isEmpty()) {
            System.out.println("No input provided. Exiting.");
            scan.close();
            return;
        }
        
        // Ubah ke huruf besar agar perhitungan tidak sensitif terhadap kapital
        word = word.toUpperCase();
        
        // Simpan karakter tidak valid untuk dilaporkan ke pengguna
        StringBuilder invalidChars = new StringBuilder();
        int validCharCount = 0;
        
        // Proses setiap karakter dengan validasi
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            // Periksa: apakah karakter ini huruf alfabet?
            if (Character.isLetter(currentChar) && currentChar >= 'A' && currentChar <= 'Z') {
                // Aman mengakses array karena dipastikan berada dalam rentang
                counts[currentChar - 'A']++;
                validCharCount++;
            } else {
                // Karakter non-alfabet ditemukan, catat untuk dilaporkan
                if (invalidChars.length() > 0) {
                    invalidChars.append(", ");
                }
                invalidChars.append("'").append(currentChar).append("'");
            }
        }
        
        // Sampaikan umpan balik mengenai karakter tidak valid
        if (invalidChars.length() > 0) {
            System.out.println("\n⚠ Warning: The following non-alphabetic characters were ignored:");
            System.out.println("  " + invalidChars.toString());
        }
        
        // Tampilkan hasil akhir
        System.out.println("\nLetter frequency analysis:");
        System.out.println("-------------------------");
        
        boolean hasLetters = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println((char)(i + 'A') + ": " + counts[i]);
                hasLetters = true;
            }
        }
        
        if (!hasLetters) {
            System.out.println("No alphabetic characters found in the input.");
        } else {
            System.out.println("\nTotal valid letters processed: " + validCharCount);
        }
        
        scan.close();
    }
}

/*
* =============================================================================
 * PERUBAHAN YANG DILAKUKAN:
 * 
 * 1. VALIDASI MASUKAN & PEMROGRAMAN DEFENSIF:
 *    - Menambahkan validasi per karakter untuk mencegah ArrayIndexOutOfBoundsException
 *    - Memakai Character.isLetter() agar pemeriksaan huruf lebih tangguh (mendukung Unicode)
 *    - Melewati karakter non-alfabet tanpa membuat aplikasi berhenti mendadak
 * 
 * 2. PENINGKATAN UMPAN BALIK PENGGUNA:
 *    - Menyampaikan karakter mana saja yang tidak valid secara spesifik
 *    - Menggunakan StringBuilder agar penggabungan teks peringatan lebih efisien
 *    - Menampilkan daftar karakter tidak valid sekaligus sehingga tidak mengganggu alur pengguna
 * 
 * 3. KERAMAHAN KODE TERHADAP KESALAHAN:
 *    - Menangani kemungkinan nilai null secara aman
 *    - Memisahkan logika validasi dan logika perhitungan dengan jelas
 *    - Alur kontrol lebih mudah dibaca karena validasi dilakukan sejak awal
 * 
 * 4. KEPATUHAN TERHADAP PRAKTIK TERBAIK:
 *    - Desain fail-safe: program tetap berjalan, tidak langsung berhenti
 *    - Pesan kesalahan informatif membantu pengguna memperbaiki input
 *    - Tidak ada kegagalan diam-diam, semua anomali dilaporkan
 * 
 * STRATEGI PENANGANAN EKSEPSI:
 *    - Pendekatan preventif: memvalidasi sebelum mengakses array
 *    - Tidak membutuhkan try-catch karena eksepsi sudah dicegah
 *    - Lebih efisien dibanding mengandalkan try-catch
 * 
 * ALASAN MENGAPA LEBIH UNGGUL:
 *    - Menangani kasus pinggiran: string kosong, input null, karakter khusus
 *    - Memberikan umpan balik edukatif kepada pengguna
 *    - Menjaga kestabilan program untuk berbagai kondisi input
 *    - Mengikuti prinsip "fail gracefully" dalam pemrograman defensif
 * =============================================================================
 */