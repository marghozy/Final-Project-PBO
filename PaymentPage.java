import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class PaymentPage {
    JFrame frame;
    String movie;
    String time;
    String seats;
    int totalPrice;

    public PaymentPage(String movie, String time, String seats, int totalPrice) {
        this.movie = movie;
        this.time = time;
        this.seats = seats;
        this.totalPrice = totalPrice;

        NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));
        String formattedPrice = formatter.format(totalPrice);

        frame = new JFrame("Pembayaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel summaryLabel = new JLabel("Detail Tiket", JLabel.CENTER);
        summaryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(summaryLabel);

        JLabel movieLabel = new JLabel("Film: " + movie, JLabel.CENTER);
        panel.add(movieLabel);

        JLabel timeLabel = new JLabel("Waktu: " + time, JLabel.CENTER);
        panel.add(timeLabel);

        JLabel seatLabel = new JLabel("Kursi: " + seats, JLabel.CENTER);
        panel.add(seatLabel);

        JLabel priceLabel = new JLabel("Total Harga: Rp" + formattedPrice, JLabel.CENTER);
        panel.add(priceLabel);

        JButton confirmButton = new JButton("Konfirmasi dan Cetak Tiket");
        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Tiket berhasil dipesan!\nFilm: " + movie + "\nWaktu: " + time + "\nKursi: " + seats + "\nHarga: Rp" + formattedPrice);
            frame.dispose();
            new MainMenu();
        });
        panel.add(confirmButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}