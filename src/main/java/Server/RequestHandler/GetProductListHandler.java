package Server.RequestHandler;

import Shared.Requests.Request;

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
     */
    @Override
    public void handleRequest(Request request) {

    }
}
