package View.Produk;

import Controller.ControllerProduk;
import Model.Produk.ModelProduk;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class EditDataProduk extends JFrame{
    ControllerProduk controller;
    ModelProduk produk;
    String gambarPath;
    
    JLabel Header = new JLabel("EDIT PRODUK");
    JLabel labelEditNama = new JLabel ("Nama Produk");
    JLabel labelEditHarga = new JLabel ("Harga");
    JLabel labelEditKategori = new JLabel ("Kategori");
    
    JTextField editNama = new JTextField();
    JTextField editHarga = new JTextField();
    
    JRadioButton radioPria = new JRadioButton("Pria");
    JRadioButton radioWanita = new JRadioButton("Wanita");
    ButtonGroup kategoriGroup = new ButtonGroup();
    
    JButton tombolEdit = new JButton("Edit Produk");
    JButton tombolKembali = new JButton("Kembali");
    
    public EditDataProduk(ModelProduk produk){
        this.produk = produk;
        
        setVisible(true);
        setTitle("Edit Produk");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(175,65,330,35);
        add(labelEditNama);
        labelEditNama.setBounds(45,115,330,35);
        add(labelEditHarga);
        labelEditHarga.setBounds(45,185,330,35);
        add(labelEditKategori);
        labelEditKategori.setBounds(45,255,330,35);
        
        add(editNama);
        editNama.setBounds(45,145,445,35);
        add(editHarga);
        editHarga.setBounds(45,215,445,35);
        
        kategoriGroup.add(radioPria);
        kategoriGroup.add(radioWanita);
        add(radioPria);
        add(radioWanita);
        radioPria.setBounds(45, 285, 100, 35);
        radioPria.setBackground(new Color(255, 215, 0));
        radioWanita.setBounds(145, 285, 100, 35);
        radioWanita.setBackground(new Color(255, 215, 0));
        
        
        add(tombolEdit);
        tombolEdit.setForeground(new Color(255, 215, 0));
        tombolEdit.setBackground(new Color(50,205,50));
        tombolEdit.setBounds(200,425,150,35);
        add(tombolKembali);
        tombolKembali.setForeground(new Color(255, 215, 0));
        tombolKembali.setBackground(new Color(255,0,0));
        tombolKembali.setBounds(200,475,150,35);
        
        editNama.setText(produk.getNama_produk());
        editHarga.setText(produk.getHarga());
        if (produk.getKategori().equals("Pria")) {
            radioPria.setSelected(true);
        } else if (produk.getKategori().equals("Wanita")) {
            radioWanita.setSelected(true);
        }
        
        controller = new ControllerProduk(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataProduk();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editProduk(produk.getID());
            }
        });
    }
    
    public String getEditNama(){
        return editNama.getText();
    }
    
    public String getEditHarga(){
        return editHarga.getText();
    }
    
    public String getEditKategori() {
        if (radioPria.isSelected()) {
            return "Pria";
        } else if (radioWanita.isSelected()) {
            return "Wanita";
        } else {
            return null; 
        }
    }
}
