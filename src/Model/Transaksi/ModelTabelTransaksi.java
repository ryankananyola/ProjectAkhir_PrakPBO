package Model.Transaksi;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelTransaksi extends AbstractTableModel{
    List<ModelTransaksi> daftarTransaksi;
    
    String kolom[] = {"No Penjualan", "Tanggal", "Nama Produk", "Jumlah Pembelian", "Total Harga", "Status"};
    
    public ModelTabelTransaksi(List<ModelTransaksi> daftarTransaksi){
        this.daftarTransaksi = daftarTransaksi;
    }
    
    @Override
    public int getRowCount() {
        return daftarTransaksi.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return daftarTransaksi.get(rowIndex).getNo_penjualan();
            case 1:
                return daftarTransaksi.get(rowIndex).getTanggal();
            case 2:
                return daftarTransaksi.get(rowIndex).getNama_produk();
            case 3:
                return daftarTransaksi.get(rowIndex).getJmlPembelian();
            case 4:
                return daftarTransaksi.get(rowIndex).getTotalHarga();
            case 5:
                return daftarTransaksi.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
    
}
