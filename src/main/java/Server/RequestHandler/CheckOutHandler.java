package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.CheckoutCommand;
import Shared.DataIO;
import Shared.GsonAdapters.CartPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#USER_CHECKOUT}.
 * Questa classe si occupa di elaborare le richieste di checkout
 * effettuate da un utente, includendo la conferma dell'ordine
 * e le operazioni finali di acquisto.
 */
public class CheckOutHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code UserCheckOutHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public CheckOutHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di checkout dell'utente.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     *
     * @param request la richiesta {@link Request#USER_CHECKOUT} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws IOException, SQLException {
        System.out.println("chiamata handleRequest di CheckoutHandler");
        DataIO dataIO = new DataIO(socket);
        CartPacket packet = dataIO.getData(CartPacket.class);

        AbstractQueryCommand query = new CheckoutCommand();
        String codiceCarrello = (String) query.execute(packet);

        dataIO.sendData(codiceCarrello);
    }
}
