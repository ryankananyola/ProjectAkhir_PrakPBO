package View.UserByUser;

import Controller.ControllerAdmin;
import Model.Admin.ModelUserByAdmin;
import View.HalamanUtamaUser;
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

public class ViewByUser  extends JFrame{
    Integer baris;

    ControllerAdmin controller;

    JLabel Header = new JLabel("DATA USER");
   
    JButton tombolEdit = new JButton("Edit User");
    JButton tombolKembali = new JButton ("Kembali");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIM", "Username", "Password"};

    public ViewByUser() {
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
        
        add(tombolEdit);
        tombolEdit.setForeground(new Color(245, 245, 220));
        tombolEdit.setBackground(new Color(0, 191, 255));
        tombolEdit.setBounds(390, 475, 150, 35);
        
        add(tombolKembali);
        tombolKembali.setForeground(new Color(0, 0, 0));
        tombolKembali.setBackground(new Color(255, 215, 0));
        tombolKembali.setBounds(370, 535, 190, 35);
        
        scrollPane.setBounds(200,120,512,320);
        
        controller = new ControllerAdmin(this);
        controller.showALLUser();
        
        tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = tabel.getSelectedRow();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null){
                    ModelUserByAdmin userTerpilih = new ModelUserByAdmin();
                    
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
                    new EditByUser(userTerpilih);
                } else{
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HalamanUtamaUser();
            }
            
        });
        
       
    }
    public JTable getTableUser(){
        return tabel;
    }
}
