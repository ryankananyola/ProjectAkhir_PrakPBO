package View.ProdukUser;

import Controller.ControllerProdukUser;
import View.HalamanUtamaUser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewDataProdukUser extends JFrame {

    Integer baris;

    ControllerProdukUser controller;

    JLabel Header = new JLabel("DAFTAR PRODUK");

    JButton tombolBeli = new JButton("Beli Produk");
    JButton tombolKembali = new JButton("Kembali Menu Utama");
    JButton tombolFilter = new JButton("Filter");

    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;

    JLabel filterKategoriLabel = new JLabel("Kategori:");
    JComboBox<String> filterKategori;

    String namaKolom[] = {"ID", "Nama Produk", "Harga", "Kategori"};

    public ViewDataProdukUser() {
        tabelModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tabelModel);
        scrollPane = new JScrollPane(tabel);

        filterKategori = new JComboBox<>(new String[]{"Semua", "Pria", "Wanita"});

        setVisible(true);
        setTitle("Daftar Produk");
        setSize(600, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 222, 179));

        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(175, 15, 330, 35);

        add(scrollPane);
        scrollPane.setBounds(38, 60, 512, 320);
        
        add(tombolBeli);
        tombolBeli.setForeground(new Color(255,255,255));
        tombolBeli.setBackground(Color.GREEN);
        tombolBeli.setBounds(235,450, 120, 25);
        
        add(tombolKembali);
        tombolKembali.setForeground(new Color(0, 0, 0));
        tombolKembali.setBackground(new Color(255, 215, 0));
        tombolKembali.setBounds(200, 535, 190, 35);

        add(filterKategoriLabel);
        filterKategoriLabel.setBounds(75, 400, 100, 20);

        add(filterKategori);
        filterKategori.setBounds(150, 400, 100, 20);

        add(tombolFilter);
        tombolFilter.setBounds(270, 400, 80, 20);
        
        
        controller = new ControllerProdukUser(this);
        controller.showAllProduk();

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = tabel.getSelectedRow();
            }
        });
        
        tombolBeli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BeliByUser();
            }
        });

        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtamaUser();
            }
        });

        tombolFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKategori = filterKategori.getSelectedItem().toString();
                controller.filterProduk(selectedKategori);
            }
        });
    }

    public DefaultTableModel getTableModel() {
        return tabelModel;
    }

    public JTable getTableProduk() {
        return tabel;
    }
}