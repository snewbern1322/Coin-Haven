import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class homeScreenController {
    @FXML
    private Button createNewSavingsButton;

    @FXML
    private void handleCreateNewSavings() {
        // Logic for handling the "Create New Savings" button click
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("savingsAccountWindow.fxml"));
            Parent root = loader.load();

            // Create a new stage for the new savings window
            Stage newSavingsStage = new Stage();
            newSavingsStage.initModality(Modality.APPLICATION_MODAL);
            newSavingsStage.setTitle("Create New Savings Account");
            newSavingsStage.setScene(new Scene(root));

            // Show the new savings window
            newSavingsStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button createNewCheckingsButton;

    @FXML
    private void handleCreateNewCheckings() {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("checkingsAccountWindow.fxml"));
            Parent root = loader.load();

            // Create a new stage for the new savings window
            Stage newCheckingsStage = new Stage();
            newCheckingsStage.initModality(Modality.APPLICATION_MODAL);
            newCheckingsStage.setTitle("Create New Checkings Account");
            newCheckingsStage.setScene(new Scene(root));

            // Show the new Checkings window
            newCheckingsStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button addNewCardButton;

    @FXML
    private void handleAddNewCard() {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addCardWindow.fxml"));
            Parent root = loader.load();

            // Create a new stage for the new savings window
            Stage newCardStage = new Stage();
            newCardStage.initModality(Modality.APPLICATION_MODAL);
            newCardStage.setTitle("Add New Card");
            newCardStage.setScene(new Scene(root));

            // Show the new card window
            newCardStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

