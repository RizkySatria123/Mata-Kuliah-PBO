package id.ac.polban.model;

/**
 * Superclass abstrak yang merepresentasikan produk umum.
 * Menyimpan atribut yang umum dimiliki semua produk (nama dan harga)
 * serta method "tampilkanInfo" yang dapat dioverride oleh subclass.
 */
public abstract class Produk {
    private String nama;
    private int harga; // harga dalam satuan rupiah

    public Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() { return nama; }
    public int getHarga() { return harga; }

    /**
     * Menampilkan informasi dasar produk.
     * Akan di-override oleh subclass untuk menambahkan detail khusus.
     */
    public abstract void tampilkanInfo();
}
