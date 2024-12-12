import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MovieSelection {
    JFrame frame;
    private final Map<String, String[]> movies = new HashMap<>() {{
        put("Avengers - Studio 1", new String[]{"13:00", "15:40", "18:10", "20:30"});
        put("Final Destination - Studio 2", new String[]{"12:30", "14:10", "15:50", "17:30", "19:10", "20:50"});
        put("Moana 2 - Studio 3", new String[]{"12:00", "13:50", "15:30", "17:10", "18:50", "20:30"});
        put("Agak Laen - Studio 4", new String[]{"12:00", "14:10", "16:20", "18:30", "20:40"});
    }};
    
    private final Map<String, String> movieImages = new HashMap<>() {{
        put("Avengers - Studio 1", "images/avengers.jpeg");
        put("Final Destination - Studio 2", "images/finaldestination.jpeg");
        put("Moana 2 - Studio 3", "images/moana2.jpeg");
        put("Agak Laen - Studio 4", "images/agaklaen.jpeg");
    }};

    public MovieSelection() {
        frame = new JFrame("Daftar Film");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, movies.size(), 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel instructionLabel = new JLabel("Pilih Film yang Tersedia", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(instructionLabel);

        for (Map.Entry<String, String[]> entry : movies.entrySet()) {
            String movieTitle = entry.getKey();
            String[] times = entry.getValue();
            String imagePath = movieImages.get(movieTitle);

            JPanel moviePanel = new JPanel(new BorderLayout());
            JLabel posterLabel = new JLabel();
            if (imagePath != null) {
                ImageIcon movieIcon = new ImageIcon(imagePath);
                Image scaledImage = movieIcon.getImage().getScaledInstance(240, 320, Image.SCALE_SMOOTH);
                posterLabel.setIcon(new ImageIcon(scaledImage));
            }
            posterLabel.setHorizontalAlignment(JLabel.CENTER);

            JButton selectButton = new JButton(movieTitle);
            selectButton.addActionListener(e -> {
                frame.dispose();
                new SeatSelection(movieTitle, times);
            });

            moviePanel.add(posterLabel, BorderLayout.CENTER);
            moviePanel.add(selectButton, BorderLayout.SOUTH);
            panel.add(moviePanel);
        }

        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}