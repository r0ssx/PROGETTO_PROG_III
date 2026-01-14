package Client.RequestCommand;

import Server.QueryCommand.AbstractQueryCommand;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato dagli amministratori
 * per ottenere l'informazione relativa alla vendita migliore
 * associata a un determinato utente.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#ADMIN_GET_USER_TOP_SALE}.
 */
public class AdminGetTopSaleRequestCommand extends AbstractRequestCommand<String, String>{

    /**
     * Invia al server la richiesta per ottenere la vendita più rilevante
     * di un utente specifico.
     * @param s identificativo dell'utente per cui recuperare la vendita migliore
     * @return informazione relativa alla vendita migliore dell'utente
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public String makeRequest(String s) throws SQLException, IOException {
        //Sending request
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_GET_USER_TOP_SALE);
        server.sendData(requestPacket);

        //Sending request parameters
        server.sendData(s);

        //Getting result back
        return server.getData(String.class);

    }
}
