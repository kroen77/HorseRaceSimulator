package Part2;

import java.awt.*;
import javax.swing.*;
import Part1.Horse;
import Part1.Race;

public class RaceGUI extends JFrame {
    private Race race;
    private JLabel lane1Label, lane2Label, lane3Label, winnerLabel;
    private JButton startButton;

    public RaceGUI() {
        race = new Race(10);
        race.addHorse(new Horse('♘', "PIPPI", 0.6), 1);
        race.addHorse(new Horse('♞', "KOKOMO", 0.6), 2);
        race.addHorse(new Horse('♝', "EL JEFE", 0.4), 3);

        setTitle("Horse Race Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 400));
        setLayout(new BorderLayout());

        JPanel racePanel = new JPanel();
        racePanel.setLayout(new GridLayout(4, 1));
        lane1Label = new JLabel("PIPPI: ");
        lane2Label = new JLabel("KOKOMO: ");
        lane3Label = new JLabel("EL JEFE: ");
        winnerLabel = new JLabel("Winner: ");
        racePanel.add(lane1Label);
        racePanel.add(lane2Label);
        racePanel.add(lane3Label);
        racePanel.add(winnerLabel);
        add(racePanel, BorderLayout.CENTER);

        startButton = new JButton("Start Race");
        startButton.addActionListener(e -> startRace());
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startRace() {
        startButton.setEnabled(false);
        new Thread(() -> {
            boolean finished = false;
            race.getLane1Horse().goBackToStart();
            race.getLane2Horse().goBackToStart();
            race.getLane3Horse().goBackToStart();
            while (!finished) {
                race.moveHorse(race.getLane1Horse());
                race.moveHorse(race.getLane2Horse());
                race.moveHorse(race.getLane3Horse());
                updateLabels();
                if (race.raceWonBy(race.getLane1Horse()) || race.raceWonBy(race.getLane2Horse()) || race.raceWonBy(race.getLane3Horse())) {
                    finished = true;
                    if (race.raceWonBy(race.getLane1Horse())) winnerLabel.setText("Winner: PIPPI");
                    else if (race.raceWonBy(race.getLane2Horse())) winnerLabel.setText("Winner: KOKOMO");
                    else if (race.raceWonBy(race.getLane3Horse())) winnerLabel.setText("Winner: EL JEFE");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {}
            }
            startButton.setEnabled(true);
        }).start();
    }

    private void updateLabels() {
        Horse h1 = race.getLane1Horse();
        Horse h2 = race.getLane2Horse();
        Horse h3 = race.getLane3Horse();
        lane1Label.setText("PIPPI: " + "=".repeat(h1.getDistanceTravelled()) + (h1.hasFallen() ? " [Fallen]" : ""));
        lane2Label.setText("KOKOMO: " + "=".repeat(h2.getDistanceTravelled()) + (h2.hasFallen() ? " [Fallen]" : ""));
        lane3Label.setText("EL JEFE: " + "=".repeat(h3.getDistanceTravelled()) + (h3.hasFallen() ? " [Fallen]" : ""));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RaceGUI());
    }
}
