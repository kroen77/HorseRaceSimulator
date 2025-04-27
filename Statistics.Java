public class Statistics {
    private double averageSpeed;
    private double finishingTime;
    private double winRatio;

    public void updateStats(Horse horse, double raceTime, boolean won, int totalRaces) {
        // Placeholder: Calculate stats
        this.finishingTime = raceTime;
        this.averageSpeed = horse.getDistanceTravelled() / raceTime;
        this.winRatio = won ? 1.0 / totalRaces : 0.0;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public double getFinishingTime() {
        return finishingTime;
    }

    public double getWinRatio() {
        return winRatio;
    }

    // Placeholder: Method to display stats in GUI
    public String getStatsDisplay() {
        return "Avg Speed: " + averageSpeed + ", Time: " + finishingTime + ", Win Ratio: " + winRatio;
    }
}