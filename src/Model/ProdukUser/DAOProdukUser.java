package Model.ProdukUser;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProdukUser implements InterfaceDAOProdukUser{

    @Override
    public void beliProduk(ModelBeliUser produk) {
        try{
            String query = "INSERT INTO transaksipenjualan (tanggal, nama_produk, jumlah_pembelian, total_harga, status) VALUES (?, ?, ?, ?, 'Pending');";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, produk.getTanggal());
            perintah.setString(2, produk.getNama_produk());
            perintah.setInt(3, produk.getJmlPembelian());
            perintah.setInt(4, produk.getTotalHarga());
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelProdukUser> getAll() {
     List<ModelProdukUser> listProduk = null;
        
        try{
            listProduk = new ArrayList<>();
            
            Statement statement = Connector.konek().createStatement();
            
            String query = "SELECT * FROM produk;";
            
            ResultSet setHasil = statement.executeQuery(query);
            
            while (setHasil.next()){
                ModelProdukUser prdct = new ModelProdukUser();
                
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
    public List<String> getNamaProduk() {
        List<String> listProduk = new ArrayList<>();
        String query = "SELECT nama_produk FROM produk;";
        
        try {
            Statement perintah = Connector.konek().createStatement();
            ResultSet rs = perintah.executeQuery(query);

            while (rs.next()) {
                listProduk.add(rs.getString("nama_produk"));
            }
            rs.close();
            perintah.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProduk;
    }

    @Override
    public int getHargaSatuan(String namaProduk) {
        int hargaSatuan = 0;
        String query = "SELECT harga FROM produk WHERE nama_produk = ?;";

        try {
            PreparedStatement perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, namaProduk);
            ResultSet rs = perintah.executeQuery();

            if (rs.next()) {
                hargaSatuan = rs.getInt("harga");
            }

            rs.close();
            perintah.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hargaSatuan;
    }
    
    
}
