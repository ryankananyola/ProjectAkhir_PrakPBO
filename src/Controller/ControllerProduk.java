package Controller;

import Model.Produk.*;
import View.Produk.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerProduk {
    
    ViewDataProduk halamanTabel;
    InputDataProduk halamanInput;
    EditDataProduk halamanEdit;

    InterfaceDAOProduk daoProduk;

    List<ModelProduk> daftarProduk;

    public ControllerProduk(ViewDataProduk halamanTabel) {
        this.halamanTabel = halamanTabel;
        this.daoProduk = new DAOProduk();
        this.daftarProduk = daoProduk.getAll(); // Load all products initially
    }
    

    public ControllerProduk(InputDataProduk halamanInput) {
        this.halamanInput = halamanInput;
        this.daoProduk = new DAOProduk();
    }

    public ControllerProduk(EditDataProduk halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoProduk = new DAOProduk();
    }

    public void showAllProduk() {
        daftarProduk = daoProduk.getAll();
        updateTableModel(daftarProduk);
    }

    public void inputProduk() {
        try {
            ModelProduk produkBaru = new ModelProduk();

            String nama_produk = halamanInput.getInputNama();
            String harga = halamanInput.getInputHarga();
            String kategori = halamanInput.getInputKategori();

            if (nama_produk.isEmpty() || harga.isEmpty() || kategori == null) {
                JOptionPane.showMessageDialog(halamanInput, "Semua data harus diisi!");
                return;
            }

            produkBaru.setNama_produk(nama_produk);
            produkBaru.setHarga(harga);
            produkBaru.setKategori(kategori);

            daoProduk.inputProduk(produkBaru);
            System.out.println("Berhasil");
            
            JOptionPane.showMessageDialog(null, "Produk baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewDataProduk();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editProduk(int id) {
        try {

            ModelProduk produkYangMauDiedit = new ModelProduk();

            String nama_produk = halamanEdit.getEditNama();
            String harga = halamanEdit.getEditHarga();
            String kategori = halamanEdit.getEditKategori();

            if (nama_produk.isEmpty() || harga.isEmpty() || kategori == null) {
                JOptionPane.showMessageDialog(halamanEdit, "Semua data harus diisi!");
                return;
            }

            produkYangMauDiedit.setID(id);
            produkYangMauDiedit.setNama_produk(nama_produk);
            produkYangMauDiedit.setHarga(harga);
            produkYangMauDiedit.setKategori(kategori);

            daoProduk.update(produkYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data produk berhasil diubah.");

            halamanEdit.dispose();
            new ViewDataProduk();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
        }
    }

    public void hapusProduk(Integer baris) {
        Integer id = (int) halamanTabel.getTableProduk().getValueAt(baris, 0);
        String nama_produk = halamanTabel.getTableProduk().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama_produk + "?",
                "Hapus Produk",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoProduk.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus produk.");
            showAllProduk();
        }
    }

    public void filterProduk(String kategori) {
        List<ModelProduk> filteredProduk = daftarProduk.stream()
                .filter(produk -> kategori.equals("Semua") || produk.getKategori().equals(kategori))
                .collect(Collectors.toList());

        updateTableModel(filteredProduk);
    }

    private void updateTableModel(List<ModelProduk> produkList) {
        DefaultTableModel model = (DefaultTableModel) halamanTabel.getTableProduk().getModel();
        model.setRowCount(0); // Clear the table
        for (ModelProduk produk : produkList) {
            Object[] row = new Object[]{
                    produk.getID(),
                    produk.getNama_produk(),
                    produk.getHarga(),
                    produk.getKategori()
            };
            model.addRow(row);
        }
    }
}
