package Model.User;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUser implements InterfaceDAOUser {

    @Override
    public void inputUser(ModelUser user) {
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
    public void editUser(ModelUser user) {
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
    public List<ModelUser> getAll() {
        List<ModelUser> listUser = null;
        
        try{
            
            listUser = new ArrayList<>();
            
            Statement perintah = Connector.konek().createStatement();
            
            String query = "SELECT * FROM user;";
            
            ResultSet setHasil = perintah.executeQuery(query);
            
            while(setHasil.next()){
                ModelUser user = new ModelUser();
                
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

    @Override
    public void tambahUser(ModelUser user) {
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
    public void hapusUser(int id) {
        try {
            String query = "DELETE FROM user WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.konek().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e){
            System.out.println("Hapus Gagal: " + e.getLocalizedMessage());
        }
    }
}
