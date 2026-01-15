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

/**
 * Controller JavaFX per la schermata di modifica di un prodotto esistente.
 *
 * Gestisce l'acquisizione dei dati dal form, l'invio della richiesta di modifica
 * al server e la chiusura dello stage corrente.
 */
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

    /**
     * Gestisce il click sul pulsante di submit per la modifica prodotto.
     *
     * Crea un oggetto {@link ProductQueryResult} con i dati aggiornati,
     * invia la richiesta di modifica al server e chiude lo stage corrente.
     *
     * @throws SQLException se si verifica un errore durante la modifica sul database
     * @throws IOException se si verifica un errore durante la comunicazione con il server
     */
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

    /**
     * Gestisce il click sul pulsante di ritorno.
     *
     * Chiude lo stage corrente senza salvare le modifiche apportate.
     */
    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }
}
