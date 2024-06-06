package Controller;

import Model.User.*;
import View.LoginPage;
import View.RegisterPage;
import View.User.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerUser {
    public DAOUser daoUser1;
    
    RegisterPage halamanInput;
    InputDataUser halamanTambah;
    ViewDataUser halamanTabel;
    EditDataUser halamanEdit;
    
    InterfaceDAOUser daoUser;
    
    List<ModelUser> daftarUser;
    
    public ControllerUser(ViewDataUser halamanTabel){
        this.halamanTabel = halamanTabel;
        this.daoUser = new DAOUser();
    }
    
    public ControllerUser(RegisterPage halamanInput){
        this.halamanInput = halamanInput;
        this.daoUser = new DAOUser();
    }
    
    public ControllerUser(EditDataUser halamanEdit){
        this.halamanEdit = halamanEdit;
        this.daoUser = new DAOUser();
    }
    
    public ControllerUser(InputDataUser halamanTambah){
        this.halamanTambah = halamanTambah;
        this.daoUser = new DAOUser();
    }
    
    
    
    public void showALLUser(){
        daftarUser = daoUser.getAll();
        ModelTabelUser tabel = new ModelTabelUser(daftarUser);
        halamanTabel.getTableUser().setModel(tabel);
    }
    
    public void inputUser(){
        try {
            ModelUser userBaru = new ModelUser();
            
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
            
            daoUser.inputUser(userBaru);
            
            JOptionPane.showMessageDialog(null, "Anda berhasil mendaftar");
            
            halamanInput.dispose();
            new LoginPage();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editUser(int id){
        try {
            
            ModelUser userYangMauDiedit = new ModelUser();
            
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
            
            daoUser.editUser(userYangMauDiedit);
            
            JOptionPane.showMessageDialog(null, "Data produk berhasil diubah.");
            
            halamanEdit.dispose();
            new ViewDataUser();
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
        }
    }
    
    public void tambahUser(){
    try {
            ModelUser userBaru = new ModelUser();
            
            String nama = halamanTambah.getInputNama();
            String nim = halamanTambah.getInputNim();
            String username = halamanTambah.getInputUsername();
            String password = halamanTambah.getInputPassword();
            
            if ("".equals(nama) || "".equals(nim) || "".equals(username) || "".equals(password)){
                throw new Exception("Semua data harus diisi!");
            }
            
            userBaru.setNama(nama);
            userBaru.setNim(nim);
            userBaru.setUsername(username);
            userBaru.setPassword(password);
            
            daoUser.inputUser(userBaru);
            
            JOptionPane.showMessageDialog(null, "Anda berhasil mendaftar");
            
            halamanTambah.dispose();
            new ViewDataUser();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void hapusUser(Integer baris){
        Integer id = (int) halamanTabel.getTableUser().getValueAt(baris, 0);
        String nama = halamanTabel.getTableUser().getValueAt(baris, 1).toString();
        
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus User",
                JOptionPane.YES_NO_OPTION
        );
        
        if (input == 0){
            daoUser.hapusUser(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus user.");
            
            showALLUser();
        }
    }
    
}
