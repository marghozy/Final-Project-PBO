import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class SeatSelection extends BaseFrame {
    private final String movie;
    private final String[] times;
    private String selectedTime;
    private int ticketCount = 1;
    private final List<String> selectedSeats = new ArrayList<>();
    private static final Map<String, Set<String>> bookedSeatsMap = new HashMap<>();
    private static final Map<String, String[]> movieDetails = new HashMap<>();

    static {
        movieDetails.put("Avengers - Studio 1", new String[]{"Tentang pahlawan terbaik Bumi yang menghadapi ancaman luar.", "143 menit", "PG-13", "25000"});
        movieDetails.put("Final Destination - Studio 2", new String[]{"Tentang sekelompok pelajar yang 'menipu kematian' setelah terhindar dari kecelakaan pesawat.", "98 menit", "PG-13", "25000"});
        movieDetails.put("Moana 2 - Studio 3", new String[]{"Menceritakan petualangan Moana dan Maui dalam menyelamatkan Pulau Motufetu.", "100 menit", "SU", "25000"});
        movieDetails.put("Agak Laen - Studio 4", new String[]{"Menceritakan lika-liku pertemanan 4 sahabat.", "119 menit", "PG-13", "25000"});
    }

    public SeatSelection(String movie, String[] times) {
        super("Pilih Jam Tayang", 800, 600);
        this.movie = movie;
        this.times = times;

        showTimeSelectionPanel();
    }

    private void showTimeSelectionPanel() {
        getContentPane().removeAll();

        String[] details = movieDetails.getOrDefault(movie, new String[]{"Tidak ada informasi", "-", "-", "0"});
        String sinopsis = details[0];
        String durasi = details[1];
        String ketentuanUsia = details[2];
        int hargaTiket = Integer.parseInt(details[3]);

        String formattedPrice = NumberFormat.getNumberInstance(new Locale("id", "ID")).format(hargaTiket);

        JPanel infoPanel = new JPanel(new GridLayout(5, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        infoPanel.add(new JLabel("Film: " + movie));
        infoPanel.add(new JLabel("Sinopsis: " + sinopsis));
        infoPanel.add(new JLabel("Durasi Film: " + durasi));
        infoPanel.add(new JLabel("Ketentuan Usia: " + ketentuanUsia));
        infoPanel.add(new JLabel("Harga Tiket: Rp" + formattedPrice));

        JPanel timePanel = new JPanel(new GridLayout(0, 3, 10, 10));
        timePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (String time : times) {
            JButton timeButton = new JButton(time);
            timeButton.addActionListener(e -> {
                selectedTime = time;
                showSeatsPanel(hargaTiket);
            });
            timePanel.add(timeButton);
        }

        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            dispose();
            new MovieSelection();
        });

        add(infoPanel, BorderLayout.NORTH);
        add(timePanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        revalidate();
        repaint();
        setVisible(true);
    }

    private void showSeatsPanel(int hargaTiket) {
        getContentPane().removeAll();

        JPanel topPanel = new JPanel(new FlowLayout());
        JTextField ticketField = new JTextField(String.valueOf(ticketCount), 5);
        JButton updateButton = new JButton("Ubah Jumlah Kursi");
        updateButton.addActionListener(e -> {
            try {
                ticketCount = Integer.parseInt(ticketField.getText());
                if (ticketCount <= 0) throw new NumberFormatException();
                JOptionPane.showMessageDialog(this, "Jumlah tiket diperbarui: " + ticketCount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan jumlah tiket yang valid.");
            }
        });

        topPanel.add(new JLabel("Jumlah Tiket: "));
        topPanel.add(ticketField);
        topPanel.add(updateButton);

        JPanel seatsPanel = new JPanel(new GridLayout(10, 20, 5, 5));
        String bookingKey = movie + "_" + selectedTime;
        bookedSeatsMap.putIfAbsent(bookingKey, new HashSet<>());

        for (char row = 'A'; row <= 'K'; row++) {
            if (row == 'I') continue;
            for (int col = 1; col <= 20; col++) {
                String seat = row + String.valueOf(col);
                JButton seatButton = new JButton(seat);
                if (bookedSeatsMap.get(bookingKey).contains(seat)) {
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
                bookedSeatsMap.get(bookingKey).addAll(selectedSeats);
                dispose();
                int totalHarga = ticketCount * hargaTiket;
                new PaymentPage(movie, selectedTime, String.join(", ", selectedSeats), totalHarga);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih semua kursi terlebih dahulu.");
            }
        });

        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            showTimeSelectionPanel();
        });

        add(topPanel, BorderLayout.NORTH);
        add(seatsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(backButton);
        bottomPanel.add(confirmButton);
        add(bottomPanel, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }
}
