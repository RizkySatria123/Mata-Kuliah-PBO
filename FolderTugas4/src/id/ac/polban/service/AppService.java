package id.ac.polban.service;

import id.ac.polban.model.*;
import id.ac.polban.util.FormatUtil;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AppService {
    private Scanner sc = new Scanner(System.in);
    private Koperasi koperasi;

    public AppService(Koperasi koperasi) {
        this.koperasi = koperasi;
    }

    public void showMenu() {
        System.out.println("--- Koperasi (Versi Produk Fisik & Digital) ---");
        System.out.println("[1] Beli Produk");
        System.out.println("[2] Cek Income");
        System.out.println("[3] Tampilkan Semua Produk");
        System.out.println("[4] Riwayat Transaksi");
        System.out.println("[5] Keluar");
    }

    public void tampilkanSemuaProduk() {
        int i = 1;
        for (Produk p : koperasi.getDaftarProduk()) {
            System.out.print("[" + i++ + "] ");
            p.tampilkanInfo();
        }
    }

    public void tampilkanRiwayat() {
        if (koperasi.getRiwayatTransaksi().isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        System.out.println("--- Riwayat Transaksi ---");
        for (Transaksi t : koperasi.getRiwayatTransaksi()) {
            System.out.println(t.formatRingkas());
        }
    }

    public void beliProduk() {
        if (koperasi.getDaftarProduk().isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }
        tampilkanSemuaProduk();
        System.out.print("Pilih produk: ");
        int idx = sc.nextInt();
        if (idx < 1 || idx > koperasi.getDaftarProduk().size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }
        Produk dipilih = koperasi.getDaftarProduk().get(idx - 1);

        if (!(dipilih instanceof DapatDijual)) {
            System.out.println("Produk tidak dapat dijual.");
            return;
        }

        int qty = 1;
        String kode = null;
        long pendapatan;

        if (dipilih instanceof Barang) {
            Barang barang = (Barang) dipilih;
            System.out.print("Quantity: ");
            qty = sc.nextInt();
            if (qty <= 0) {
                System.out.println("Quantity harus > 0");
                return;
            }
            if (qty > barang.getStok()) {
                System.out.println("Stok tidak mencukupi!");
                return;
            }
            pendapatan = ((DapatDijual) barang).hitungPendapatan(qty);
            barang.kurangiStok(qty);
            System.out.println("Berhasil beli " + qty + " x " + barang.getNama() + " (Total: " + FormatUtil.rupiah(pendapatan) + ")");
        } else if (dipilih instanceof ProdukDigital) {
            ProdukDigital pd = (ProdukDigital) dipilih;
            pendapatan = ((DapatDijual) pd).hitungPendapatan(1);
            kode = pd.generateKodeLisensi();
            System.out.println("Berhasil beli produk digital: " + pd.getNama() + " (" + FormatUtil.rupiah(pendapatan) + ")");
            System.out.println("Kode Lisensi: " + kode);
        } else {
            System.out.println("Jenis produk tidak dikenali.");
            return;
        }

        koperasi.tambahUang(pendapatan);
        koperasi.tambahTransaksi(new Transaksi(dipilih.getNama(), qty, pendapatan, kode, LocalDateTime.now()));
    }

    public void cekIncome() {
        System.out.println("Pemasukan koperasi: " + FormatUtil.rupiah(koperasi.getIncome()));
    }
}
