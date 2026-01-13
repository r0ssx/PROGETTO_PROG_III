package Client.Controllers;

import Client.SingletonSession;
import Client.SingletonStage;
import Shared.GsonAdapters.AuthPacket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public abstract class AuthController implements Controller {

    protected String errorMessageString = "";

    public Label getError_message() {
        return error_message;
    }

    public Label getTitle() {
        return title;
    }

    public TextField getIdField() {
        return idField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

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

    @FXML
    private Button backButton;

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

        // esegui l'operazione di autenticazione col server
        Boolean result = performAuth(new AuthPacket(id, password));

        if (!result) {
            error_message.setText(errorMessageString);
            return;
        }

        SingletonSession.getInstance().setSessionUser(id);
        // passa ad un'altra scena
        changeScene();
    }

    @FXML
    private void handleBack() throws IOException {
        SingletonStage.fastChangeScene("Home.fxml", "Home", new HomeController());
    }

    protected abstract Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException;

    protected abstract void changeScene() throws IOException;
}