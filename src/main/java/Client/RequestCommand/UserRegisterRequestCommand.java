package Client.RequestCommand;

import Shared.GsonAdapters.AuthPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato per la registrazione
 * di un nuovo utente nell'applicazione.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#USER_REGISTER}.
 */
public class UserRegisterRequestCommand extends AbstractRequestCommand<AuthPacket, Boolean> {

    /**
     * Invia al server la richiesta di registrazione di un nuovo utente
     * utilizzando le credenziali fornite.
     * @param authPacket pacchetto contenente le credenziali dell'utente da registrare
     * @return {@code true} se la registrazione ha successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public Boolean makeRequest(AuthPacket authPacket) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.USER_REGISTER);
        server.sendData(requestPacket);

        server.sendData(authPacket);

        return server.getData(Boolean.class);
    }
}
