package Part1;

import java.util.concurrent.TimeUnit;

public class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    public Race(int length) {
        raceLength = length;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }

    public void addHorse(Horse h, int laneNumber) {
        if (laneNumber == 1) lane1Horse = h;
        else if (laneNumber == 2) lane2Horse = h;
        else if (laneNumber == 3) lane3Horse = h;
        else System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
    }

    public void startRace() {
        boolean finished = false;
        if (lane1Horse != null) lane1Horse.goBackToStart();
        if (lane2Horse != null) lane2Horse.goBackToStart();
        if (lane3Horse != null) lane3Horse.goBackToStart();
        while (!finished) {
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);
            printRace();
            if (raceWonBy(lane1Horse) || raceWonBy(lane2Horse) || raceWonBy(lane3Horse)) {
                finished = true;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {}
        }
    }

    public void moveHorse(Horse theHorse) {
        if (theHorse != null && !theHorse.hasFallen()) {
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
                theHorse.setConfidence(theHorse.getConfidence() - 0.1);
            }
        }
        if (theHorse != null && raceWonBy(theHorse)) {
            theHorse.setConfidence(theHorse.getConfidence() + 0.1);
        }
    }

    public boolean raceWonBy(Horse h) {
        return h != null && h.getDistanceTravelled() >= raceLength && !h.hasFallen();
    }

    private void printRace() {
        System.out.print('\u000C');
        multiplePrint('=', raceLength + 3);
        System.out.println();
        printLane(lane1Horse, "Lane 1");
        printLane(lane2Horse, "Lane 2");
        printLane(lane3Horse, "Lane 3");
        multiplePrint('=', raceLength + 3);
        System.out.println();
        if (raceWonBy(lane1Horse)) {
            System.out.println("And the winner is " + lane1Horse.getName());
        } else if (raceWonBy(lane2Horse)) {
            System.out.println("And the winner is " + lane2Horse.getName());
        } else if (raceWonBy(lane3Horse)) {
            System.out.println("And the winner is " + lane3Horse.getName());
        }
        if ((lane1Horse == null || lane1Horse.hasFallen()) && 
            (lane2Horse == null || lane2Horse.hasFallen()) && 
            (lane3Horse == null || lane3Horse.hasFallen())) {
            System.out.println("All horses have fallen or no horses in race. No winner.");
        }
    }

    private void printLane(Horse theHorse, String laneName) {
        if (theHorse == null) {
            System.out.println("| " + "-".repeat(raceLength) + " | " + laneName + " (Empty)");
            return;
        }
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        System.out.print('|');
        multiplePrint(' ', spacesBefore);
        if (theHorse.hasFallen()) {
            System.out.print('\u2322');
        } else {
            System.out.print(theHorse.getSymbol());
        }
        multiplePrint(' ', spacesAfter);
        System.out.print("| " + theHorse.getName() + " (Current confidence: " + 
                         String.format("%.1f", theHorse.getConfidence()) + ")");
        System.out.println();
    }

    private void multiplePrint(char c, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(c);
        }
    }

    public Horse getLane1Horse() { return lane1Horse; }
    public Horse getLane2Horse() { return lane2Horse; }
    public Horse getLane3Horse() { return lane3Horse; }

    public static void main(String[] args) {
        Race race = new Race(10);
        Horse horse1 = new Horse('♘', "PIPPI", 0.6);
        Horse horse2 = new Horse('♞', "KOKOMO", 0.6);
        Horse horse3 = new Horse('♝', "EL JEFE", 0.4);
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.startRace();
    }
}
