package id.ac.polban;

import id.ac.polban.service.AppService;
import id.ac.polban.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Pulpen", 2000, 100));
        daftarBarang.add(new Barang("Pensil", 2000, 150));
        daftarBarang.add(new Barang("Kertas A4", 500, 10000));
        daftarBarang.add(new Barang("Penghapus", 1000, 100));
        daftarBarang.add(new Barang("Spidol", 5000, 100));
        daftarBarang.add(new Barang("Materai", 10000, 200));
        daftarBarang.add(new Barang("Penggaris", 2500, 75));
        daftarBarang.add(new Barang("Serutan", 1500, 50));
        daftarBarang.add(new Barang("Stapler", 10000, 40));
        daftarBarang.add(new Barang("Lem Kertas", 4000, 60));

        Koperasi koperasi = new Koperasi(daftarBarang);
        AppService service = new AppService(koperasi);

        String choice;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        do {
            service.showMenu();
            System.out.print("Pilih menu: ");
            choice = sc.next();
            switch (choice) {
                case "1": service.beliBarang(); break;
                case "2": service.cekIncome(); break;
                case "3": System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (!choice.equals("3"));

        sc.close();
    }
}
