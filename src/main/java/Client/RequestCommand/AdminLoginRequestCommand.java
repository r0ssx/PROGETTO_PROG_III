package Client.RequestCommand;

import Shared.GsonAdapters.AuthPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato per l'autenticazione
 * degli amministratori dell'applicazione.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#ADMIN_LOGIN}.
 */
public class AdminLoginRequestCommand extends AbstractRequestCommand<AuthPacket, Boolean> {

    /**
     * Invia al server la richiesta di login amministratore
     * utilizzando le credenziali fornite.
     * @param authPacket pacchetto contenente le credenziali di autenticazione
     * @return {@code true} se il login ha successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public Boolean makeRequest(AuthPacket authPacket) throws SQLException, IOException {
        // Sending request
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_LOGIN);
        server.sendData(requestPacket);

        // Sending request parameters
        server.sendData(authPacket);

        // Getting result back
        return server.getData(Boolean.class);
    }
}