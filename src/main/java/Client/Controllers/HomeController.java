package Client.Controllers;

import Client.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void userLoginClick() throws IOException {
        System.out.println("userLoginClicked");

        // Apre user login
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("User Login");
        stage.setScene(scene);
        stage.show();

        // Chiude lo stage corrente
        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    protected void userRegisterClick() throws IOException {
        System.out.println("userRegisterClick");

        // Apre user register
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserRegister.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("User Register");
        stage.setScene(scene);
        stage.show();

        // Chiude lo stage corrente
        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    protected void adminLoginClick() throws IOException {
        System.out.println("adminLoginClick");

        // Apre admin login
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("AdminLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();

        // Chiude lo stage corrente
        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }
}
