package View;

import Controller.ControllerUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class RegisterPage extends JFrame{
    ControllerUser controller;
    
    JLabel Header = new JLabel("SILAHKAN DAFTAR");
    JLabel SubHeader0 = new JLabel("Silahkan isi data anda");
    JLabel Footer = new JLabel("Instagram : @aaisyahk._ & @ryankananyola");
    JLabel labelInputNama = new JLabel ("Nama");
    JLabel labelInputNIM = new JLabel ("NIM");
    JLabel labelInputUser = new JLabel("Username");
    JLabel labelInputPass = new JLabel("Password");
    JLabel labelLogin = new JLabel("Sudah punya akun?");
    
    JTextField inputNama = new JTextField("");
    JTextField inputNIM = new JTextField("");
    JTextField inputUsername = new JTextField("");
    JTextField inputPassword = new JTextField("");
    
    JButton tombolMasuk = new JButton ("Masuk");
    JButton tombolDaftar = new JButton ("Daftar");
    JButton tombolKembali = new JButton ("Kembali");
    
    public RegisterPage(){
        
        //Membuat dan menampilkan JFrame
        setVisible(true);
        setTitle("Halaman Daftar");
        setSize(1000, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(350,45,330,35);
        add(SubHeader0);
        SubHeader0.setFont(new Font("Times New Roman", Font.BOLD, 14));
        SubHeader0.setBounds(415,75,400,35);
        add(labelInputNama);
        labelInputNama.setBounds(250,130,100,15);
        add(labelInputNIM);
        labelInputNIM.setBounds(550,130,100,15);
        add(labelInputUser);
        labelInputUser.setBounds(250,200,100,15);
        add(labelInputPass);
        labelInputPass.setBounds(550,200,100,15);

        add(labelLogin);
        labelLogin.setBounds(380,380,400,25);
        add(Footer);
        Footer.setFont(new Font("Calibri", Font.PLAIN, 12));
        Footer.setBounds(355,540,400,35);
        
        
        add(inputNama);
        inputNama.setBounds(250,150,200,30);
        inputNama.setBackground(new Color(254, 246, 172));
        add(inputNIM);
        inputNIM.setBounds(550,150,200,30);
        inputNIM.setBackground(new Color(254, 246, 172));
        add(inputUsername);
        inputUsername.setBounds(250,220,200,30);
        inputUsername.setBackground(new Color(254, 246, 172));
        add(inputPassword);
        inputPassword.setBounds(550,220,200,30);
        inputPassword.setBackground(new Color(254, 246, 172));
        
        add(tombolDaftar);
        tombolDaftar.setForeground(new Color(255, 215, 20));
        tombolDaftar.setBackground(new Color(50,205,50));
        tombolDaftar.setBounds(275,290,150,30);
        add(tombolMasuk);
        tombolMasuk.setForeground(Color.red);
        tombolMasuk.setBackground(new Color(255, 215, 0));
        tombolMasuk.setBounds(500,380,73,25);
        add(tombolKembali);
        tombolKembali.setForeground(Color.white);
        tombolKembali.setBackground(new Color(0,0,139));
        tombolKembali.setBounds(435,480,85,25);
        
        controller = new ControllerUser(this);
        
        tombolMasuk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
        
        tombolDaftar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.inputUser();
            }
        });
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanAwal();
            }
        });
    }
    
    public String getInputNama(){
        return inputNama.getText();
    }
    
    public String getInputNim(){
        return inputNIM.getText();
    }
    
    public String getInputUsername(){
        return inputUsername.getText();
    }
    
    public String getInputPassword(){
        return inputPassword.getText();
    }
}
