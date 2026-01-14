package Client.Controllers;

import Client.MainApp;
import Client.Utilities.CartSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    public Label welcomeText;

    public void backClick() throws IOException {
        // torna al carrello
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }

    public void bancomatClick() throws IOException {
        // svuota il carrello e torna alla home
        CartSingleton.flushCart();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }


    public void creditCardClick() throws IOException {
        // svuota il carrello e torna alla home
        CartSingleton.flushCart();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }
}
