package Controller;

import Model.Admin.DAOUserByAdmin;
import Model.Admin.InterfaceDAOAdmin;
import Model.Admin.ModelTabelUserByAdmin;
import Model.Admin.ModelUserByAdmin;
import View.LoginPage;
import View.RegisterPage;
import View.User.ViewDataUser;
import View.UserByUser.EditByUser;
import View.UserByUser.ViewByUser;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerAdmin {
    
    RegisterPage halamanInput;
    ViewByUser halamanTabel;
    EditByUser halamanEdit;
    
    InterfaceDAOAdmin daoUserByAdmin;
    
    List<ModelUserByAdmin> daftarUser;
    
    public ControllerAdmin(ViewByUser halamanTabel){
        this.halamanTabel = halamanTabel;
        this.daoUserByAdmin = new DAOUserByAdmin();
    }
    
    public ControllerAdmin(EditByUser halamanEdit){
        this.halamanEdit = halamanEdit;
        this.daoUserByAdmin = new DAOUserByAdmin();
    }
    
    public void showALLUser(){
        daftarUser = daoUserByAdmin.getAll();
        ModelTabelUserByAdmin tabel = new ModelTabelUserByAdmin(daftarUser);
        halamanTabel.getTableUser().setModel(tabel);
    }
    
    public void inputUserByAdmin(){
        try {
            ModelUserByAdmin userBaru = new ModelUserByAdmin();
            
            String nama = halamanInput.getInputNama();
            String nim = halamanInput.getInputNim();
            String username = halamanInput.getInputUsername();
            String password = halamanInput.getInputPassword();
            
            if ("".equals(nama) || "".equals(nim) || "".equals(username) || "".equals(password)){
                throw new Exception("Semua data harus diisi!");
            }
            
            userBaru.setNama(nama);
            userBaru.setNim(nim);
            userBaru.setUsername(username);
            userBaru.setPassword(password);
            
            daoUserByAdmin.inputUserByAdmin(userBaru);
            
            JOptionPane.showMessageDialog(null, "Anda berhasil mendaftar");
            
            halamanInput.dispose();
            new LoginPage();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editUserByAdmin(int id){
        try {
            
            ModelUserByAdmin userYangMauDiedit = new ModelUserByAdmin();
            
            String nama = halamanEdit.getEditNama();
            String nim = halamanEdit.getEditNim();
            String username = halamanEdit.getEditUsername();
            String password = halamanEdit.getEditPassword();
            
            if(nama.isEmpty() || nim.isEmpty() || username == null || password == null) {
                JOptionPane.showMessageDialog(halamanInput, "Semua data harus diisi!");
            }
            
            userYangMauDiedit.setId(id);
            userYangMauDiedit.setNama(nama);
            userYangMauDiedit.setNim(nim);
            userYangMauDiedit.setUsername(username);
            userYangMauDiedit.setPassword(password);
            
            daoUserByAdmin.editUserByAdmin(userYangMauDiedit);
            
            JOptionPane.showMessageDialog(null, "Data produk berhasil diubah.");
            
            halamanEdit.dispose();
            new ViewByUser();
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
        }
    }
}
