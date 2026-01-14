package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminInsertProductCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#ADMIN_INSERT_PRODUCT}.
 * Questa classe si occupa di elaborare le richieste inviate da un amministratore
 * per l'inserimento di un nuovo prodotto nel sistema.
 */
public class AdminInsertProductHandler extends AbstractRequestHandler {

    /**
     * Costruisce un {@code AdminInsertProductHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public AdminInsertProductHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di inserimento di un prodotto.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#ADMIN_INSERT_PRODUCT} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws IOException, SQLException {
        System.out.println("chiamata handleRequest di AndminInsertProductHandler");

        DataIO dataIO = new DataIO(socket);
        ProductQueryResult prodotto = dataIO.getData(ProductQueryResult.class);

        AbstractQueryCommand command = new AdminInsertProductCommand();
        Boolean insertion = (Boolean) command.execute(prodotto);

        dataIO.sendData(insertion);


    }
}
