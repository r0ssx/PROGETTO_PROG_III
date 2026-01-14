package Client.Controllers;

import Client.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginController {
    @FXML
    public Label errorText;

    @FXML
    public TextField emailField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected void submitClick() throws IOException {
        System.out.println("submitClick");

        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println("Email: " + email + " Password: " + password);

        // Passa a User Home
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("User Login");
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
        stage.setTitle("User Login");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}
