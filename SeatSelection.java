import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SeatSelection extends BaseFrame {
    private final String movie;
    private final String[] times;
    private String selectedTime;
    private int ticketCount;
    private final List<String> selectedSeats = new ArrayList<>();
    private static final Set<String> bookedSeats = new HashSet<>();
    private static final int TICKET_PRICE = 25000;

    public SeatSelection(String movie, String[] times) {
        super("Pilih Kursi", 800, 600);
        this.movie = movie;
        this.times = times;

        JPanel timePanel = new JPanel(new FlowLayout());
        JComboBox<String> timeComboBox = new JComboBox<>(times);
        JTextField ticketField = new JTextField(5);

        JButton proceedButton = new JButton("Lanjut");
        proceedButton.addActionListener(e -> {
            try {
                selectedTime = (String) timeComboBox.getSelectedItem();
                ticketCount = Integer.parseInt(ticketField.getText());
                if (ticketCount <= 0) throw new NumberFormatException();
                showSeatsPanel();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan jumlah tiket yang valid.");
            }
        });

        timePanel.add(new JLabel("Pilih Waktu: "));
        timePanel.add(timeComboBox);
        timePanel.add(new JLabel("Jumlah Tiket: "));
        timePanel.add(ticketField);
        timePanel.add(proceedButton);

        add(timePanel, BorderLayout.NORTH);
        setVisible(true);
    }

    private void showSeatsPanel() {
        JPanel seatsPanel = new JPanel(new GridLayout(10, 20, 5, 5));
        for (char row = 'A'; row <= 'J'; row++) {
            for (int col = 1; col <= 20; col++) {
                String seat = row + String.valueOf(col);
                JButton seatButton = new JButton(seat);
                if (bookedSeats.contains(seat)) {
                    seatButton.setEnabled(false);
                    seatButton.setBackground(Color.GRAY);
                }
                seatButton.addActionListener(e -> {
                    if (selectedSeats.contains(seat)) {
                        selectedSeats.remove(seat);
                        seatButton.setBackground(null);
                    } else if (selectedSeats.size() < ticketCount) {
                        selectedSeats.add(seat);
                        seatButton.setBackground(Color.GREEN);
                    }
                });
                seatsPanel.add(seatButton);
            }
        }

        JButton confirmButton = new JButton("Lanjut ke Pembayaran");
        confirmButton.addActionListener(e -> {
            if (selectedSeats.size() == ticketCount) {
                bookedSeats.addAll(selectedSeats);
                dispose();
                new PaymentPage(movie, selectedTime, String.join(", ", selectedSeats), ticketCount * TICKET_PRICE);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih semua kursi terlebih dahulu.");
            }
        });

        add(seatsPanel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}