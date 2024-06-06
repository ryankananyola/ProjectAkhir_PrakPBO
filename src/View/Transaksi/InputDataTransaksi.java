package View.Transaksi;

import Controller.ControllerTransaksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.*;

public class InputDataTransaksi extends JFrame {
    ControllerTransaksi controller;

    JLabel Header = new JLabel("INPUT TRANSAKSI");
    JLabel labelInputTanggal = new JLabel("Tanggal");
    JLabel labelInputNama = new JLabel("Nama Produk");
    JLabel labelInputJumlah = new JLabel("Jumlah Pembelian");
    JLabel labelInputHarga = new JLabel("Total Harga");
    JLabel labelInputHargaSatuan = new JLabel("Harga Satuan");

    JLabel inputTanggal = new JLabel(LocalDate.now().toString());
    JComboBox<String> inputNama = new JComboBox<>();
    JTextField inputJumlah = new JTextField("");
    JTextField inputHargaSatuan = new JTextField("");
    JLabel inputHarga = new JLabel();

    JButton tombolTambah = new JButton("Tambah Transaksi");
    JButton tombolKembali = new JButton("Kembali");
    JButton tombolHitung = new JButton("Hitung");

    public InputDataTransaksi() {
        setVisible(true);
        setTitle("Input Transaksi");
        setSize(560, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));

        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(175, 65, 330, 35);
        
        add(labelInputTanggal);
        labelInputTanggal.setBounds(45, 115, 330, 35);
        add(inputTanggal);
        inputTanggal.setBounds(45, 145, 445, 35);
        
        add(labelInputNama);
        labelInputNama.setBounds(45, 185, 330, 35);
        add(inputNama);
        inputNama.setBounds(45, 215, 445, 35);
        
        add(labelInputJumlah);
        labelInputJumlah.setBounds(45, 255, 330, 35);
        add(inputJumlah);
        inputJumlah.setBounds(45, 285, 445, 35);
        
        add(labelInputHargaSatuan);
        labelInputHargaSatuan.setBounds(45, 325, 330, 35);
        add(inputHargaSatuan);
        inputHargaSatuan.setBounds(45, 355, 305, 35);
        
        add(labelInputHarga);
        labelInputHarga.setBounds(45, 395, 330, 35);
        
        add(inputHarga);
        inputHarga.setBounds(45, 425, 305, 35);
        
        add(tombolHitung);
        tombolHitung.setForeground(new Color(255, 215, 0));
        tombolHitung.setBackground(new Color(0, 0, 255));
        tombolHitung.setBounds(390, 355, 100, 35);
        
        add(tombolTambah);
        tombolTambah.setForeground(new Color(255, 215, 0));
        tombolTambah.setBackground(new Color(50, 205, 50));
        tombolTambah.setBounds(200, 505, 150, 35);
        
        add(tombolKembali);
        tombolKembali.setForeground(new Color(255, 215, 0));
        tombolKembali.setBackground(new Color(255, 0, 0));
        tombolKembali.setBounds(200, 555, 150, 35);

        controller = new ControllerTransaksi(this);

        populateProductNames();
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataTransaksi();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.inputTransaksi();
            }
        });

        tombolHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungTotalHarga();
            }
        });
        
        inputNama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaSatuan();
            }
        });
    }
    
    private void populateProductNames() {
        List<String> productNames = controller.getNamaProduk();
        for (String productName : productNames) {
            inputNama.addItem(productName);
        }
    }

    public String getInputTanggal() {
        return inputTanggal.getText();
    }

    public String getInputNama() {
        return (String) inputNama.getSelectedItem();
    }

    public String getInputJumlah() {
        return inputJumlah.getText();
    }

    public String getInputHarga() {
        return inputHarga.getText();
    }

    public String getInputHargaSatuan() {
        return inputHargaSatuan.getText();
    }

    private void hitungTotalHarga() {
        String jumlahInput = inputJumlah.getText();
        try {
             int jumlah = Integer.parseInt(jumlahInput);
             if (jumlah < 0) {
                throw new NumberFormatException();
              }
            int hargaSatuan = Integer.parseInt(inputHargaSatuan.getText());
            int totalHarga = jumlah * hargaSatuan;
            
            inputHarga.setText(String.valueOf(totalHarga));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah dalam bentuk angka positif.", "Error", JOptionPane.ERROR_MESSAGE);
            inputJumlah.setText(""); 
            inputHarga.setText("0");
        }
    }
    
    private void updateHargaSatuan() {
        String selectedProduct = (String) inputNama.getSelectedItem();
        int hargaSatuan = controller.getHargaSatuan(selectedProduct);
        inputHargaSatuan.setText(String.valueOf(hargaSatuan));
    }
}
