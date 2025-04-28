package Part2;

import javax.swing.*;
import java.awt.*;
import Part1.Horse;
import Part1.Race;

public class GUI extends JFrame {
    protected JTextField trackLengthField;
    protected JButton startButton;

    public GUI(String title) {
        super(title);
        setLayout(new FlowLayout());

        JLabel trackLengthLabel = new JLabel("Track Length:");
        trackLengthField = new JTextField("10", 5);
        add(trackLengthLabel);
        add(trackLengthField);

        startButton = new JButton("Start Race");
        add(startButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public int getTrackLength() {
        try {
            return Integer.parseInt(trackLengthField.getText());
        } catch (NumberFormatException e) {
            return 10;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI("Horse Race Configuration"));
    }
}
