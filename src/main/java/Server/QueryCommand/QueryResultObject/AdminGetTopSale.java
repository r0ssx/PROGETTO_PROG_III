package Server.QueryCommand.QueryResultObject;

/**
 * Oggetto di risultato utilizzato per rappresentare la vendita migliore
 * di un utente, destinato alle query amministrative.
 * Contiene informazioni sull'utente e sul prodotto della vendita più rilevante.
 */
public class AdminGetTopSale {
    public String email;
    public String codice;
    public String nome_utente;
}
