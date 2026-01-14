package Client.Controllers;

import Client.MainApp;
import Client.RequestCommand.UserRegisterRequestCommand;
import Client.Utilities.SingletonSession;
import Shared.GsonAdapters.AuthPacket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserRegisterController {
    @FXML
    public Label errorText;

    @FXML
    public TextField emailField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected void submitClick() throws IOException, SQLException {
        System.out.println("submitClick");

        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println("Email: " + email + " Password: " + password);

        if (email.isEmpty() || password.isEmpty()) {
            errorText.setText("Email or password cannot be empty!");
            return;
        }

        // USER REGISTER SERVER OPERATION

        UserRegisterRequestCommand userRegisterRequestCommand = new UserRegisterRequestCommand();
        Boolean result = userRegisterRequestCommand.makeRequest(new AuthPacket(email, password));

        // se result false allora utente esiste
        if (!result) {
            errorText.setText("User already exists.");
            return;
        }

        // imposta la sessione
        SingletonSession.getInstance().setSessionUser(email);

        // Passa a User Home
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Shopping");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    protected void backClick() throws IOException {
        System.out.println("backClick");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}