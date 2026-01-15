package Client.Controllers;

import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.AdminRecommendsRequestCommand;
import Client.Utilities.SingletonSession;
import Shared.GsonAdapters.RecommendPacket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller JavaFX per la schermata di raccomandazioni.
 *
 * Gestisce l'invio di raccomandazioni da parte dell'amministratore
 * e la navigazione di ritorno alla schermata precedente.
 */
public class RecommendController {
    @FXML
    public TextField emailField;

    @FXML
    public Label errorMessage;

    /**
     * Gestisce il click sul pulsante di submit della raccomandazione.
     *
     * Valida il campo email, invia la raccomandazione al server e mostra
     * un messaggio di conferma o errore.
     *
     * @throws SQLException se si verifica un errore durante l'invio al database
     * @throws IOException se si verifica un errore durante la comunicazione con il server
     */
    @FXML
    public void submitClick() throws SQLException, IOException {
        System.out.println("submitClick");

        String email = emailField.getText();

        if (email.isEmpty()) {
            errorMessage.setText("Email field cannot be empty!");
            return;
        }

        AdminRecommendsRequestCommand adminRecommendsRequest = new AdminRecommendsRequestCommand();
        adminRecommendsRequest.makeRequest(new RecommendPacket(email , SingletonSession.getInstance().getSessionUser()));

        errorMessage.setText("Recommendation made!");
    }

    /**
     * Gestisce il click sul pulsante di ritorno.
     *
     * Chiude lo stage corrente senza inviare la raccomandazione.
     */
    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}
