package Client.Controllers;

import Client.MainApp;
import Client.RequestCommand.AdminLoginRequestCommand;
import Client.RequestCommand.UserLoginRequestCommand;
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

public class AdminLoginController {
    @FXML
    public Label errorText;

    @FXML
    public TextField usernameField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected void submitClick() throws IOException, SQLException {
        System.out.println("submitClick");

        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username + " Password: " + password);

        if (username.isEmpty() || password.isEmpty()) {
            errorText.setText("Username or password cannot be empty!");
            return;
        }

        // USER REGISTER SERVER OPERATION

        AdminLoginRequestCommand userRegisterRequestCommand = new AdminLoginRequestCommand();
        Boolean result = userRegisterRequestCommand.makeRequest(new AuthPacket(username, password));

        // se result false allora password o nome utente sbagliati
        if (!result) {
            errorText.setText("Password or username are wrong.");
            return;
        }

        // imposta la sessione
        SingletonSession.getInstance().setSessionUser(username);

        // Passa ad admin home
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("AdminHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Admin Home");
        stage.setScene(scene);
        stage.show();

        // chiude lo stage corrente
        Stage thisStage = (Stage) usernameField.getScene().getWindow();
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

        Stage thisStage = (Stage) usernameField.getScene().getWindow();
        thisStage.close();
    }
}
