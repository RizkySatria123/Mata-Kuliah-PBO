package id.ac.polban.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaksi {
    private final String namaProduk;
    private final int quantity; // untuk produk digital bisa 1
    private final long total; // total pendapatan transaksi
    private final String kodeLisensi; // null jika bukan produk digital
    private final LocalDateTime waktu;

    public Transaksi(String namaProduk, int quantity, long total, String kodeLisensi, LocalDateTime waktu) {
        this.namaProduk = namaProduk;
        this.quantity = quantity;
        this.total = total;
        this.kodeLisensi = kodeLisensi;
        this.waktu = waktu;
    }

    public String getNamaProduk() { return namaProduk; }
    public int getQuantity() { return quantity; }
    public long getTotal() { return total; }
    public String getKodeLisensi() { return kodeLisensi; }
    public LocalDateTime getWaktu() { return waktu; }

    public String formatRingkas() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fmt.format(waktu) + " | " + namaProduk + " x" + quantity + " | Total: " + total + (kodeLisensi != null ? " | Lic: " + kodeLisensi : "");
    }
}
