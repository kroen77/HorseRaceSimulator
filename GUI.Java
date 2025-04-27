import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
@Override
public void start(Stage primaryStage) {
VBox root = new VBox(10);
Scene scene = new Scene(root, 600, 400);

// Track configuration
Label trackLabel = new Label("Track Configuration");
TextField trackLengthField = new Text