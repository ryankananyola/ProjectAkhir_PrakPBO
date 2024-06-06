package View.User;

import Controller.ControllerUser;
import View.HalamanUtamaAdmin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class InputDataUser extends JFrame {
    ControllerUser controller;
    
    JLabel Header = new JLabel("INPUT DATA USER");
    JLabel Footer = new JLabel("Instagram : @aaisyahk._ & @ryankananyola");
    JLabel labelInputNama = new JLabel ("Nama");
    JLabel labelInputNIM = new JLabel ("NIM");
    JLabel labelInputUser = new JLabel("Username");
    JLabel labelInputPass = new JLabel("Password");
    
    JTextField inputNama = new JTextField("");
    JTextField inputNIM = new JTextField("");
    JTextField inputUsername = new JTextField("");
    JTextField inputPassword = new JTextField("");
    
    JButton tombolTambah = new JButton ("Tambah");
    JButton tombolKembali = new JButton ("Kembali");
    
    public InputDataUser(){
        
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
        Header.setBounds(370,45,330,35);
        add(labelInputNama);
        labelInputNama.setBounds(250,130,100,15);
        add(labelInputNIM);
        labelInputNIM.setBounds(550,130,100,15);
        add(labelInputUser);
        labelInputUser.setBounds(250,200,100,15);
        add(labelInputPass);
        labelInputPass.setBounds(550,200,100,15);

        add(Footer);
        Footer.setFont(new Font("Calibri", Font.PLAIN, 12));
        Footer.setBounds(375,540,400,35);
        
        
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
        
        add(tombolTambah);
        tombolTambah.setForeground(new Color(255, 215, 20));
        tombolTambah.setBackground(new Color(50,205,50));
        tombolTambah.setBounds(425,290,150,30);
        
        add(tombolKembali);
        tombolKembali.setForeground(Color.white);
        tombolKembali.setBackground(new Color(0,0,139));
        tombolKembali.setBounds(460,480,85,25);
        
        controller = new ControllerUser(this);
        
        tombolTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.tambahUser();
            }
        });
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtamaAdmin();
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
