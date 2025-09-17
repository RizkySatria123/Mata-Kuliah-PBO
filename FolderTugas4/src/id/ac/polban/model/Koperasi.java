package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

public class Koperasi {
    private List<Produk> daftarProduk; // menampung semua jenis produk
    private List<Transaksi> riwayatTransaksi; // catatan transaksi
    private long income;

    public Koperasi() {
        this.daftarProduk = new ArrayList<>();
        this.riwayatTransaksi = new ArrayList<>();
        this.income = 0;
    }

    public void tambahProduk(Produk p) { daftarProduk.add(p); }

    public List<Produk> getDaftarProduk() { return daftarProduk; }

    public long getIncome() { return income; }

    public void tambahUang(long jumlah) { income += jumlah; }

    public void tambahTransaksi(Transaksi t) { riwayatTransaksi.add(t); }

    public List<Transaksi> getRiwayatTransaksi() { return riwayatTransaksi; }
}
