import javax.swing.*;
import java.awt.*;

public class MainMenu extends BaseFrame {
    public MainMenu() {
        super("Cinema Ticket System", 500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Selamat Datang di Cinema Ticket System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel);

        JButton viewMoviesButton = new JButton("Lihat Jadwal Film");
        viewMoviesButton.addActionListener(e -> {
            dispose();
            new MovieSelection();
        });
        panel.add(viewMoviesButton);

        JButton exitButton = new JButton("Keluar");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }
}