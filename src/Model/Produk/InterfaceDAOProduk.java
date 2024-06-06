package Model.Produk;

import java.util.List;

public interface InterfaceDAOProduk {
    public void inputProduk(ModelProduk produk);
    
    public void update(ModelProduk produk);
    
    public void beliProduk(ModelProduk produk);
    
    public void delete(int id);
    
    public List<ModelProduk> getAll();
}
