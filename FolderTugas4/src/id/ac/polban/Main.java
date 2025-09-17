package id.ac.polban;

import id.ac.polban.model.*;
import id.ac.polban.service.AppService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Koperasi koperasi = new Koperasi();

        // Tambahkan beberapa barang fisik
        koperasi.tambahProduk(new Barang("Pulpen", 2000, 100));
        koperasi.tambahProduk(new Barang("Pensil", 2000, 150));
        koperasi.tambahProduk(new Barang("Kertas A4", 500, 10000));
        koperasi.tambahProduk(new Barang("Materai", 10000, 50)); // Barang Fisik
        koperasi.tambahProduk(new Barang("Buku Sidu 54", 4500, 30)); // Barang Fisik

        // Tambahkan produk digital
        koperasi.tambahProduk(new ProdukDigital("Pulsa 10k", 10000));
        koperasi.tambahProduk(new ProdukDigital("Token Listrik 20k", 20000));
        koperasi.tambahProduk(new ProdukDigital("Token Air 20k", 20000)); // Produk Digital
        koperasi.tambahProduk(new ProdukDigital("Wi-Fi Key 2 jam", 5000)); // Produk Digital

        AppService service = new AppService(koperasi);

        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            service.showMenu();
            System.out.print("Pilih menu: ");
            choice = sc.next();
            switch (choice) {
                case "1": service.beliProduk(); break;
                case "2": service.cekIncome(); break;
                case "3": service.tampilkanSemuaProduk(); break;
                case "4": service.tampilkanRiwayat(); break;
                case "5": System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (!"5".equals(choice));

        sc.close();
    }
}
