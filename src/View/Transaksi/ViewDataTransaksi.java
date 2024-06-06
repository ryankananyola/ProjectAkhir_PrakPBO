package View.Transaksi;

import Controller.ControllerTransaksi;
import Model.Transaksi.ModelTransaksi;
import View.HalamanUtamaAdmin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewDataTransaksi extends JFrame{
    Integer baris;
    
    ControllerTransaksi controller;
    
    JLabel Header = new JLabel("DAFTAR TRANSAKSI");
    
    JButton tombolTambah = new JButton("Tambah Transaksi");
    JButton tombolEdit = new JButton("Edit Transaksi");
    JButton tombolHapus = new JButton("Hapus Transaksi");
    JButton tombolKembali = new JButton("Kembali Menu Utama");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    String namaKolom[] = {"No Penjualan", "Tanggal", "Nama Produk", "Jumlah Penjualan", "Total Harga"};
    
    public ViewDataTransaksi(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setVisible(true);
        setTitle("Daftar Transaksi");
        setSize(600, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 222, 179));
        
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(175,65,330,35);
     
        add(scrollPane);
        scrollPane.setBounds(38,120,512,320);
        
        add(tombolTambah);
        tombolTambah.setForeground(new Color(245,245,220));
        tombolTambah.setBackground(new Color(50,205,50));
        tombolTambah.setBounds(50,475,150,35);
        add(tombolEdit);
        tombolEdit.setForeground(new Color(245,245,220));
        tombolEdit.setBackground(new Color(0,191,255));
        tombolEdit.setBounds(220,475,150,35);
        add(tombolHapus);
        tombolHapus.setForeground(new Color(245,245,220));
        tombolHapus.setBackground(new Color(255,0,0));
        tombolHapus.setBounds(390,475,150,35);
        add(tombolKembali);
        tombolKembali.setForeground(new Color(0,0,0));
        tombolKembali.setBackground(new Color(255,215,0));
        tombolKembali.setBounds(200,535,190,35);
        
        controller = new ControllerTransaksi(this);
        controller.showALLTransaksi();
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = tabel.getSelectedRow();
            }
        });
        
        tombolTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataTransaksi();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (baris != null){
                    ModelTransaksi transaksiTerpilih = new ModelTransaksi();
                    
                    Integer no_penjualan = (int) tabel.getValueAt(baris, 0);
                    String tanggal = tabel.getValueAt(baris, 1).toString();
                    String nama_produk = tabel.getValueAt(baris, 2).toString();
                    Integer jumlah = (int) tabel.getValueAt(baris, 3);
                    Integer total = (int) tabel.getValueAt(baris, 4);
                    
                    
                    transaksiTerpilih.setNo_penjualan(no_penjualan);
                    transaksiTerpilih.setTanggal(tanggal);
                    transaksiTerpilih.setNama_produk(nama_produk);
                    transaksiTerpilih.setJmlPembelian(jumlah);
                    transaksiTerpilih.setTotalHarga(total);
                    
                    System.out.println("Berhasil");
                    
                    dispose();
                    new EditDataTransaksi(transaksiTerpilih);
                } else{
                    System.out.println("gagal");
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null){
                   controller.hapusTransaksi(baris);
                   
                   baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
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
    public JTable getTableTransaksi(){
        return tabel;
    }
}
