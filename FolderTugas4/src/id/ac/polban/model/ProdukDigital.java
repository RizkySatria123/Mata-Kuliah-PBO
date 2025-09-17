package id.ac.polban.model;

import java.util.UUID;

/**
 * Produk non-fisik (digital) yang tidak memiliki stok.
 * Memiliki atribut kodeLisensi yang bisa digenerate saat pembelian.
 */
public class ProdukDigital extends Produk implements DapatDijual {
    private String kodeLisensi; // diisi saat pembelian

    public ProdukDigital(String nama, int harga) {
        super(nama, harga);
    }

    /**
     * Generate kode lisensi baru (simulasi) dan set ke field.
     * @return kode lisensi yang baru dibuat.
     */
    public String generateKodeLisensi() {
        this.kodeLisensi = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return this.kodeLisensi;
    }

    public String getKodeLisensi() { return kodeLisensi; }

    @Override
    public void tampilkanInfo() {
        System.out.println("Produk Digital: " + getNama() + " | Harga: Rp" + getHarga());
    }

    @Override
    public long hitungPendapatan(int qty) {
        // qty diabaikan karena selalu 1 per transaksi
        return getHarga();
    }
}
