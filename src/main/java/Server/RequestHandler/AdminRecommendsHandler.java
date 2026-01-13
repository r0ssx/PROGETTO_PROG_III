package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminRecommendsCommand;
import Shared.DataIO;
import Shared.GsonAdapters.RecommendPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#ADMIN_RECOMMENDS}.
 * Questa classe si occupa di elaborare le richieste inviate da un amministratore
 * per la gestione o la generazione di raccomandazioni sui prodotti.
 */
public class AdminRecommendsHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code AdminRecommendsHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public AdminRecommendsHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di raccomandazioni da parte
     * dell'amministratore.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#ADMIN_RECOMMENDS} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws IOException, SQLException {
        System.out.println("chiamata handleRequest di AdminRecommendsHandler");
        AbstractQueryCommand queryCommand = new AdminRecommendsCommand();
        DataIO dataIO = new DataIO(socket);
        RecommendPacket readData = dataIO.getData(RecommendPacket.class);
        System.out.println(readData);
        queryCommand.execute(readData);

    }
}
