package Controller;

import Model.ProdukUser.DAOProdukUser;
import Model.ProdukUser.InterfaceDAOProdukUser;
import Model.ProdukUser.ModelBeliUser;
import Model.ProdukUser.ModelProdukUser;
import View.ProdukUser.BeliByUser;
import View.ProdukUser.ViewDataProdukUser;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerProdukUser {
    ViewDataProdukUser halamanTabel;
    BeliByUser halamanInput;
            
    InterfaceDAOProdukUser daoProdukUser;

    List<ModelProdukUser> daftarProduk;
    
    public ControllerProdukUser(ViewDataProdukUser halamanTabel) {
        this.halamanTabel = halamanTabel;
        this.daoProdukUser = new DAOProdukUser();
        this.daftarProduk = daoProdukUser.getAll();
    }
    
    public ControllerProdukUser(BeliByUser halamanInput) {
        this.halamanInput = halamanInput;
        this.daoProdukUser = new DAOProdukUser();
        this.daftarProduk = daoProdukUser.getAll();
    }
    
    public void showAllProduk() {
        daftarProduk = daoProdukUser.getAll();
        updateTableModelUser(daftarProduk);
    }
    
    public void BeliProduk() {
        try {
            ModelBeliUser beliBaru = new ModelBeliUser();

            String tanggal = halamanInput.getInputTanggal();
            String nama_produk = halamanInput.getInputNama();
            String jumlah = halamanInput.getInputJumlah();
            String harga = halamanInput.getInputHarga();

            if (tanggal.isEmpty() || nama_produk.isEmpty() || jumlah.isEmpty() || harga.isEmpty()) {
                JOptionPane.showMessageDialog(halamanInput, "Semua data harus diisi!");
                return;
            }

            beliBaru.setTanggal(tanggal);
            beliBaru.setNama_produk(nama_produk);
            beliBaru.setJmlPembelian(Integer.parseInt(jumlah));
            beliBaru.setTotalHarga(Integer.parseInt(harga));

            daoProdukUser.beliProduk(beliBaru);

            JOptionPane.showMessageDialog(null, "Produk berhasil dibeli.");

            halamanInput.dispose();
            new ViewDataProdukUser();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }


    public void filterProduk(String kategori) {
        List<ModelProdukUser> filteredProduk = daftarProduk.stream()
                .filter(produk -> kategori.equals("Semua") || produk.getKategori().equals(kategori))
                .collect(Collectors.toList());

        updateTableModelUser(filteredProduk);
    }
    
    private void updateTableModelUser(List<ModelProdukUser> produkList) {
        DefaultTableModel model = (DefaultTableModel) halamanTabel.getTableProduk().getModel();
        model.setRowCount(0); // Clear the table
        for (ModelProdukUser produk : produkList) {
            Object[] row = new Object[]{
                    produk.getID(),
                    produk.getNama_produk(),
                    produk.getHarga(),
                    produk.getKategori()
            };
            model.addRow(row);
        }
    }
    
    public List<String> getNamaProduk(){
        return daoProdukUser.getNamaProduk();
    }
    
    public int getHargaSatuan(String namaProduk){
        return daoProdukUser.getHargaSatuan(namaProduk);
    }
}
