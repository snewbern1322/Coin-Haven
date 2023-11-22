import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addSavingsController {
    @FXML
    private TextField savingsName;
    @FXML
    private DatePicker savingsDate;
    @FXML
    private TextField savingsBalance;
    @FXML
    private Button confirmButton;

    @FXML
    private void handleConfirmButton() {
         // Logic for handling the "Confirm" button click
         String accountName = savingsName.getText();
         String dateCreated = savingsDate.getEditor().getText();
         String startingBalance = savingsBalance.getText();

         // Call a method to add the checking account to the database
        Database2.addSavingsAccount(accountName, dateCreated, startingBalance);

        //close window
        closeWindow();
    }
    private void closeWindow() {
        // Get the current stage
        Stage stage = (Stage) confirmButton.getScene().getWindow();

        // Close the stage
        stage.close();
    }
}
