import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Menu extends JFrame {
    private JButton DersKayit;
    private JPanel panel1;
    private JLabel baslik;
    private JButton OgrenciKayit;

    public Menu() {
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel1);
        OgrenciKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciForm ogrenciForm = new OgrenciForm();
                ogrenciForm.setVisible(true);

            }
        });
        DersKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DersForm dersform = new DersForm();
                dersform.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
    }

}

