import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorGUI extends JFrame {
    private JTextField textField;

    public KalkulatorGUI() {
        setTitle("Kalkulator Sederhana");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center

        // Panel utama
        setLayout(new BorderLayout());

        // Text field untuk input/output
        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Panel tombol
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(5, 4, 5, 5));

        // Label tombol sesuai gambar
        String[] tombol = {
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "0", "+", "-",
            "*", "/", "=", "%",
            "Mod", "Exit", "", "" // Dua kosong untuk padding
        };

        for (String t : tombol) {
            if (t.equals("")) {
                panelTombol.add(new JLabel()); // ruang kosong
            } else {
                JButton btn = new JButton(t);
                btn.addActionListener(new ButtonHandler());
                panelTombol.add(btn);
            }
        }

        add(panelTombol, BorderLayout.CENTER);
    }

    // Handler tombol
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("Exit")) {
                System.exit(0);
            } else {
                textField.setText(textField.getText() + cmd);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KalkulatorGUI().setVisible(true);
        });
    }
}
