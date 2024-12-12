import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class PaymentPage extends BaseFrame {
    public PaymentPage(String movie, String time, String seats, int totalPrice) {
        super("Pembayaran", 400, 300);

        NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));
        String formattedPrice = formatter.format(totalPrice);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Detail Tiket", JLabel.CENTER));
        panel.add(new JLabel("Film: " + movie, JLabel.CENTER));
        panel.add(new JLabel("Waktu: " + time, JLabel.CENTER));
        panel.add(new JLabel("Kursi: " + seats, JLabel.CENTER));
        panel.add(new JLabel("Total Harga: Rp" + formattedPrice, JLabel.CENTER));

        JButton confirmButton = new JButton("Konfirmasi dan Cetak Tiket");
        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Tiket berhasil dipesan!");
            dispose();
            new MainMenu();
        });
        panel.add(confirmButton);

        add(panel);
        setVisible(true);
    }
}