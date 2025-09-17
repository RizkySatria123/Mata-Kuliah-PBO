# Mata Kuliah PBO
Untuk Mengumpulan tugas PBO

Nama   : Rizky Satria Gunawan

NIM    : 241511089

Kelas  : 2C

[FolderTugas1](./FolderTugas1)
[FolderTugas2](./FolderTugas2)
[FolderTugas3](./FolderTugas3)
[FolderTugas4](./FolderTugas4)

## FolderTugas4 - Implementasi OOP (Inheritance, Override, super)

Pada folder ini dibuat simulasi sederhana Koperasi yang menjual dua jenis produk:

1. Barang (produk fisik dengan stok)
2. ProdukDigital (produk non-fisik tanpa stok, contoh: Pulsa, Token Listrik)

Struktur kelas yang diterapkan:

```
Produk (abstract)
 ├── Barang
 └── ProdukDigital
```

Penjelasan konsep:

- Inheritance: `Barang` dan `ProdukDigital` mewarisi atribut `nama` dan `harga` dari superclass abstrak `Produk`.
- super: Konstruktor subclass memanggil konstruktor superclass `Produk` menggunakan `super(nama, harga);`.
- Method Overriding: Method `tampilkanInfo()` didefinisikan di `Produk` lalu dioverride di masing-masing subclass untuk menampilkan detail spesifik.
- Polymorphism: List di kelas `Koperasi` bertipe `List<Produk>` sehingga dapat menampung objek dari kedua subclass dan diproses secara umum.
- instanceof: Digunakan di `AppService` untuk membedakan perilaku pembelian produk fisik (cek & kurangi stok) dan produk digital (generate kode lisensi tanpa stok).

Contoh output (ilustrasi):

```
--- Koperasi (Versi Produk Fisik & Digital) ---
[1] Beli Produk
[2] Cek Income
[3] Tampilkan Semua Produk
[4] Keluar
Pilih menu: 3
[1] Barang Fisik: Pulpen | Harga: Rp2000 | Stok: 100
[2] Barang Fisik: Pensil | Harga: Rp2000 | Stok: 150
[3] Barang Fisik: Kertas A4 | Harga: Rp500 | Stok: 10000
[4] Produk Digital: Pulsa 10k | Harga: Rp10000
[5] Produk Digital: Token Listrik 20k | Harga: Rp20000
```

Pembelian produk digital akan menghasilkan kode lisensi acak (UUID 8 karakter pertama).

### Update Lanjutan (Abstract Method & Interface)

Perubahan tambahan sesuai pengembangan lanjutan:

1. Method `tampilkanInfo()` pada `Produk` kini bersifat `abstract`, memaksa setiap subclass untuk menyediakan implementasinya (menegaskan konsep polymorphism dan kontrak perilaku).
2. Ditambahkan interface `DapatDijual` dengan method `hitungPendapatan(int qty)` yang diimplementasikan oleh `Barang` dan `ProdukDigital`.
	- `Barang.hitungPendapatan(qty)` mengalikan harga dengan jumlah.
	- `ProdukDigital.hitungPendapatan(qty)` mengembalikan harga satuan (qty diabaikan).
3. `AppService` sekarang menghitung pemasukan menggunakan interface tersebut, bukan logika manual terpisah.

Manfaat perubahan:
* Memisahkan kontrak penjualan dari detail kelas produk.
* Memudahkan penambahan jenis produk baru (cukup implement `DapatDijual`).
* Meningkatkan fleksibilitas dan konsistensi OOP.

### Fitur Tambahan: Format Rupiah & Riwayat Transaksi

Penambahan lebih lanjut untuk meningkatkan aspek praktis aplikasi:

1. Utility `FormatUtil` untuk memformat nilai menjadi format Rupiah (contoh: `Rp10.000`).
2. Kelas `Transaksi` menyimpan data: nama produk, quantity, total, kode lisensi (opsional untuk produk digital), dan timestamp.
3. `Koperasi` kini menyimpan `List<Transaksi>` sebagai riwayat dan menyediakan aksesnya.
4. `AppService` menambah menu "Riwayat Transaksi" dan mencatat setiap pembelian dalam riwayat.
5. Output pembelian dan income kini memakai format Rupiah yang lebih mudah dibaca.

Contoh riwayat (ilustrasi):
```
--- Riwayat Transaksi ---
2025-09-17 10:15:23 | Pulpen x2 | Total: 4000
2025-09-17 10:16:05 | Pulsa 10k x1 | Total: 10000 | Lic: A1B2C3D4
```


