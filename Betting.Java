public class Betting {
    private double odds;
    private double betAmount;
    private double balance;

    public Betting() {
        this.balance = 1000.0; // Starting virtual currency
    }

    public void calculateOdds(Horse horse) {
        // Placeholder: Simple odds based on confidence
        this.odds = 1.0 / horse.getConfidence();
    }

    public void placeBet(double amount, Horse horse) {
        if (amount <= balance) {
            this.betAmount = amount;
            balance -= amount;
            calculateOdds(horse);
        }
    }

    public void resolveBet(boolean won) {
        if (won) {
            balance += betAmount * odds;
        }
        betAmount = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getOdds() {
        return odds;
    }
}