package Server.RequestHandler;

import Exceptions.CoRException;
import Shared.Requests.Request;

/**
 * Classe astratta base per l'implementazione del pattern
 * <b>Chain of Responsibility</b> per la gestione delle richieste del server.
 * Ogni {@code AbstractRequestHandler} è in grado di gestire un solo tipo di
 * {@link Request}. Se non è in grado di gestire la richiesta corrente,
 * la delega al prossimo handler nella catena.
 */
public abstract class AbstractRequestHandler {

    /**
     * Tipo di richiesta che questo handler è in grado di gestire.
     */
    protected Request requestCanHandle;

    /**
     * Riferimento al prossimo handler nella catena.
     */
    protected AbstractRequestHandler nextHandler;

    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public AbstractRequestHandler(Request request) {
        requestCanHandle = request;
    }

    /**
     * Imposta il prossimo handler nella Chain of Responsibility.
     * @param nextHandler l'handler successivo nella catena
     */
    public void setNextHandler(AbstractRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * Metodo template che implementa la logica della Chain of Responsibility.
     * Se l'handler corrente è in grado di gestire la richiesta,
     * viene invocato {@link #handleRequest(Request)}.
     * Altrimenti la richiesta viene inoltrata al prossimo handler.
     * @param request la richiesta da gestire
     * @throws CoRException se nessun handler nella catena è in grado
     *                      di gestire la richiesta
     */
    public final void handle (Request request) throws CoRException{
        if(canHandle(request)){
            handleRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handle(request);
        } else {
            throw new CoRException("La richiesta corrente non può essere soddisfatta!!");
        }
    }

    /**
     * Verifica se l'handler corrente può gestire la richiesta specificata.
     * Il confronto è effettuato tramite uguaglianza tra enum {@link Request}.
     * @param request la richiesta da verificare
     * @return {@code true} se l'handler può gestire la richiesta,
     *         {@code false} altrimenti
     */
    protected boolean canHandle(Request request){
        return request == requestCanHandle;
    }

    /**
     * Gestisce concretamente la richiesta.
     * Questo metodo deve essere implementato dalle sottoclassi
     * per definire il comportamento specifico dell'handler.
     * @param request la richiesta da gestire
     */
    public abstract void handleRequest(Request request);
}
