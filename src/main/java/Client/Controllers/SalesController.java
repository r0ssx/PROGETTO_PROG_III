package Client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SalesController implements Initializable {
    @FXML
    public ListView<String> listView;

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");
        String[] prove = {"Prova", "Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova","Prova"};

        listView.getItems().addAll(prove);
    }
}
