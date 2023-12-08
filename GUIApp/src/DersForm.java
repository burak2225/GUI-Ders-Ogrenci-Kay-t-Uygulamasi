import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DersForm extends JFrame {
    private JLabel labelkod;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton kaydetButton;
    private JButton menuButton;
    private JLabel kontroldl;
    private JPanel panel3;

    class Ders {
        public String kod;
        public String ad;
        public int donem;

        public Ders(String kod, String ad, int donem) {
            this.kod = kod;
            this.ad = ad;
            this.donem = donem;
        }
    }
    private void kaydet(String dosyaAdi, DersForm.Ders ders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            writer.write("Ders Kodu: " + ders.kod);
            writer.newLine();
            writer.write("Ders Adı: " + ders.ad);
            writer.newLine();
            writer.write("Ders Dönemi: " + ders.donem);
            writer.newLine();
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public DersForm() {
        setTitle("Ders Kayıt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel3);




        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String derskod = textField1.getText();
                String dersad = textField2.getText();
                int dersdonem = Integer.parseInt(textField3.getText());

                Ders ders = new Ders(derskod, dersad, dersdonem);
                kontroldl.setText("Kayıt Başarılı");
                kaydet("ders_bilgileri.txt", ders);
            }
        });

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        DersForm dersform = new DersForm();
        dersform.setVisible(true);
    }
}
