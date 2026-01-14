package Client.RequestCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato dagli amministratori
 * per inserire un nuovo prodotto nel sistema.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#ADMIN_INSERT_PRODUCT}.
 */
public class AdminInsertProductRequestCommand extends AbstractRequestCommand<ProductQueryResult, Boolean>{

    /**
     * Invia al server la richiesta di inserimento di un nuovo prodotto.
     * @param productQueryResult oggetto contenente i dati del prodotto da inserire
     * @return {@code true} se l'inserimento va a buon fine, {@code false} altrimenti
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public Boolean makeRequest(ProductQueryResult productQueryResult) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_INSERT_PRODUCT);
        server.sendData(requestPacket);

        server.sendData(productQueryResult);

        return server.getData(Boolean.class);
    }
}
