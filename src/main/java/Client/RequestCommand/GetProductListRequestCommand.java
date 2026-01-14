package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Comando di richiesta utilizzato per ottenere la lista
 * completa dei prodotti disponibili nel sistema.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#GET_PRODUCT_LIST}.
 */
public class GetProductListRequestCommand extends AbstractRequestCommand<Void, List<ProductQueryResult>> {

    /**
     * Invia al server la richiesta di elenco prodotti
     * e restituisce la lista dei prodotti disponibili.
     * @param unused parametro non utilizzato (nessun input necessario)
     * @return lista dei prodotti presenti nel sistema
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public List<ProductQueryResult> makeRequest(Void unused) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.GET_PRODUCT_LIST);
        server.sendData(requestPacket);

        return server.getData(List.class);
    }
}
