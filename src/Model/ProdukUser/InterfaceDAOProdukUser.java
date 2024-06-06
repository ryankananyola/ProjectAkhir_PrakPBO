package Model.ProdukUser;

import java.util.List;

public interface InterfaceDAOProdukUser {
    
    public void beliProduk(ModelBeliUser produk);
 
    public List<ModelProdukUser> getAll();
    
    public List<String>getNamaProduk();
    
    public int getHargaSatuan(String namaProduk);
    
}
