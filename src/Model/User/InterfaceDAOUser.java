package Model.User;

import java.util.List;

public interface InterfaceDAOUser {
    
    public void inputUser(ModelUser user);
    
    public void editUser(ModelUser user);
    
    public void tambahUser(ModelUser user);
    
    public void hapusUser(int id);
    
    public List<ModelUser> getAll();
}
