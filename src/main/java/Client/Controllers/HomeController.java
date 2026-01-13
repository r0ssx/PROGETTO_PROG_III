package Client.Controllers;

import Client.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.zip.CheckedOutputStream;

public class HomeController {

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button userLoginButton;

    @FXML
    private Button userRegisterButton;

    @FXML
    private void handleAdminLogin(ActionEvent event) {
        // TODO: load admin login scene or logic
        System.out.println("Admin login pressed");
        try {
            // Load the FXML
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Login.fxml"));
            Parent root = loader.load();

            LoginController controller = loader.getController();

            controller.getIdField().setPromptText("username");
            controller.getTitle().setText("Admin Login");

            // Get the current window (Stage)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new Scene with the loaded FXML
            Scene scene = new Scene(root);

            // Set the new Scene on the Stage
            stage.setScene(scene);

            // Optional: set title
            stage.setTitle("Admin Login");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUserLogin(ActionEvent event) {
        System.out.println("User login pressed");
        try {
            // Load the FXML
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Login.fxml"));
            Parent root = loader.load();

            LoginController controller = loader.getController();

            controller.getIdField().setPromptText("E-Mail");
            controller.getTitle().setText("User Login");

            // Get the current window (Stage)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new Scene with the loaded FXML
            Scene scene = new Scene(root);

            // Set the new Scene on the Stage
            stage.setScene(scene);

            // Optional: set title
            stage.setTitle("User Login");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUserRegister(ActionEvent event) {
        // TODO: load user registration scene or logic
        System.out.println("User register pressed");
        try {
            // Load the FXML
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Login.fxml"));
            Parent root = loader.load();

            LoginController controller = loader.getController();

            controller.getIdField().setPromptText("E-Mail");
            controller.getTitle().setText("User Register");

            // Get the current window (Stage)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new Scene with the loaded FXML
            Scene scene = new Scene(root);

            // Set the new Scene on the Stage
            stage.setScene(scene);

            // Optional: set title
            stage.setTitle("User Register");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAuthScreen(String title, String label) {

    }
}