package Server.RequestHandler;

import Shared.Requests.Request;

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
     */
    @Override
    public void handleRequest(Request request) {

    }
}
