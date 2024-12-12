import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MovieSelection extends BaseFrame {
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
        super("Daftar Film", 800, 600);

        JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (Map.Entry<String, String[]> entry : movies.entrySet()) {
            String movieTitle = entry.getKey();
            String[] times = entry.getValue();
            String imagePath = movieImages.get(movieTitle);

            JButton movieButton = new JButton(movieTitle, createScaledIcon(imagePath, 150, 200));
            movieButton.setHorizontalTextPosition(SwingConstants.CENTER);
            movieButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            movieButton.addActionListener(e -> {
                dispose();
                new SeatSelection(movieTitle, times);
            });
            panel.add(movieButton);
        }

        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        add(panel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private ImageIcon createScaledIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}