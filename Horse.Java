public class Horse {
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;

    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;
        if (horseConfidence >= 0 && horseConfidence <= 1) {
            this.confidence = horseConfidence;
        } else {
            this.confidence = 0.5; // Default value if invalid
        }
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public void fall() {
        this.hasFallen = true;
    }

    public double getConfidence() {
        return confidence;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public boolean hasFallen() {
        return hasFallen;
    }

    public void moveForward() {
        if (!hasFallen) {
            distanceTravelled++;
        }
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            this.confidence = newConfidence;
        }
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
}