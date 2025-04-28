package Part2;

public class Track {
    private int laneCount;
    private int length;
    private String shape;
    private String weather;

    public Track(int laneCount, int length, String shape, String weather) {
        this.laneCount = laneCount;
        this.length = length;
        this.shape = shape;
        this.weather = weather;
    }

    public int getLaneCount() {
        return laneCount;
    }

    public int getLength() {
        return length;
    }

    public String getShape() {
        return shape;
    }

    public String getWeather() {
        return weather;
    }

    // Placeholder: Methods to affect horse performance based on weather
    public double getSpeedModifier() {
        switch (weather) {
            case "Muddy": return 0.8;
            case "Icy": return 0.7;
            default: return 1.0;
        }
    }

    public double getFallRiskModifier() {
        switch (weather) {
            case "Icy": return 1.5;
            default: return 1.0;
        }
    }
}