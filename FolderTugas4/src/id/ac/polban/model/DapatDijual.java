package id.ac.polban.model;

/**
 * Interface yang mendefinisikan perilaku umum produk yang bisa dijual.
 */
public interface DapatDijual {
    /**
     * Menghitung pendapatan (dalam rupiah) dari penjualan sejumlah qty.
     * Untuk produk digital qty bisa diabaikan (anggap selalu 1 per transaksi).
     */
    long hitungPendapatan(int qty);
}
