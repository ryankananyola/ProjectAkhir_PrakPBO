package Model.Admin;

import java.util.List;

public interface InterfaceDAOAdmin {
    
    public void inputUserByAdmin(ModelUserByAdmin user);
    
    public void editUserByAdmin(ModelUserByAdmin user);
    
    public void hapusUserByAdmin(int id);
    
    public List<ModelUserByAdmin> getAll();
}
