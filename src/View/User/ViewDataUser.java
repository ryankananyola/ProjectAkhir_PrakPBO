package View.User;

import Controller.ControllerUser;
import Model.User.ModelUser;
import View.HalamanUtamaAdmin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewDataUser extends JFrame {
    
    Integer baris;

    ControllerUser controller;

    JLabel Header = new JLabel("DATA USER");
    
    JButton tombolTambah = new JButton("Tambah User");
    JButton tombolHapus = new JButton("Hapus User");
    JButton tombolEdit = new JButton("Edit User");
    JButton tombolKembali = new JButton ("Kembali");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIM", "Username", "Password"};

    public ViewDataUser() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setVisible(true);
        setTitle("Halaman Data User");
        setSize(930, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));

        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(385,65,330,35);
     
        add(scrollPane);
        scrollPane.setBounds(38,120,510,320);
        
        add(tombolTambah);
        tombolTambah.setForeground(new Color(245, 245, 220));
        tombolTambah.setBackground(new Color(50, 205, 50));
        tombolTambah.setBounds(220, 475, 150, 35);

        add(tombolEdit);
        tombolEdit.setForeground(new Color(245, 245, 220));
        tombolEdit.setBackground(new Color(0, 191, 255));
        tombolEdit.setBounds(390, 475, 150, 35);

        add(tombolHapus);
        tombolHapus.setForeground(new Color(245, 245, 220));
        tombolHapus.setBackground(new Color(255, 0, 0));
        tombolHapus.setBounds(560, 475, 150, 35);

        add(tombolKembali);
        tombolKembali.setForeground(new Color(0, 0, 0));
        tombolKembali.setBackground(new Color(255, 215, 0));
        tombolKembali.setBounds(370, 535, 190, 35);
        
        scrollPane.setBounds(200,120,512,320);
        
        controller = new ControllerUser(this);
        controller.showALLUser();
        
        tabel.addMouseListener(new MouseAdapter(){
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
                new InputDataUser();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null){
                    ModelUser userTerpilih = new ModelUser();
                    
                    Integer id = (int) tabel.getValueAt(baris, 0);
                    String nama = tabel.getValueAt(baris, 1).toString();
                    String nim = tabel.getValueAt(baris, 2).toString();
                    String username = tabel.getValueAt(baris, 3).toString();
                    String password = tabel.getValueAt(baris, 4).toString();
                    
                    userTerpilih.setId(id);
                    userTerpilih.setNama(nama);
                    userTerpilih.setNim(nim);
                    userTerpilih.setUsername(username);
                    userTerpilih.setPassword(password);

                    dispose();
                    new EditDataUser(userTerpilih);
                } else{
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==tombolKembali){
                    dispose();
                    new HalamanUtamaAdmin();
                } else {
                    JOptionPane.showMessageDialog(null,"");
                }
            }
        });
        
        tombolHapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(baris != null){
                    controller.hapusUser(baris);
                    
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data Belum di Pilih");
                }
            }
        });
        
    }
    
    public JTable getTableUser(){
        return tabel;
    }
}
