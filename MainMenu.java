import javax.swing.*;
import java.awt.*;

public class MainMenu {
    JFrame frame;

    public MainMenu() {
        frame = new JFrame("Cinema Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Selamat Datang di Cinema Ticket System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel);

        JButton viewMoviesButton = new JButton("Lihat Jadwal Film");
        viewMoviesButton.setFont(new Font("Arial", Font.PLAIN, 14));
        viewMoviesButton.addActionListener(e -> {
            frame.dispose();
            new MovieSelection();
        });
        panel.add(viewMoviesButton);

        JButton exitButton = new JButton("Keluar");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}