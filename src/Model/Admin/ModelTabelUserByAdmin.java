package Model.Admin;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelUserByAdmin extends AbstractTableModel {
    List<ModelUserByAdmin> daftarUserByAdmin;
    
    String kolom[] = {"ID", "Nama", "NIM", "Username", "Password"};
    
    public ModelTabelUserByAdmin(List<ModelUserByAdmin> daftarUserByAdmin){
        this.daftarUserByAdmin = daftarUserByAdmin;
    }

    @Override
    public int getRowCount() {
        return daftarUserByAdmin.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return daftarUserByAdmin.get(rowIndex).getId();
            case 1:
                return daftarUserByAdmin.get(rowIndex).getNama();
            case 2:
                return daftarUserByAdmin.get(rowIndex).getNim();
            case 3:
                return daftarUserByAdmin.get(rowIndex).getUsername();
            case 4:
                return daftarUserByAdmin.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
