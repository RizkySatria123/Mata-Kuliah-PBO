package id.ac.polban.service;

import id.ac.polban.model.*;
import java.util.Scanner;

public class AppService {
    private Scanner sc = new Scanner(System.in);
    private Koperasi koperasi;

    public AppService(Koperasi koperasi) { // Dependency
        this.koperasi = koperasi;
    }

    public void showMenu() {
        System.out.println("--- Koperasi Desa Ciwidey ---");
        System.out.println("[1] Beli Barang");
        System.out.println("[2] Cek Income");
        System.out.println("[3] Keluar");
    }

    public void beliBarang() {
        int i = 1;
        for (Barang barang : koperasi.getDaftarBarang()) {
            System.out.println("[" + i++ + "] " + barang.getNama() + " (Rp" + barang.getHarga() + ")");
        }
        System.out.print("Pilih item: ");
        int idx = sc.nextInt();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        Barang barang = koperasi.getDaftarBarang().get(idx - 1);
        if (qty > barang.getStok()) {
            System.out.println("Stok barang tidak mencukupi!");
            return;
        }
        koperasi.tambahUang(barang.getHarga() * qty);
        barang.kurangiStok(qty);
        System.out.println("Berhasil beli " + qty + " " + barang.getNama());
    }

    public void cekIncome() {
        System.out.println("Pemasukan koperasi: Rp" + koperasi.getIncome());
    }
}
