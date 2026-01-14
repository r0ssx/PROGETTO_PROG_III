package Client.Controllers;

import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.AdminRecommendsRequestCommand;
import Client.Utilities.SingletonSession;
import Shared.GsonAdapters.RecommendPacket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RecommendController {
    @FXML
    public TextField emailField;

    @FXML
    public Label errorMessage;

    @FXML
    public void submitClick() throws SQLException, IOException {
        System.out.println("submitClick");

        String email = emailField.getText();

        if (email.isEmpty()) {
            errorMessage.setText("Email field cannot be empty!");
            return;
        }

        AdminRecommendsRequestCommand adminRecommendsRequest = new AdminRecommendsRequestCommand();
        adminRecommendsRequest.makeRequest(new RecommendPacket(email , SingletonSession.getInstance().getSessionUser()));

        errorMessage.setText("Recommendation made!");
    }

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}
