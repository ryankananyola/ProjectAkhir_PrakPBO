package View.ProdukUser;

import Controller.ControllerTransaksi;
import View.HalamanUtamaUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RiwayatBeli extends JFrame{
    ControllerTransaksi controller;
    
    JLabel Header = new JLabel("RIWAYAT TRANSAKSI");
    
    JButton tombolKembali = new JButton ("Kembali");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"No Penjualan", "Tanggal", "Nama Produk", "Jumlah Pembelian", "Total Harga", "Status"};
    
    public RiwayatBeli(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setVisible(true);
        setTitle("Halaman Riwayat Transaksi");
        setSize(930, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));

        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(295,65,330,35);
     
        add(scrollPane);
        scrollPane.setBounds(80,120,750,320);
        
        add(tombolKembali);
        tombolKembali.setForeground(Color.white);
        tombolKembali.setBackground(Color.red);
        tombolKembali.setBounds(370,475,150,35);
        
        controller = new ControllerTransaksi(this);
        controller.lihatSemuaRiwayat();
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtamaUser();
            }
        });
    }
    
    public JTable getTableRiwayat(){
        return tabel;
    }
}
