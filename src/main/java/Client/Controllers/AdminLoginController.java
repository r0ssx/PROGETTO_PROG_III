package Client.Controllers;

import Client.RequestCommand.AdminLoginRequestCommand;
import Client.RequestCommand.UserLoginRequestCommand;
import Client.SingletonStage;
import Shared.GsonAdapters.AuthPacket;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller responsabile della gestione del login degli amministratori.
 * Estende {@link AuthController} e implementa la logica specifica
 * per l'autenticazione degli admin e il cambio scena successivo al login.
 */
public class AdminLoginController extends AuthController {

    /**
     * Costruttore del controller.
     * Inizializza il messaggio di errore mostrato in caso di login fallito.
     */
    AdminLoginController() {
        errorMessageString = "L'admin non esiste o la password è errata.";
    }

    /**
     * Esegue l'autenticazione dell'amministratore inviando la richiesta
     * al server tramite {@link AdminLoginRequestCommand}.
     * @param authPacket pacchetto contenente le credenziali di autenticazione
     * @return {@code true} se l'autenticazione va a buon fine, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    protected Boolean performAuth(AuthPacket authPacket) throws SQLException, IOException {
        AdminLoginRequestCommand command = new AdminLoginRequestCommand();
        return command.makeRequest(authPacket);
    }

    /**
     * Cambia la scena dell'applicazione dopo un login riuscito,
     * reindirizzando l'amministratore alla home.
     * @throws IOException se il caricamento della scena fallisce
     */
    @Override
    protected void changeScene() throws IOException {
        SingletonStage.fastChangeScene("ListHome.fxml", "Home", new UserHomeController());

    }
}
