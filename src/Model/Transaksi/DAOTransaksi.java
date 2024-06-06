package Model.Transaksi;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTransaksi implements InterfaceDAOTransaksi{

    @Override
    public void inputTransaksi(ModelTransaksi transaksi) {
        try{
            String query = "INSERT INTO transaksipenjualan (tanggal, nama_produk, jumlah_pembelian, total_harga, status) VALUES (?, ?, ?, ?, 'Pending');";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, transaksi.getTanggal());
            perintah.setString(2, transaksi.getNama_produk());
            perintah.setInt(3, transaksi.getJmlPembelian());
            perintah.setInt(4, transaksi.getTotalHarga());
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void updateTransaksi(ModelTransaksi transaksi) {
        try{
            String query = "UPDATE transaksipenjualan SET tanggal=?, nama_produk=?, jumlah_pembelian=?, total_harga=?, status=? WHERE no_penjualan=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setString(1, transaksi.getTanggal());
            perintah.setString(2, transaksi.getNama_produk());
            perintah.setInt(3, transaksi.getJmlPembelian());
            perintah.setInt(4, transaksi.getTotalHarga());
            perintah.setString(5, transaksi.getStatus());
            perintah.setInt(6, transaksi.getNo_penjualan());
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch(SQLException e){
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void hapusTransaksi(int no_penjualan) {
        try {
            String query = "DELETE FROM transaksipenjualan WHERE no_penjualan=?;";
            
            PreparedStatement perintah;
            perintah = Connector.konek().prepareStatement(query);
            perintah.setInt(1, no_penjualan);
            
            perintah.executeUpdate();
            
            perintah.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelTransaksi> getAll() {
        List<ModelTransaksi> listTransaksi = null;
        
        try{
            
            listTransaksi = new ArrayList<>();
            
            Statement perintah = Connector.konek().createStatement();
            
            String query = "SELECT * FROM transaksipenjualan;";
            
            ResultSet setHasil = perintah.executeQuery(query);
            
            while(setHasil.next()){
                ModelTransaksi trns = new ModelTransaksi();
                
                trns.setNo_penjualan(setHasil.getInt("no_penjualan"));
                trns.setTanggal(setHasil.getString("tanggal"));
                trns.setNama_produk(setHasil.getString("nama_produk"));
                trns.setJmlPembelian(setHasil.getInt("jumlah_pembelian"));
                trns.setTotalHarga(setHasil.getInt("total_harga"));
                trns.setStatus(setHasil.getString("status"));
                
                listTransaksi.add(trns);
            }
            
            perintah.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listTransaksi;
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
