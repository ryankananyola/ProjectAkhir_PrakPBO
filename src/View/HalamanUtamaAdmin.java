package View;

import View.Produk.ViewDataProduk;
import View.Transaksi.ViewDataTransaksi;
import View.User.ViewDataUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HalamanUtamaAdmin extends JFrame implements ActionListener{
    
    //Membuat JLabel
    JLabel Header = new JLabel();
    JLabel SubHeader0 = new JLabel("Silahkan Pilih Menu");
    JLabel Footer = new JLabel("Instagram : @aaisyahk._ & @ryankananyola");
    
    //Membuat JButton
    JButton tombolProduk = new JButton("Produk");
    JButton tombolTransaksi = new JButton("Transaksi");
    JButton tombolKeluar = new JButton("Keluar");
    JButton tombolUser = new JButton("Lihat Data User");
            
    public HalamanUtamaAdmin(){
        //Membuat dan menampilkan JFrame
        setVisible(true);
        setTitle("Halaman Utama");
        setSize(1000, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        //Menampilkan JLabel pada Frame
        add(Header);
        Header.setText("Halo, Selamat Datang Tuan");
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(315,65,400,35);
        add(SubHeader0);
        SubHeader0.setFont(new Font("Times New Roman", Font.BOLD, 24));
        SubHeader0.setBounds(375,105,400,35);
        add(Footer);
        Footer.setFont(new Font("Calibri", Font.PLAIN, 12));
        Footer.setBounds(355,540,400,35);
        
        //Menampilkan JButton pada Frame
        add(tombolProduk);
        tombolProduk.setBounds(405,220,150,40);
        tombolProduk.setForeground(new Color(255, 215, 20));
        tombolProduk.setBackground(new Color(50,205,50));
        add(tombolTransaksi);
        tombolTransaksi.setBounds(405,280,150,40);
        tombolTransaksi.setForeground(new Color(255, 215, 20));
        tombolTransaksi.setBackground(new Color(25,25,112));
        add(tombolKeluar);
        tombolKeluar.setBounds(405,400,150,40);
        tombolKeluar.setForeground(new Color(255, 215, 20));
        tombolKeluar.setBackground(new Color(255, 0, 0));
        add(tombolUser);
        tombolUser.setBounds(800,65,130,15);
        tombolUser.setBackground(new Color(255, 215, 0));
        
        tombolProduk.addActionListener(this);
        tombolTransaksi.addActionListener(this);
        tombolKeluar.addActionListener(this);
        tombolUser.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==tombolProduk){
                dispose();
                new ViewDataProduk();
            } else if (e.getSource() == tombolTransaksi){
                dispose();
                new ViewDataTransaksi();
            } else if (e.getSource() == tombolKeluar){
                dispose();
                new HalamanAwal();
            } else if (e.getSource() == tombolUser){
                dispose();
                new ViewDataUser();
            }
        } catch (Exception error){
            JOptionPane.showMessageDialog(null,"");
        }
    }
}
