package Model.User;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelUser extends AbstractTableModel {
    List<ModelUser> daftarUser;
    
    String kolom[] = {"ID", "Nama", "NIM", "Username", "Password"};
    
    public ModelTabelUser(List<ModelUser> daftarUser){
        this.daftarUser = daftarUser;
    }

    @Override
    public int getRowCount() {
        return daftarUser.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return daftarUser.get(rowIndex).getId();
            case 1:
                return daftarUser.get(rowIndex).getNama();
            case 2:
                return daftarUser.get(rowIndex).getNim();
            case 3:
                return daftarUser.get(rowIndex).getUsername();
            case 4:
                return daftarUser.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
