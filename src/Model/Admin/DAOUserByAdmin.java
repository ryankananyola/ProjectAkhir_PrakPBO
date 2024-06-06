package Model.Admin;

import Model.Connector;
import Model.User.ModelUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOUserByAdmin implements InterfaceDAOAdmin {

    @Override
    public void inputUserByAdmin(ModelUserByAdmin user) {
        try{
            String query = "INSERT INTO user (nama, nim, username, password) VALUES (?, ?, ?, ?);";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, user.getNama());
            perintah.setString(2, user.getNim());
            perintah.setString(3, user.getUsername());
            perintah.setString(4, user.getPassword());
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void editUserByAdmin(ModelUserByAdmin user) {
        try{
            String query = "UPDATE user SET nama=?, nim=?, username=?, password=? WHERE id=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, user.getNama());
            perintah.setString(2, user.getNim());
            perintah.setString(3, user.getUsername());
            perintah.setString(4, user.getPassword());
            perintah.setInt(5, user.getId());
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch(SQLException e){
            System.out.println("Input Gagal: (" + e.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void hapusUserByAdmin(int id) {
        try {
            String query = "DELETE FROM user WHERE id=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setInt(1, id);
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelUserByAdmin> getAll() {
        List<ModelUserByAdmin> listUser = null;
        
        try{
            
            listUser = new ArrayList<>();
            
            Statement perintah = Connector.konek().createStatement();
            
            String query = "SELECT * FROM user;";
            
            ResultSet setHasil = perintah.executeQuery(query);
            
            while(setHasil.next()){
                ModelUserByAdmin user = new ModelUserByAdmin();
                
                user.setId(setHasil.getInt("id"));
                user.setNama(setHasil.getString("nama"));
                user.setNim(setHasil.getString("nim"));
                user.setUsername(setHasil.getString("username"));
                user.setPassword(setHasil.getString("password"));
                
                listUser.add(user);
            }
            
            perintah.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listUser;
    }
    
}
