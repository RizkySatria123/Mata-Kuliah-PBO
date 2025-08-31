import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static Scanner sc;
    private static koperasi koperasi;

    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = buatDaftarBarang();
        koperasi = new koperasi(daftarBarang);

        sc = new Scanner(System.in);

        String choice;

        do {
            showMenu();
            choice = getInput();

            switch (choice) {
                case "1":
                    beliBarang();
                    break;
                case "2":
                    cekIncome();
                    break;
                case "3":
                    // 1. Tambahkan pesan keluar yang ramah
                    System.out.println("Terima kasih telah menggunakan Koperasi Desa Ciwidey!");
                    // 2. Tambahkan break untuk menghentikan switch di sini
                    break;
                default:
                    // 3. (Opsional) Buat pesan default lebih jelas
                    System.out.println("Pilihan tidak valid. Silakan coba lagi!");
            }

        } while (!choice.equals("3"));

        sc.close();
    }

    private static void cekIncome() {
        long Income = koperasi.getIncome();

        System.out.println("Pemasukan Koperasi Sejumlah Rp" + Income);
    }

    private static void beliBarang() {
        ArrayList<Barang> daftarBarang = koperasi.getDaftarBarang();
        int i = 1;

        for (Barang barang : daftarBarang) {
            System.out.print("[" + i++ + "] " + barang.getNama());
            System.out.print("\t(Rp" + barang.getHarga() + ")\n");
        }

        System.out.print("Pilih Item Yang Ingin Dibeli: ");
        int choiceIndex = sc.nextInt();

        sc.nextLine();

        try {
            System.out.print("quantity: ");
            int quantity = sc.nextInt();

            sc.nextLine();

            Barang barang = daftarBarang.get(choiceIndex - 1);

            if (quantity > barang.getStok()) {
                System.out.println("Stok barang tidak mencukupi!");
                return;
            }

            koperasi.tambahUang(barang.getHarga() * quantity);
            barang.kurangiStok(quantity);

            System.out.println("Barang Berhasil Dibeli Seharga Rp" + barang.getHarga() * quantity);

        } catch (Exception e) {
            System.out.println("Barang Tidak Ditemukan!");
        }
    }

    private static void showMenu() {
        System.out.println("--- Koperasi Desa Ciwidey ---");
        System.out.println("[1] Beli Barang");
        System.out.println("[2] Cek Income");
        System.out.println("[3] Keluar");
    }

    private static ArrayList<Barang> buatDaftarBarang() {
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

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

        return daftarBarang;
    }

    private static String getInput() {
        System.out.print("Pilih menu: ");

        return sc.next();
    }

}