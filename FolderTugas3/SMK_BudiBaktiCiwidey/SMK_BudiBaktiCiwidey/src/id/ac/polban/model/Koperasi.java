package id.ac.polban.model;

import java.util.List;

public class Koperasi {
    private List<Barang> daftarBarang; // Aggregation
    private long income;

    public Koperasi(List<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
        this.income = 0;
    }

    public List<Barang> getDaftarBarang() { return daftarBarang; }

    public long getIncome() { return income; }

    public void tambahUang(long jumlah) { income += jumlah; }
}
