package Server.QueryCommand.QueryResultObject;

/**
 * Oggetto di risultato utilizzato per rappresentare un prodotto
 * restituito dalle query al database.
 * Contiene informazioni dettagliate sul prodotto, come nome, codice,
 * costo, descrizione, quantità disponibile e categoria.
 */
public class ProductQueryResult {

    public String nome;
    public String quantità_scorta;
    public String codice;
    public String costo;
    public String descrizione;
    public String categoria;

    /**
     * Restituisce una rappresentazione testuale dell'oggetto.
     * @return stringa contenente tutte le informazioni sul prodotto
     */
    @Override
    public String toString(){
        return "Prodotto[ nome: " + nome + ", quantità_scorta: " + quantità_scorta + ", codice: " + codice + ", costo: " + costo + ", descrizione: " + descrizione + ", categoria: " + categoria + "]";
    }
}
