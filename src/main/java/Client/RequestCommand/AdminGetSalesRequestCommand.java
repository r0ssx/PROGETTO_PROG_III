package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Comando di richiesta utilizzato dagli amministratori
 * per ottenere la lista delle vendite dal server.
 * Estende {@link AbstractRequestCommand} e implementa
 * la logica di invio della richiesta {@link Request#ADMIN_GET_SALES}.
 */
public class AdminGetSalesRequestCommand extends AbstractRequestCommand<Void, List<AdminGetSalesQueryResult>>{

    /**
     * Invia al server la richiesta per il recupero delle vendite
     * e restituisce la lista dei risultati ottenuti.
     * @param unused parametro non utilizzato (richiesta senza input)
     * @return lista delle vendite effettuate
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public List<AdminGetSalesQueryResult> makeRequest(Void unused) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_GET_SALES);
        server.sendData(requestPacket);

        return server.getData(List.class);
    }
}
