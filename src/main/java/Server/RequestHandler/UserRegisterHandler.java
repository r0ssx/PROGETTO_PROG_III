package Server.RequestHandler;

import Shared.Requests.Request;

/**
 * Handler concreto della Chain of Responsibility responsabile
 * della gestione delle richieste di tipo {@link Request#USER_REGISTER}.
 * Questa classe si occupa di elaborare le richieste di registrazione
 * inviate da un nuovo utente del sistema.
 */
public class UserRegisterHandler extends AbstractRequestHandler{

    /**
     * Costruisce un {@code UserRegisterHandler} associato
     * al tipo di richiesta specificato.
     * @param request il tipo di {@link Request} che questo handler è in grado di gestire
     */
    public UserRegisterHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce concretamente la richiesta di registrazione dell'utente.
     * Questo metodo viene invocato solo se la richiesta è riconosciuta
     * come gestibile dall'handler corrente.
     * @param request la richiesta {@link Request#USER_REGISTER} da elaborare
     */
    @Override
    public void handleRequest(Request request) {
        System.out.println("chiamata handleRequest di UserRegisterHandler");
    }
}
