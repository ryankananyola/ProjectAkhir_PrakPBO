package Model.ProdukUser;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelProdukUser extends AbstractTableModel{
    List<ModelProdukUser> daftarProduk;
    
    String kolom[] = {"ID", "Nama Produk", "Harga", "Kategori"};
    
    public ModelTabelProdukUser(List<ModelProdukUser> daftarProduk){
        this.daftarProduk = daftarProduk;
    }

    @Override
    public int getRowCount() {
        return daftarProduk.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return daftarProduk.get(rowIndex).getID();
            case 1:
                return daftarProduk.get(rowIndex).getNama_produk();
            case 2:
                return daftarProduk.get(rowIndex).getHarga();
            case 3:
                return daftarProduk.get(rowIndex).getKategori();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
}
