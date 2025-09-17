package id.ac.polban.model;

/**
 * Barang fisik yang memiliki stok.
 */
public class Barang extends Produk implements DapatDijual {
    private int stok;

    public Barang(String nama, int harga, int stok) {
        super(nama, harga); // memanggil konstruktor superclass Produk
        this.stok = stok;
    }

    public int getStok() { return stok; }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Barang Fisik: " + getNama() + " | Harga: Rp" + getHarga() + " | Stok: " + stok);
    }

    @Override
    public long hitungPendapatan(int qty) {
        return (long) getHarga() * qty;
    }
}
