package Server.QueryCommand.QueryResultObject;

public class ProductQueryResult {

    public String nome;
    public String quantità_scorta;
    public String codice;
    public String costo;
    public String descrizione;
    public String categoria;

    @Override
    public String toString(){
        return "Prodotto[ nome: " + nome + ", quantità_scorta: " + quantità_scorta + ", codice: " + codice + ", costo: " + costo + ", descrizione: " + descrizione + ", categoria: " + categoria + "]";
    }
}
