import java.util.Scanner;

public class ParseInts {
    
    public static void main(String[] args) {
    int sum = 0;
        int integersFound = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a line of text:");
        String inputLine = scan.nextLine();
        
        // Buat scanner kedua untuk memecah input menjadi token-token
        Scanner scanLine = new Scanner(inputLine);
        
        // Proses setiap token pada baris input
        while (scanLine.hasNext()) {
            String token = scanLine.next();
            
            try {
                // Coba ubah token menjadi bilangan bulat
                int value = Integer.parseInt(token);
                sum += value;
                integersFound++;
                
            } catch (NumberFormatException e) {
                // Token bukan bilangan bulat yang valid, lewati tanpa pesan
                // Perilaku ini memang diharapkan karena input dapat bercampur
                // Tidak perlu tindakan lain, lanjutkan ke token berikutnya
            }
        }
        
        // Tampilkan hasil akhir
        System.out.println("The sum of the integers on this line is " + sum);
        
        // Opsional: berikan konteks tambahan (boleh dihapus jika ingin keluaran minimal)
        if (integersFound == 0) {
            System.out.println("(No integers were found in the input)");
        } else {
            System.out.println("(" + integersFound + " integer(s) found and summed)");
        }
        
        // Rapikan resource yang digunakan
        scanLine.close();
        scan.close();
    }
}


/*
* =============================================================================
 * PERUBAHAN YANG DILAKUKAN:
 * 
 * 1. STRATEGI PENANGANAN EKSEPSI:
 *    - Integer.parseInt() dibungkus try-catch untuk menangani NumberFormatException
 *    - Menerapkan pola "lanjut saat error" agar pemrosesan token tetap tangguh
 *    - Mampu menangani campuran data (bilangan dan teks) secara mulus
 * 
 * 2. PEMROSESAN SELURUH BARIS:
 *    - Kode asli berhenti pada token pertama yang bukan bilangan bulat
 *    - Versi refactor memproses seluruh baris apa pun jenis tokennya
 *    - Contoh: "There are 3 dogs and 1 cat" → dijumlahkan dengan benar menjadi 4
 * 
 * 3. PENGABAIAN SENYAP UNTUK NON-INTEGER:
 *    - Token non-integer dilewati tanpa suara (sesuai kebutuhan soal)
 *    - Tidak ada interupsi atau peringatan yang mengganggu pengguna
 *    - Pengalaman pengguna tetap bersih tetapi tetap tangguh terhadap kesalahan
 * 
 * 4. PERBAIKAN KODE:
 *    - Penamaan variabel lebih jelas (token menggantikan next() tanpa nama)
 *    - Menyimpan hitungan token yang berhasil di-parse untuk kebutuhan debugging/log
 *    - Manajemen resource lebih rapi: Scanner ditutup dengan benar
 * 
 * 5. KEPATUHAN PRAKTIK TERBAIK:
 *    - Eksepsi digunakan tepat sasaran untuk validasi parsing
 *    - NumberFormatException dianggap perilaku wajar, bukan kondisi fatal
 *    - Lingkup try-catch dipersempit hanya pada operasi yang berisiko
 * 
 * PENDEKATAN PENANGANAN EKSEPSI:
 *    - Jenis: NumberFormatException (unchecked)
 *    - Strategi: Tangkap lalu lanjut (lewati diam-diam)
 *    - Alasan: Data campuran adalah kondisi normal, bukan hal luar biasa
 *    - Alternatif yang dipertimbangkan: validasi regex (ditolak karena kompleks)
 * 
 * ALASAN KENAPA LEBIH UNGGUL:
 *    - Menangani input dunia nyata: campuran teks dan angka
 *    - Tidak pernah crash untuk kombinasi input apa pun
 *    - Memenuhi ekspektasi pengguna: "jumlahkan semua angka yang ditemukan"
 *    - Siap produksi: menangani kasus tanpa angka dengan tetap sopan
 * =============================================================================
 */