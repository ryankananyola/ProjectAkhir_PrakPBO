package Controller;

import Model.Transaksi.DAOTransaksi;
import Model.Transaksi.InterfaceDAOTransaksi;
import Model.Transaksi.ModelTabelTransaksi;
import Model.Transaksi.ModelTransaksi;
import View.ProdukUser.RiwayatBeli;
import View.Transaksi.EditDataTransaksi;
import View.Transaksi.InputDataTransaksi;
import View.Transaksi.ViewDataTransaksi;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerTransaksi {
    
    ViewDataTransaksi halamanTabel;
    RiwayatBeli halamanRiwayat;
    InputDataTransaksi halamanInput;
    EditDataTransaksi halamanEdit;
    
    InterfaceDAOTransaksi daoTransaksi;
    
    List<ModelTransaksi> daftarTransaksi;
    
    public ControllerTransaksi(ViewDataTransaksi halamanTabel){
        this.halamanTabel = halamanTabel;
        this.daoTransaksi = new DAOTransaksi();
    }
    
    public ControllerTransaksi(RiwayatBeli halamanRiwayat){
        this.halamanRiwayat = halamanRiwayat;
        this.daoTransaksi = new DAOTransaksi();
    }
    
    public ControllerTransaksi(InputDataTransaksi halamanInput){
        this.halamanInput = halamanInput;
        this.daoTransaksi = new DAOTransaksi();
    }
    
    public ControllerTransaksi(EditDataTransaksi halamanEdit){
        this.halamanEdit = halamanEdit;
        this.daoTransaksi = new DAOTransaksi();
    }
    
    public void showALLTransaksi(){
        daftarTransaksi = daoTransaksi.getAll();
        ModelTabelTransaksi tabel = new ModelTabelTransaksi(daftarTransaksi);
        halamanTabel.getTableTransaksi().setModel(tabel);
    }
    
    public void lihatSemuaRiwayat(){
        daftarTransaksi = daoTransaksi.getAll();
        ModelTabelTransaksi tabel = new ModelTabelTransaksi(daftarTransaksi);
        halamanRiwayat.getTableRiwayat().setModel(tabel);
    }
    
    public void inputTransaksi(){
        try{
            ModelTransaksi transaksiBaru = new ModelTransaksi();
           
            String tanggal = halamanInput.getInputTanggal();
            String nama_produk = halamanInput.getInputNama();
            String jumlah = halamanInput.getInputJumlah();
            String harga = halamanInput.getInputHarga();
            
            if(nama_produk.isEmpty() || jumlah.isEmpty() || harga.isEmpty()) {
                JOptionPane.showMessageDialog(halamanInput, "Semua data harus diisi!");
            }
            
            transaksiBaru.setTanggal(tanggal);
            transaksiBaru.setNama_produk(nama_produk);
            transaksiBaru.setJmlPembelian(Integer.parseInt(jumlah));
            transaksiBaru.setTotalHarga(Integer.parseInt(harga));
            
            daoTransaksi.inputTransaksi(transaksiBaru);
            
            JOptionPane.showMessageDialog(null, "Produk baru berhasil ditambahkan.");
            
            halamanInput.dispose();
            new ViewDataTransaksi();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());    
        }
    }
    
    public void editTransaksi(int no_penjualan){
        try {
            
            ModelTransaksi transaksiYangMauDiedit = new ModelTransaksi();
           
            String tanggal = halamanEdit.getEditTanggal();
            String nama = halamanEdit.getEditNama();
            String jumlah = halamanEdit.getEditJmlPembelian();
            String total = halamanEdit.getEditTotalHarga();
            String status = halamanEdit.getEditStatus();
            
             if ("".equals(tanggal) || "".equals(nama) || "".equals(jumlah) || "".equals(total)) {
                throw new Exception("Data tidak boleh kosong!");
            }
            
            transaksiYangMauDiedit.setNo_penjualan(no_penjualan);
            transaksiYangMauDiedit.setTanggal(tanggal);
            transaksiYangMauDiedit.setNama_produk(nama);
            transaksiYangMauDiedit.setJmlPembelian(Integer.parseInt(jumlah));
            transaksiYangMauDiedit.setTotalHarga(Integer.parseInt(total));
            transaksiYangMauDiedit.setStatus(status);
            
            daoTransaksi.updateTransaksi(transaksiYangMauDiedit);
            
            JOptionPane.showMessageDialog(null, "Data produk berhasil diubah.");
            
            halamanEdit.dispose();
            new ViewDataTransaksi();
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
        }
    }
    
    public void hapusTransaksi(Integer baris){
        Integer no_penjualan = (int) halamanTabel.getTableTransaksi().getValueAt(baris,0);
        String nama_produk = halamanTabel.getTableTransaksi().getValueAt(baris, 2).toString();
        
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama_produk + "?",
                "Hapus Transaksi",
                JOptionPane.YES_NO_OPTION
        );
        
        if (input == 0){
            daoTransaksi.hapusTransaksi(no_penjualan);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus produk.");
            
            showALLTransaksi();
        }
    }
    
    public List<String> getNamaProduk(){
        return daoTransaksi.getNamaProduk();
    }
    
    public int getHargaSatuan(String namaProduk){
        return daoTransaksi.getHargaSatuan(namaProduk);
    }
}
