package Model.ProdukUser;

import Model.Produk.ModelProduk;

public class ModelBeliUser extends ModelProduk{
    private Integer no_penjualan, jmlPembelian, totalHarga;
    public String nama_produk;
    private String tanggal;

    public Integer getNo_penjualan() {
        return no_penjualan;
    }

    public void setNo_penjualan(Integer no_penjualan) {
        this.no_penjualan = no_penjualan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Integer getJmlPembelian() {
        return jmlPembelian;
    }

    public void setJmlPembelian(Integer jmlPembelian) {
        this.jmlPembelian = jmlPembelian;
    }

    public Integer getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }
    
}
