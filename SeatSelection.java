import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeatSelection {
    private JFrame frame;
    private String selectedMovie;
    private String[] times;
    private String selectedTime;
    private int ticketCount;
    private List<String> selectedSeats = new ArrayList<>();
    private static final Set<String> bookedSeats = new HashSet<>();
    private static final int TICKET_PRICE = 25_000;

    public SeatSelection(String movie, String[] times) {
        this.selectedMovie = movie;
        this.times = times;

        frame = new JFrame("Pilih Kursi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel timePanel = new JPanel(new FlowLayout());
        JLabel timeLabel = new JLabel("Pilih Waktu: ");
        timePanel.add(timeLabel);

        JComboBox<String> timeComboBox = new JComboBox<>(times);
        timePanel.add(timeComboBox);

        JLabel ticketLabel = new JLabel("Jumlah Tiket: ");
        timePanel.add(ticketLabel);

        JTextField ticketField = new JTextField(5);
        timePanel.add(ticketField);

        JButton proceedButton = new JButton("Lanjut");
        proceedButton.addActionListener(e -> {
            try {
                selectedTime = (String) timeComboBox.getSelectedItem();
                ticketCount = Integer.parseInt(ticketField.getText());
                if (ticketCount <= 0) {
                    throw new NumberFormatException();
                }

                mainPanel.removeAll();
                mainPanel.add(generateSeatsPanel(), BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan jumlah tiket yang valid (angka > 0).");
            }
        });

        timePanel.add(proceedButton);
        mainPanel.add(timePanel, BorderLayout.NORTH);

        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            frame.dispose();
            new MovieSelection();
        });
        mainPanel.add(backButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel generateSeatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel infoLabel = new JLabel("Pilih " + ticketCount + " kursi:", JLabel.CENTER);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(infoLabel, BorderLayout.NORTH);

        JPanel seatsPanel = new JPanel(new GridLayout(10, 20, 5, 5));
        seatsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (char row = 'A'; row <= 'J'; row++) {
            for (int col = 1; col <= 20; col++) {
                String seat = row + String.valueOf(col);
                JButton seatButton = new JButton(seat);

                if (bookedSeats.contains(seat)) {
                    seatButton.setBackground(Color.GRAY);
                    seatButton.setEnabled(false);
                }

                seatButton.addActionListener(e -> {
                    if (selectedSeats.contains(seat)) {
                        selectedSeats.remove(seat);
                        seatButton.setBackground(null);
                    } else {
                        if (selectedSeats.size() < ticketCount) {
                            selectedSeats.add(seat);
                            seatButton.setBackground(Color.GREEN);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Anda hanya bisa memilih " + ticketCount + " kursi.");
                        }
                    }
                });

                seatsPanel.add(seatButton);
            }
        }

        JButton proceedButton = new JButton("Lanjut ke Pembayaran");
        proceedButton.addActionListener(e -> {
            if (selectedSeats.size() == ticketCount) {
                bookedSeats.addAll(selectedSeats);
                frame.dispose();
                new PaymentPage(selectedMovie, selectedTime, String.join(", ", selectedSeats), ticketCount * TICKET_PRICE);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih " + ticketCount + " kursi terlebih dahulu.");
            }
        });

        panel.add(seatsPanel, BorderLayout.CENTER);
        panel.add(proceedButton, BorderLayout.SOUTH);

        return panel;
    }
}