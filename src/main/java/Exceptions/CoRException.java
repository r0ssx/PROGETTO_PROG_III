package Exceptions;

/**
 * Eccezione personalizzata utilizzata nel contesto del pattern
 * Chain of Responsibility (CoR).
 * Estende {@link RuntimeException} e viene lanciata per indicare
 * errori specifici durante l'esecuzione di una catena di responsabilità.
 */
public class CoRException extends RuntimeException {

    /**
     * Costruisce una nuova eccezione CoR con un messaggio specifico.
     * @param message messaggio descrittivo dell'eccezione
     */
    public CoRException(String message) {
        super(message);
    }
}
