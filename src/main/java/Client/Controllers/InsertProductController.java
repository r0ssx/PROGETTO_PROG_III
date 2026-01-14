package Client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsertProductController {
    @FXML
    public Label welcomeText;

    @FXML
    public TextField nameField;

    @FXML
    public TextField stockField;

    @FXML
    public TextField codeField;

    @FXML
    public TextField priceField;

    @FXML
    public TextArea descriptionField;

    @FXML
    public TextField categoryField;

    @FXML
    public void submitClick() {
        System.out.println("submitClick");
    }

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }
}
