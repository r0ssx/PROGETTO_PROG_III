package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminGetSalesCommand;
import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#ADMIN_GET_SALES}.
 * Questa classe si occupa di elaborare le richieste inviate da un amministratore
 * per ottenere i dati relativi alle vendite.
 */
public class AdminGetSalesHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code AdminGetSalesHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public AdminGetSalesHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di recupero delle vendite.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#ADMIN_GET_SALES} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("Chiamata handleRequest di AndminGetSalesHandler");
        AbstractQueryCommand queryCommand = new AdminGetSalesCommand();
        List<AdminGetSalesQueryResult> result = (List<AdminGetSalesQueryResult>) queryCommand.execute(null);
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(result);
    }
}
