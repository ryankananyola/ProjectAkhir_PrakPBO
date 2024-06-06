package Model.Transaksi;

import java.util.List;

public interface InterfaceDAOTransaksi {
    public void inputTransaksi(ModelTransaksi transaksi);
    
    public void updateTransaksi(ModelTransaksi transaksi);
    
    public void hapusTransaksi(int no_penjualan);
    
    public List<ModelTransaksi> getAll();
    
    public List<String>getNamaProduk();
    
    public int getHargaSatuan(String namaProduk);
}
