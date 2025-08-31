import java.util.ArrayList;
import java.util.Collection;

public class koperasi {
  private long Income;
  private ArrayList<Barang> daftarBarang;

  public koperasi(Collection<Barang> daftarBarang) {
    this.daftarBarang = new ArrayList<Barang>();
    this.daftarBarang.addAll(daftarBarang);
  }

  public long getIncome() {
    return Income;
  }

  public void tambahUang(long Income) {
    this.Income += Income;
  }

  public ArrayList<Barang> getDaftarBarang() {
    return daftarBarang;
  }

  public void tambahBarang(Barang barang) {
    daftarBarang.add(barang);
  }

  public void hapusBarang(int indexBarang) {
    daftarBarang.remove(indexBarang);
  }
}