package View.Produk;

import Controller.ControllerProduk;
import Model.Produk.ModelProduk;
import View.HalamanUtamaAdmin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewDataProduk extends JFrame {

    Integer baris;

    ControllerProduk controller;

    JLabel Header = new JLabel("DAFTAR PRODUK");

    JButton tombolTambah = new JButton("Tambah Produk");
    JButton tombolEdit = new JButton("Edit Produk");
    JButton tombolHapus = new JButton("Hapus Produk");
    JButton tombolKembali = new JButton("Kembali Menu Utama");
    JButton tombolFilter = new JButton("Filter");

    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;

    JLabel filterKategoriLabel = new JLabel("Kategori:");
    JComboBox<String> filterKategori;

    String namaKolom[] = {"ID", "Nama Produk", "Harga", "Kategori"};

    public ViewDataProduk() {
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

        add(tombolTambah);
        tombolTambah.setForeground(new Color(245, 245, 220));
        tombolTambah.setBackground(new Color(50, 205, 50));
        tombolTambah.setBounds(50, 475, 150, 35);

        add(tombolEdit);
        tombolEdit.setForeground(new Color(245, 245, 220));
        tombolEdit.setBackground(new Color(0, 191, 255));
        tombolEdit.setBounds(220, 475, 150, 35);

        add(tombolHapus);
        tombolHapus.setForeground(new Color(245, 245, 220));
        tombolHapus.setBackground(new Color(255, 0, 0));
        tombolHapus.setBounds(390, 475, 150, 35);

        add(tombolKembali);
        tombolKembali.setForeground(new Color(0, 0, 0));
        tombolKembali.setBackground(new Color(255, 215, 0));
        tombolKembali.setBounds(200, 535, 190, 35);

        add(filterKategoriLabel);
        filterKategoriLabel.setBounds(50, 400, 100, 25);

        add(filterKategori);
        filterKategori.setBounds(150, 400, 100, 25);

        add(tombolFilter);
        tombolFilter.setBounds(270, 400, 100, 25);

        controller = new ControllerProduk(this);
        controller.showAllProduk();

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = tabel.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataProduk();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelProduk produkTerpilih = new ModelProduk();

                    Integer id = (int) tabel.getValueAt(baris, 0);
                    String nama_produk = tabel.getValueAt(baris, 1).toString();
                    String harga = tabel.getValueAt(baris, 2).toString();
                    String kategori = tabel.getValueAt(baris, 3).toString();

                    produkTerpilih.setID(id);
                    produkTerpilih.setNama_produk(nama_produk);
                    produkTerpilih.setHarga(harga);
                    produkTerpilih.setKategori(kategori);

                    dispose();
                    new EditDataProduk(produkTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.hapusProduk(baris);
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
