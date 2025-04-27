import java.util.Random;

public class Race {
    private Horse[] horses;
    private int raceLength;
    private Random random;

    public Race(int raceLength, int numLanes) {
        this.raceLength = raceLength;
        this.horses = new Horse[numLanes];
        this.random = new Random();
    }

    public void addHorse(Horse horse, int lane) {
        if (lane >= 0 && lane < horses.length) {
            horses[lane] = horse;
        }
    }

    public Horse[] getHorses() {
        return horses;
    }

    public void startRace() {
        while (true) {
            // Update all horses
            for (Horse horse : horses) {
                if (horse != null && !horse.hasFallen() && horse.getDistanceTravelled() < raceLength) {
                    if (random.nextDouble() < horse.getConfidence()) {
                        horse.moveForward();
                    }
                    if (random.nextDouble() < horse.getConfidence() * 0.02) {
                        horse.fall();
                    }
                }
            }

            // Check for winner
            for (Horse horse : horses) {
                if (horse != null && horse.getDistanceTravelled() >= raceLength && !horse.hasFallen()) {
                    displayRace();
                    System.out.println("And the winner is… " + horse.getName() + "!");
                    return;
                }
            }

            // Display current state
            displayRace();

            // Wait for animation effect
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayRace() {
        System.out.println("==================");
        for (Horse horse : horses) {
            if (horse != null) {
                StringBuilder track = new StringBuilder();
                for (int j = 0; j < raceLength; j++) {
                    if (j == horse.getDistanceTravelled() && !horse.hasFallen()) {
                        track.append(horse.getSymbol());
                    } else {
                        track.append('-');
                    }
                }
                if (horse.hasFallen()) {
                    System.out.println("| ❌ | " + horse.getName() + " (Current confidence " + horse.getConfidence() + ")");
                } else {
                    System.out.println("| " + track + " | " + horse.getName() + " (Current confidence " + horse.getConfidence() + ")");
                }
            } else {
                System.out.println("| " + "-".repeat(raceLength) + " | Empty");
            }
        }
        System.out.println("==================");
    }

    public static void main(String[] args) {
        Race race = new Race(10, 3);
        race.startRace();
        race.addHorse(new Horse('♘', "PIPPI", 0.6), 0);
        race.addHorse(new Horse('♞', "KOKOMO", 0.6), 1);
        race.addHorse(new Horse('♝', "EL JEFE", 0.4), 2);
        race.startRace();
    }
}