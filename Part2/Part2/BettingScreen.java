package Part2;

import Part1.Horse;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BettingScreen {
    private Stage primaryStage;
    private List<Horse> horses;

    public BettingScreen(Stage primaryStage, List<Horse> horses) {
        this.primaryStage = primaryStage;
        this.horses = horses;
    }

    public void show() {
        VBox layout = new VBox(15.0);
        layout.setAlignment(Pos.CENTER);

        ComboBox<Horse> horseSelector = new ComboBox<>();
        horseSelector.getItems().addAll(this.horses);
        horseSelector.setPromptText("Select Horse");

        TextField betAmountField = new TextField();
        betAmountField.setPromptText("Enter Bet Amount");

        Button confirmBetButton = new Button("Confirm Bet");
        confirmBetButton.setOnAction(event -> {
            Horse selectedHorse = horseSelector.getValue();
            if (selectedHorse != null) {
                try {
                    double betAmount = Double.parseDouble(betAmountField.getText());
                    System.out.println("Bet placed on " + selectedHorse.getName() + " with amount: " + betAmount);
                    // Navigate to RaceGUI or another screen
                    new RaceGUI();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid bet amount. Please enter a valid number.");
                }
            } else {
                System.out.println("No horse selected. Please select a horse.");
            }
        });

        layout.getChildren().addAll(new Label("Place Your Bet"), horseSelector, betAmountField, confirmBetButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Place Your Bet");
        primaryStage.show();
    }
}
