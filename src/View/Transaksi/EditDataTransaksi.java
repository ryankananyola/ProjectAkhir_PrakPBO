package View.Transaksi;

import Controller.ControllerTransaksi;
import Model.Transaksi.ModelTransaksi;
import View.User.ViewDataUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditDataTransaksi extends JFrame {
    ControllerTransaksi controller;
    ModelTransaksi transaksi;
    
    JLabel Header = new JLabel("EDIT DATA TRANSAKSI");
    JLabel labelEditTanggal = new JLabel("Tanggal");
    JLabel labelEditNama = new JLabel ("Nama");
    JLabel labelEditJmlPembelian = new JLabel ("Jumlah Pembelian");
    JLabel labelEditTotalHarga = new JLabel ("Total Harga");
    JLabel labelEditStatus = new JLabel("Status"); // Label untuk status
    
    JTextField editTanggal = new JTextField();
    JTextField editNama = new JTextField();
    JTextField editJmlPembelian = new JTextField();
    JTextField editTotalHarga = new JTextField();
    
    String[] statusOptions = { "Sukses", "Pending" };
    JComboBox<String> editStatus = new JComboBox<>(statusOptions); // JComboBox untuk status
    
    JButton tombolEdit = new JButton("Edit Data Transaksi");
    JButton tombolKembali = new JButton("Kembali");
    
    public EditDataTransaksi(ModelTransaksi transaksi){
        this.transaksi = transaksi;
        
        setVisible(true);
        setTitle("Edit Data Transaksi");
        setSize(560, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(135,65,330,35);
        add(labelEditTanggal);
        labelEditTanggal.setBounds(45,115,330,35);
        add(labelEditNama);
        labelEditNama.setBounds(45,180,330,35);
        add(labelEditJmlPembelian);
        labelEditJmlPembelian.setBounds(45,245,330,35);
        add(labelEditTotalHarga);
        labelEditTotalHarga.setBounds(45,310,330,35);
        add(labelEditStatus);
        labelEditStatus.setBounds(45,375,330,35); // Tambahkan label status
        
        add(editTanggal);
        editTanggal.setBounds(45,145,445,35);
        add(editNama);
        editNama.setBounds(45,210,445,35);
        add(editJmlPembelian);
        editJmlPembelian.setBounds(45,275,445,35);
        add(editTotalHarga);
        editTotalHarga.setBounds(45,340,445,35);
        add(editStatus);
        editStatus.setBounds(45,405,445,35); // Tambahkan JComboBox status
        
        add(tombolEdit);
        tombolEdit.setForeground(new Color(255, 215, 0));
        tombolEdit.setBackground(new Color(50,205,50));
        tombolEdit.setBounds(100,475,150,35);
        add(tombolKembali);
        tombolKembali.setForeground(new Color(255, 215, 0));
        tombolKembali.setBackground(new Color(255,0,0));
        tombolKembali.setBounds(300,475,150,35);
        
        editTanggal.setText(transaksi.getTanggal());
        editNama.setText(transaksi.getNama_produk());
        editJmlPembelian.setText(String.valueOf(transaksi.getJmlPembelian()));
        editTotalHarga.setText(String.valueOf(transaksi.getTotalHarga()));
        editStatus.setSelectedItem(transaksi.getStatus()); // Set status yang sesuai
        
//        if (transaksi.getStatus().equalsIgnoreCase("Sukses")) {
//            editStatus.setSelectedItem("Sukses");
//            editStatus.setEnabled(true); // Nonaktifkan JComboBox jika statusnya "sukses"
//        } else if (transaksi.getStatus().equalsIgnoreCase("Pending")) {
//            editStatus.setSelectedItem("Pending");
//        }
        
        controller = new ControllerTransaksi(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataTransaksi();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editTransaksi(transaksi.getNo_penjualan());
            }
        });
    }
    
    public String getEditTanggal(){
        return editTanggal.getText();
    }
    
    public String getEditNama(){
        return editNama.getText();
    }
    
    public String getEditJmlPembelian(){
        return editJmlPembelian.getText();
    }
    
    public String getEditTotalHarga(){
        return editTotalHarga.getText();
    }
    
    public String getEditStatus(){
        return (String) editStatus.getSelectedItem();
    }
}
