package View.Produk;

import Controller.ControllerProduk;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataProduk extends JFrame{
    ControllerProduk controller;
    
    JLabel Header = new JLabel ("INPUT PRODUK");
    JLabel labelInputNama = new JLabel ("Nama Produk");
    JLabel labelInputHarga = new JLabel ("Harga");
    JLabel labelInputKategori = new JLabel ("Kategori");
    
    JTextField inputNama = new JTextField("");
    JTextField inputHarga = new JTextField("");
    
    JButton tombolTambah = new JButton ("Tambah Produk");
    JButton tombolKembali = new JButton ("Kembali");
    
    JRadioButton KategoriPria = new JRadioButton ("Pria");
    JRadioButton KategoriWanita = new JRadioButton ("Wanita");
    ButtonGroup kategoriGroup = new ButtonGroup();
    
    public InputDataProduk(){
        setVisible(true);
        setTitle("Input Produk");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(175,65,330,35);
        add(labelInputNama);
        labelInputNama.setBounds(45,115,330,35);
        add(labelInputHarga);
        labelInputHarga.setBounds(45,185,330,35);
        add(labelInputKategori);
        labelInputKategori.setBounds(45,255,330,35);
        
        add(inputNama);
        inputNama.setBounds(45,145,445,35);
        add(inputHarga);
        inputHarga.setBounds(45,215,445,35);
        
        kategoriGroup.add(KategoriPria);
        kategoriGroup.add(KategoriWanita);
        
        add(KategoriPria);
        KategoriPria.setBackground(new Color(255, 215, 0));
        KategoriPria.setBounds(45,285,50,20);
        add(KategoriWanita);
        KategoriWanita.setBackground(new Color(255, 215, 0));
        KategoriWanita.setBounds(100,285,100,20);
        
       
        add(tombolTambah);
        tombolTambah.setForeground(new Color(255, 215, 0));
        tombolTambah.setBackground(new Color(50,205,50));
        tombolTambah.setBounds(200,425,150,35);
        add(tombolKembali);
        tombolKembali.setForeground(new Color(255, 215, 0));
        tombolKembali.setBackground(new Color(255,0,0));
        tombolKembali.setBounds(200,475,150,35);
        
        controller = new ControllerProduk(this);
        
        
        tombolTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.inputProduk();
            }
        });
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataProduk();
            }
        });
    }
    
    public String getInputNama(){
        return inputNama.getText();
    }
    
    public String getInputHarga(){
        return inputHarga.getText();
    }
    
    public String getInputKategori(){
        if (KategoriPria.isSelected()) {
            return "Pria";
        } else if (KategoriWanita.isSelected()) {
            return "Wanita";
        }else {
            return null;
        }
    }
}
