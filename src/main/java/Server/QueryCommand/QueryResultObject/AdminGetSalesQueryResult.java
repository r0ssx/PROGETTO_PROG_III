package Server.QueryCommand.QueryResultObject;

public class AdminGetSalesQueryResult {
    public String categoria;
    public int totale_vendite;

    @Override
    public String toString(){
        return "Acquistati[ categoria: " + categoria + ", totale_vendite: " + totale_vendite + "]";
    }
}

