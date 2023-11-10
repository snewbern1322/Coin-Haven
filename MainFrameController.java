// handles the logic for the main landing page
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainFrameController {
    @FXML
    private Label welcomeLabel;

    public void initialize() {
        // Initialization logic, if needed
        
        welcomeLabel.setText("Welcome to Coin Haven Main Frame!");
    }

    // Additional logic for the main frame goes here
}
