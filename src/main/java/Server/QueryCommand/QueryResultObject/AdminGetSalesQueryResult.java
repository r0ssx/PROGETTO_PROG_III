package Server.QueryCommand.QueryResultObject;

/**
 * Oggetto di risultato utilizzato per rappresentare le vendite
 * aggregate per categoria, destinato alle query amministrative.
 * Contiene la categoria del prodotto e il totale delle vendite associate.
 */
public class AdminGetSalesQueryResult {

    /**
     * Categoria del prodotto.
     */
    public String categoria;

    /**
     * Totale delle vendite per la categoria.
     */
    public int totale_vendite;

    /**
     * Restituisce una rappresentazione testuale dell'oggetto.
     * @return stringa contenente categoria e totale delle vendite
     */
    @Override
    public String toString(){
        return "Acquistati[ categoria: " + categoria + ", totale_vendite: " + totale_vendite + "]";
    }
}

