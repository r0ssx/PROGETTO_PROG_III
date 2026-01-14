package Client.Controllers;

import Client.RequestCommand.AdminInsertProductRequestCommand;
import Client.RequestCommand.AdminModifyProductRequestCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ModifyProductController {
    @FXML
    public Label welcomeText;

    @FXML
    public TextField nameField;

    @FXML
    public TextField stockField;

    @FXML
    public TextField codeField;

    @FXML
    public TextField priceField;

    @FXML
    public TextArea descriptionField;

    @FXML
    public TextField categoryField;

    @FXML
    public void submitClick() throws SQLException, IOException {
        System.out.println("submitClick");

        ProductQueryResult modifyProduct = new ProductQueryResult();
        modifyProduct.nome = nameField.getText();
        modifyProduct.quantità_scorta =  stockField.getText();
        modifyProduct.codice = codeField.getText();
        modifyProduct.costo = priceField.getText();
        modifyProduct.descrizione = descriptionField.getText();
        modifyProduct.categoria = categoryField.getText();

        AdminModifyProductRequestCommand adminInsertProductRequest = new AdminModifyProductRequestCommand();
        Boolean insert = adminInsertProductRequest.makeRequest(modifyProduct);

        System.out.println(insert);

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }
}
