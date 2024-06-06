package Model.Produk;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProduk implements InterfaceDAOProduk {

    @Override
    public void inputProduk(ModelProduk produk) {
        try{
            String query = "INSERT INTO produk (nama_produk, harga, kategori) VALUES (?, ?, ?);";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, produk.getNama_produk());
            perintah.setString(2, produk.getHarga());
            perintah.setString(3, produk.getKategori());
            
            perintah.executeUpdate();
            perintah.close();
        }catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelProduk produk) {
        try{
            String query = "UPDATE produk SET nama_produk=?, harga=?, kategori=? WHERE id=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, produk.getNama_produk());
            perintah.setString(2, produk.getHarga());
            perintah.setString(3, produk.getKategori());
            perintah.setInt(4, produk.getID());
            
            perintah.executeUpdate();
            
            perintah.close();
        }catch(SQLException e){
            System.out.println("Edit Gagal! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try{
            String query = "DELETE FROM produk WHERE id=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setInt(1, id);
            
            perintah.executeUpdate();
            
            perintah.close();
        }catch(SQLException e){
            System.out.println("Hapus Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelProduk> getAll() {
        List<ModelProduk> listProduk = null;
        
        try{
            listProduk = new ArrayList<>();
            
            Statement statement = Connector.konek().createStatement();
            
            String query = "SELECT * FROM produk;";
            
            ResultSet setHasil = statement.executeQuery(query);
            
            while (setHasil.next()){
                ModelProduk prdct = new ModelProduk();
                
                prdct.setID(setHasil.getInt("id"));
                prdct.setNama_produk(setHasil.getString("nama_produk"));
                prdct.setHarga(setHasil.getString("harga"));
                prdct.setKategori(setHasil.getString("kategori"));
                
                listProduk.add(prdct);
            }
            
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listProduk;
    }

    @Override
    public void beliProduk(ModelProduk produk) {
        try{
            String query = "INSERT INTO transaksipenjualan (tanggal, nama_produk, jumlah_pembelian, total_harga) VALUES (?, ?, ?, ?);";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, produk.getTanggal());
            perintah.setString(2, produk.getNama_produk());
            perintah.setString(3, produk.getKategori());
            
            perintah.executeUpdate();
            perintah.close();
        }catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }
     
}
