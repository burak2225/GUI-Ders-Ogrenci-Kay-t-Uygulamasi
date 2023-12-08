import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OgrenciForm extends JFrame {


    private JLabel label1;
    private JTextArea textArea1;
    private JLabel label2;
    private JTextArea textArea2;
    private JLabel label3;
    private JTextArea textArea3;
    private JLabel label4;
    private JTextArea textArea4;
    private JButton btnOK;
    private JPanel panel2;
    private JButton btnMenu;
    private JLabel kontrollbl;
    private JComboBox comboBox1;

    private void kaydet(String dosyaAdi, Ogrenci ogrenci) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            writer.write("Öğrenci Adı: " + ogrenci.isim);
            writer.newLine();
            writer.write("Bölüm: " + ogrenci.bolum);
            writer.newLine();
            writer.write("Öğrenci Numarası: " + ogrenci.no);
            writer.newLine();
            writer.write("Dersler: " + ogrenci.dersler);
            writer.newLine();
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    class Ogrenci {
        public String isim;
        public String bolum;
        public String no;
        public String dersler;

        public Ogrenci(String isim, String bolum, String no, String dersler) {
            this.isim = isim;
            this.bolum = bolum;
            this.no = no;
            this.dersler = dersler;
        }
    }
    public OgrenciForm() {
        setTitle("Öğrenci Kayıt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel2);



        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ogrenciAdi = textArea1.getText();
                String bolum = textArea2.getText();
                String ogrenciNo = textArea3.getText();
                String dersler = (String) comboBox1.getSelectedItem();


                Ogrenci ogrenci = new Ogrenci(ogrenciAdi, bolum, ogrenciNo, dersler);
                kontrollbl.setText("Kayıt başarılı!");
                kaydet("ogrenci_bilgileri.txt", ogrenci);
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        OgrenciForm ogrenciform = new OgrenciForm();
        ogrenciform.setVisible(true);
    }
}