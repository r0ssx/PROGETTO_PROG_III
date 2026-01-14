package Client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Client.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void salesClick() throws IOException {
        System.out.println("salesClick");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Sales.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 440);
        Stage stage = new Stage();
        stage.setTitle("Top Sales");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void recommendClick() throws IOException {
        System.out.println("recommendClick");

        // Apre recommend senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Recommend.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Recommend");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void insertClick() throws IOException {
        System.out.println("insertClick");

        // Apre insert product senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("InsertProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 640);
        Stage stage = new Stage();
        stage.setTitle("Insert Product");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void modifyClick() throws IOException {
        System.out.println("modifyClick");

        // Apre insert product senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("ModifyProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 640);
        Stage stage = new Stage();
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }
}

