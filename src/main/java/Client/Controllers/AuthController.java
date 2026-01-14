package Client.Controllers;

import Client.SingletonSession;
import Client.SingletonStage;
import Shared.GsonAdapters.AuthPacket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller astratto che fornisce la logica comune per
 * l'autenticazione degli utenti dell'applicazione.
 * Gestisce l'inserimento delle credenziali, la comunicazione
 * con il server e il cambio scena in caso di login riuscito.
 * Le sottoclassi devono implementare la logica di autenticazione
 * specifica e definire la scena successiva.
 */
public abstract class AuthController implements Controller {

    /**
     * Messaggio di errore visualizzato in caso di autenticazione fallita.
     */
    protected String errorMessageString = "";

    /**
     * Restituisce la label contenente il messaggio di errore.
     * @return label del messaggio di errore
     */
    public Label getError_message() {
        return error_message;
    }

    /**
     * Restituisce la label del titolo della schermata.
     * @return label del titolo
     */
    public Label getTitle() {
        return title;
    }

    /**
     * Restituisce il campo di testo per l'inserimento dell'ID utente.
     * @return campo di testo dell'ID
     */
    public TextField getIdField() {
        return idField;
    }

    /**
     * Restituisce il campo di inserimento della password.
     * @return campo password
     */
    public PasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Label utilizzata per mostrare messaggi di errore all'utente.
     */
    @FXML
    private Label error_message;

    /**
     * Label contenente il titolo della schermata di autenticazione.
     */
    @FXML
    private Label title;

    /**
     * Campo di testo per l'inserimento dell'ID utente.
     */
    @FXML
    private TextField idField;

    /**
     * Campo di testo per l'inserimento della password.
     */
    @FXML
    private PasswordField passwordField;

    /**
     * Pulsante per l'invio delle credenziali di autenticazione.
     */
    @FXML
    private Button submitButton;

    /**
     * Pulsante per tornare alla schermata precedente.
     */
    @FXML
    private Button backButton;

    /**
     * Gestisce l'evento di pressione del pulsante di submit.
     * Recupera le credenziali inserite dall'utente, invia la richiesta
     * di autenticazione al server e gestisce l'esito dell'operazione.
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @FXML
    private void handleSubmit() throws SQLException, IOException {
        String id = idField.getText();
        String password = passwordField.getText();

        System.out.println("ID: " + id);
        System.out.println("Password: " + password);

        // esegui l'operazione di autenticazione col server
        Boolean result = performAuth(new AuthPacket(id, password));

        if (!result) {
            error_message.setText(errorMessageString);
            return;
        }

        SingletonSession.getInstance().setSessionUser(id);
        // passa ad un'altra scena
        changeScene();
    }

    /**
     * Gestisce l'evento di pressione del pulsante "Indietro".
     * Riporta l'utente alla schermata Home.
     * @throws IOException se il caricamento della scena fallisce
     */
    @FXML
    private void handleBack() throws IOException {
        SingletonStage.fastChangeScene("Home.fxml", "Home", new HomeController());
    }

    /**
     * Esegue l'autenticazione dell'utente.
     * Deve essere implementato dalle sottoclassi
     * per definire la logica di login specifica.
     * @param authPacket pacchetto contenente le credenziali di autenticazione
     * @return {@code true} se l'autenticazione ha successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    protected abstract Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException;

    /**
     * Cambia la scena dell'applicazione dopo un login riuscito.
     * Deve essere implementato dalle sottoclassi.
     * @throws IOException se il caricamento della scena fallisce
     */
    protected abstract void changeScene() throws IOException;
}