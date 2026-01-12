package Server.RequestHandler;

import Shared.Requests.Request;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#ADMIN_LOGIN}.
 * Questa classe si occupa di elaborare le richieste di autenticazione
 * inviate da un amministratore del sistema.
 */
public class AdminLoginHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code AdminLoginHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public AdminLoginHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di login dell'amministratore.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#ADMIN_LOGIN} da elaborare
     */
    @Override
    public void handleRequest(Request request) {
        System.out.println("chiamata handleRequest di AdminLoginHandler");
    }
}
