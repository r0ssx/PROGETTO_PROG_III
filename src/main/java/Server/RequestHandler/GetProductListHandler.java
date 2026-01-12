package Server.RequestHandler;

import Server.QueryCommand.ProductCatalog;
import Server.QueryCommand.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#GET_PRODUCT_LIST}.
 * Questa classe si occupa di elaborare le richieste per il recupero
 * della lista dei prodotti disponibili nel sistema.
 */
public class GetProductListHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code GetProductListHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public GetProductListHandler(Request request){
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di recupero della lista dei prodotti.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#GET_PRODUCT_LIST} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di GetProductListHandler");
        QueryCommand queryCommand = new ProductCatalog();
        List<ProdottiQueryResult> result = (List<ProdottiQueryResult>) queryCommand.execute(null);
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(result);

    }
}
