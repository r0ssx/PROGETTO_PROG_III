package Client.Controllers;

import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.AdminInsertProductRequestCommand;
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
 * Controller JavaFX per la schermata di inserimento di un nuovo prodotto.
 *
 * Gestisce l'acquisizione dei dati dal form, l'invio della richiesta di inserimento
 * al server e la chiusura dello stage corrente.
 */
public class InsertProductController {
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
     * Gestisce il click sul pulsante di submit per l'inserimento prodotto.
     *
     * Crea un oggetto {@link ProductQueryResult} con i dati inseriti,
     * invia la richiesta di inserimento al server e chiude lo stage corrente.
     *
     * @throws SQLException se si verifica un errore durante l'inserimento sul database
     * @throws IOException se si verifica un errore durante la comunicazione con il server
     */
    @FXML
    public void submitClick() throws SQLException, IOException {
        System.out.println("submitClick");

        ProductQueryResult prodottoNuovo = new ProductQueryResult();
        prodottoNuovo.nome = nameField.getText();
        prodottoNuovo.quantità_scorta =  stockField.getText();
        prodottoNuovo.codice = codeField.getText();
        prodottoNuovo.costo = priceField.getText();
        prodottoNuovo.descrizione = descriptionField.getText();
        prodottoNuovo.categoria = categoryField.getText();

        AdminInsertProductRequestCommand adminInsertProductRequest = new AdminInsertProductRequestCommand();
        Boolean insert = (Boolean) adminInsertProductRequest.makeRequest(prodottoNuovo);

        System.out.println(insert);

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il click sul pulsante di ritorno.
     *
     * Chiude lo stage corrente senza salvare i dati inseriti.
     */
    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) categoryField.getScene().getWindow();
        thisStage.close();
    }
}
