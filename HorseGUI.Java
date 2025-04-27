public class HorseGUI extends Horse {
    private String breed;
    private String coatColor;
    private String equipment;

    public HorseGUI(char horseSymbol, String horseName, double horseConfidence, 
                    String breed, String coatColor, String equipment) {
        super(horseSymbol, horseName, horseConfidence);
        this.breed = breed;
        this.coatColor = coatColor;
        this.equipment = equipment;
    }

    public String getBreed() {
        return breed;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public String getEquipment() {
        return equipment;
    }

    // Placeholder: Method to adjust performance based on breed/equipment
    public double getSpeedModifier() {
        if ("Thoroughbred".equals(breed)) return 1.2;
        return 1.0;
    }
}