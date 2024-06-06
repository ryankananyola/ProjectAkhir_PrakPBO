package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HalamanAwal extends JFrame implements ActionListener{
    
    //Membuat JLabel
    JLabel Header = new JLabel("SELAMAT DATANG");
    JLabel SubHeader0 = new JLabel("DI");
    JLabel SubHeader1 = new JLabel("DATABASE TOKO SEPATU LARI");
    JLabel SubHeader2 = new JLabel("Aisyah Kusumawati | Yohanes Febryan Kana Nyola");
    JLabel Footer = new JLabel("Instagram : @aaisyahk._ & @ryankananyola");
    
    //Membuat JButton
    JButton tombolMulai = new JButton("Mulai");
    JButton tombolKeluar = new JButton("Keluar");
    
    public HalamanAwal(){
        
        //Membuat dan menampilkan JFrame
        setVisible(true);
        setTitle("Halaman Awal");
        setSize(1000, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 215, 0));
        
        //Menampilkan JLabel pada Frame
        add(Header);
        Header.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Header.setBounds(350,65,330,35);
        add(SubHeader0);
        SubHeader0.setFont(new Font("Times New Roman", Font.BOLD, 28));
        SubHeader0.setBounds(465,105,400,35);
        add(SubHeader1);
        SubHeader1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        SubHeader1.setBounds(300,145,400,35);
        add(SubHeader2);
        SubHeader2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        SubHeader2.setBounds(340,175,400,35);
        add(Footer);
        Footer.setFont(new Font("Calibri", Font.PLAIN, 12));
        Footer.setBounds(355,540,400,35);
        
        //Menampilkan JButton pada Frame
        add(tombolMulai);
        tombolMulai.setBounds(405,290,150,40);
        tombolMulai.setForeground(new Color(255, 215, 20));
        tombolMulai.setBackground(new Color(50,205,50));
        add(tombolKeluar);
        tombolKeluar.setBounds(405,350,150,40);
        tombolKeluar.setForeground(new Color(255, 215, 20));
        tombolKeluar.setBackground(new Color(255, 0, 0));
        
        tombolMulai.addActionListener(this);
        tombolKeluar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==tombolMulai){
                dispose();
                new LoginPage();
            } else if (e.getSource() == tombolKeluar){
                System.exit(0);
            }
        } catch (Exception error){
            JOptionPane.showMessageDialog(null,"");
        }
    }
}
