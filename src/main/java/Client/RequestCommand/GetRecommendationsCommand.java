package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Comando di richiesta utilizzato per ottenere una lista di
 * prodotti consigliati per un utente specifico.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#GET_RECOMMENDATIONS}.
 */
public class GetRecommendationsCommand extends AbstractRequestCommand<String, List<ProductQueryResult>> {

    /**
     * Invia al server la richiesta di raccomandazioni per l'utente
     * identificato dalla stringa fornita.
     * @param s identificativo dell'utente per cui ottenere le raccomandazioni
     * @return lista dei prodotti consigliati
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public List<ProductQueryResult> makeRequest(String s) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.GET_RECOMMENDATIONS);
        server.sendData(requestPacket);

        server.sendData(s);

        return server.getData(List.class);
    }
}
