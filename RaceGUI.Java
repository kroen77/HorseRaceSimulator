import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RaceGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Horse Race Simulator");
        primaryStage.setScene(scene);

        // Track configuration
        Label trackLabel = new Label("Track Configuration");
        TextField trackLengthField = new TextField("10");
        ComboBox<String> trackShapeCombo = new ComboBox<>();
        trackShapeCombo.getItems().addAll("Oval", "Figure-eight", "Custom");
        trackShapeCombo.setValue("Oval");
        ComboBox<String> weatherCombo = new ComboBox<>();
        weatherCombo.getItems().addAll("Dry", "Muddy", "Icy");
        weatherCombo.setValue("Dry");

        // Horse customization
        Label horseLabel = new Label("Horse Customization");
        TextField horseNameField = new TextField("PIPPI");
        TextField horseSymbolField = new TextField("♘");
        TextField horseConfidenceField = new TextField("0.6");

        // Start race button
        Button startButton = new Button("Start Race");
        startButton.setOnAction(e -> {
            // Placeholder: Implement race simulation with GUI
            System.out.println("Starting race with track length: " + trackLengthField.getText());
        });

        root.getChildren().addAll(trackLabel, trackLengthField, trackShapeCombo, weatherCombo,
                horseLabel, horseNameField, horseSymbolField, horseConfidenceField, startButton);

        primaryStage.show();
    }

    public static void startRaceGUI() {
        launch();
    }

    public static void main(String[] args) {
        startRaceGUI();
    }
}