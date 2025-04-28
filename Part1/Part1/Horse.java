package Part1;

public class Horse {
    private char symbol;
    private String name;
    private double confidence;
    private int distanceTravelled;
    private boolean hasFallen;

    public Horse(char symbol, String name, double confidence) {
        this.symbol = symbol;
        this.name = name;
        this.confidence = confidence;
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public char getSymbol() { return symbol; }
    public String getName() { return name; }
    public double getConfidence() { return confidence; }
    public void setConfidence(double confidence) { this.confidence = Math.max(0.1, Math.min(0.9, confidence)); }
    public int getDistanceTravelled() { return distanceTravelled; }
    public boolean hasFallen() { return hasFallen; }
    public void fall() { this.hasFallen = true; }
    public void moveForward() { this.distanceTravelled++; }
    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
}
