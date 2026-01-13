package Client.Controllers;

import Client.SingletonStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController implements Controller {

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button userLoginButton;

    @FXML
    private Button userRegisterButton;

    @FXML
    private void handleAdminLogin(ActionEvent event) {
        System.out.println("Admin login pressed");
        try {
            SingletonStage.fastChangeScene("Auth.fxml", "Admin Login", new AdminLoginController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUserLogin(ActionEvent event) {
        System.out.println("User login pressed");
        try {
            SingletonStage.fastChangeScene("Auth.fxml", "User Login", new UserLoginController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUserRegister(ActionEvent event) {
        System.out.println("User register pressed");
        try {
            SingletonStage.fastChangeScene("Auth.fxml", "User Register", new UserRegisterController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}