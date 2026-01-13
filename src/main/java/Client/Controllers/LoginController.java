package Client.Controllers;

import Client.RequestCommand.AdminLoginRequestCommand;
import Shared.GsonAdapters.AuthPacket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Label error_message;

    @FXML
    private Label title;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    /**
     * Called when the submit button is pressed.
     * Access email and password using emailField.getText() and passwordField.getText()
     */
    @FXML
    private void handleSubmit() throws SQLException, IOException {
        String id = idField.getText();
        String password = passwordField.getText();

        System.out.println("ID: " + id);
        System.out.println("Password: " + password);

        AdminLoginRequestCommand command = new AdminLoginRequestCommand();
        Boolean result = command.makeRequest(new AuthPacket(id, password));

        if (!result) {
            error_message.setText("Login errato");
        }

        // passa a view corretta
    }

    public TextField getIdField() {
        return idField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getTitle() {
        return title;
    }
}