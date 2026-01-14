package Client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecommendController {
    @FXML
    public TextField emailField;

    @FXML
    public void submitClick() {
        System.out.println("submitClick");
    }

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}
