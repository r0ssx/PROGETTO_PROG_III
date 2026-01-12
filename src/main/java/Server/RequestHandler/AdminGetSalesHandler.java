package Server.RequestHandler;

import Shared.Requests.Request;

import java.net.Socket;

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
     *
     * @param request la richiesta {@link Request#ADMIN_GET_SALES} da elaborare
     * @param socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) {
        System.out.println("Chiamata handleRequest di AndminGetSalesHandler");
    }
}
