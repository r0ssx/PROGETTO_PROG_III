package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato dagli amministratori
 * per modificare i dati di un prodotto esistente.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#ADMIN_MODIFY_PRODUCT}.
 */
public class AdminModifyProductRequestCommand extends AbstractRequestCommand<ProductQueryResult, Boolean>{

    /**
     * Invia al server la richiesta di modifica di un prodotto.
     * @param productQueryResult oggetto contenente i nuovi dati del prodotto
     * @return {@code true} se la modifica va a buon fine, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public Boolean makeRequest(ProductQueryResult productQueryResult) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_MODIFY_PRODUCT);
        server.sendData(requestPacket);

        server.sendData(productQueryResult);

        return server.getData(Boolean.class);
    }
}
