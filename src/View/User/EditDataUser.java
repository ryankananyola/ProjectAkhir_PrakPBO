package View.User;

import Controller.ControllerUser;
import Model.User.ModelUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditDataUser extends JFrame {
    ControllerUser controller;
    ModelUser user;
    
    JLabel Header = new JLabel("EDIT DATA USER");
    JLabel labelEditNama = new JLabel ("Nama");
    JLabel labelEditNim = new JLabel ("NIM");
    JLabel labelEditUsername = new JLabel ("Username");
    JLabel labelEditPassword = new JLabel ("Password");
    
    JTextField editNama = new JTextField();
    JTextField editNim = new JTextField();
    JTextField editUsername = new JTextField();
    JTextField editPassword = new JTextField();
     
    JButton tombolEdit = new JButton("Edit Data User");
    JButton tombolKembali = new JButton("Kembali");
    
    public EditDataUser(ModelUser user){
        this.user = user;
        
        setVisible(true);
        setTitle("Edit Data User");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(165,65,330,35);
        add(labelEditNama);
        labelEditNama.setBounds(45,115,330,35);
        add(labelEditNim);
        labelEditNim.setBounds(45,180,330,35);
        add(labelEditUsername);
        labelEditUsername.setBounds(45,245,330,35);
        add(labelEditPassword);
        labelEditPassword.setBounds(45,310,330,35);
       
        
        add(editNama);
        editNama.setBounds(45,145,445,35);
        add(editNim);
        editNim.setBounds(45,210,445,35);
        add(editUsername);
        editUsername.setBounds(45,275,445,35);
        add(editPassword);
        editPassword.setBounds(45,340,445,35);
        
        add(tombolEdit);
        tombolEdit.setForeground(new Color(255, 215, 0));
        tombolEdit.setBackground(new Color(50,205,50));
        tombolEdit.setBounds(100,475,150,35);
        add(tombolKembali);
        tombolKembali.setForeground(new Color(255, 215, 0));
        tombolKembali.setBackground(new Color(255,0,0));
        tombolKembali.setBounds(300,475,150,35);
        
        editNama.setText(user.getNama());
        editNim.setText(user.getNim());
        editUsername.setText(user.getUsername());
        editPassword.setText(user.getPassword());
                
        controller = new ControllerUser(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataUser();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editUser(user.getId());
            }
        });
    }
    
    public String getEditNama(){
        return editNama.getText();
    }
    
    public String getEditNim(){
        return editNim.getText();
    }
    
    public String getEditUsername(){
        return editUsername.getText();
    }
    
    public String getEditPassword(){
        return editPassword.getText();
    }
}
