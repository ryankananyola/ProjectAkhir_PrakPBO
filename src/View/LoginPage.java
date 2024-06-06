package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    
    JLabel Header = new JLabel("SILAHKAN LOGIN");
    JLabel SubHeader0 = new JLabel("Masukkan Username dan Password");
    JLabel Footer = new JLabel("Instagram : @aaisyahk._ & @ryankananyola");
    JLabel labelInputUser = new JLabel("Username");
    JLabel labelInputPass = new JLabel("Password");
    JLabel labelDaftar = new JLabel("Belum punya akun?");
            
    JTextField inputUsername = new JTextField("");
    JTextField inputPassword = new JTextField("");
    
    JButton tombolMasuk = new JButton ("Masuk");
    JButton tombolDaftar = new JButton ("Daftar");
    JButton tombolKembali = new JButton ("Kembali");
    
    public LoginPage(){
        
        //Membuat dan menampilkan JFrame
        setVisible(true);
        setTitle("Halaman Login");
        setSize(1000, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        //Menampilkan JLabel pada Frame
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(350,65,330,35);
        add(SubHeader0);
        SubHeader0.setFont(new Font("Times New Roman", Font.BOLD, 14));
        SubHeader0.setBounds(365,105,400,35);
        add(labelInputUser);
        labelInputUser.setBounds(325,190,400,15);
        add(labelInputPass);
        labelInputPass.setBounds(325,260,400,15);
        add(labelDaftar);
        labelDaftar.setBounds(380,410,400,25);
        add(Footer);
        Footer.setFont(new Font("Calibri", Font.PLAIN, 12));
        Footer.setBounds(355,540,400,35);
                
        add(inputUsername);
        inputUsername.setBounds(325,210,300,30);
        inputUsername.setBackground(new Color(254, 246, 172));
        add(inputPassword);
        inputPassword.setBounds(325,280,300,30);
        inputPassword.setBackground(new Color(254, 246, 172));
        
        add(tombolMasuk);
        tombolMasuk.setForeground(new Color(255, 255,255));
        tombolMasuk.setBackground(new Color(50,205,50));
        tombolMasuk.setBounds(400,350,150,35);
        add(tombolDaftar);
        tombolDaftar.setForeground(Color.red);
        tombolDaftar.setBackground(new Color(255, 215, 0));
        tombolDaftar.setBounds(500,410,70,25);
        add(tombolKembali);
        tombolKembali.setForeground(Color.white);
        tombolKembali.setBackground(new Color(0,0,139));
        tombolKembali.setBounds(435,480,85,25);
        
        tombolMasuk.addActionListener(this);
        tombolDaftar.addActionListener(this);
        tombolKembali.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==tombolMasuk){
            try{
                String username = inputUsername.getText();
                String password = inputPassword.getText();

                if(username.equals("") || password.equals("")){
                    throw new Exception("Username dan Password harus diisi");
                }
                
                
                String userType = validateLogin(username, password);

                if (userType != null) {
                    System.out.println("Login successful");

                    if (userType.equals("user")) {
                        new HalamanUtamaUser();
                    } else if (userType.equals("admin")) {
                        new HalamanUtamaAdmin();
                    }

                    dispose();
                } else {
                    System.out.println("Login failed");
                    throw new Exception("Username atau Password salah");
                }
                
            }catch (Exception error){
                JOptionPane.showMessageDialog(this, error.getMessage());
                inputUsername.setText("");
                inputPassword.setText("");
            }
        } else if(e.getSource()==tombolDaftar){
            dispose();
            new RegisterPage();
        } else if(e.getSource()==tombolKembali){
            dispose();
            new HalamanAwal();
        }
    }
    
        private String validateLogin(String username, String password) throws Exception {
        String userType = null;

        String url = "jdbc:mysql://localhost:3306/sepatulari";
        String user = "root";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sqlAdmin = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement statementAdmin = conn.prepareStatement(sqlAdmin);
            statementAdmin.setString(1, username);
            statementAdmin.setString(2, password);

            ResultSet resultSetAdmin = statementAdmin.executeQuery();

            if (resultSetAdmin.next()) {
                userType = "admin";
            } else {
                String sqlUser = "SELECT * FROM user WHERE username = ? AND password = ?";
                PreparedStatement statementUser = conn.prepareStatement(sqlUser);
                statementUser.setString(1, username);
                statementUser.setString(2, password);

                ResultSet resultSetUser = statementUser.executeQuery();

                if (resultSetUser.next()) {
                    userType = "user";
                }
            }

        } catch (Exception ex) {
            throw new Exception("Terjadi kesalahan saat menghubungi database: " + ex.getMessage());
        }

        return userType;
    }
}




