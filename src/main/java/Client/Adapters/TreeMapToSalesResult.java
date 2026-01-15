package Client.Adapters;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility per la conversione di una lista di {@link AdminGetSalesQueryResult}
 * ottenuti in forma grezza in istanze effettive e completamente tipizzate.
 *
 * La conversione avviene tramite doppia serializzazione JSON usando Gson:
 * oggetto -> JSON -> oggetto.
 */
public class TreeMapToSalesResult {

    /**
     * Converte una lista di {@code AdminGetSalesQueryResult} grezzi in una lista
     * di {@code AdminGetSalesQueryResult} correttamente istanziati.
     *
     * @param rawList lista di risultati di vendita in forma grezza
     * @return lista di {@code AdminGetSalesQueryResult} convertiti
     * @throws NullPointerException se {@code rawList} è null
     */
    public static List<AdminGetSalesQueryResult> convert(List<AdminGetSalesQueryResult> rawList) {
        Gson gson = new Gson();

        // crea una lista che sarà la lista di oggetti effettivi
        List<AdminGetSalesQueryResult> sales = new ArrayList<>();

        // per ogni oggetto nella lista "grezza"
        for (int i = 0; i < rawList.size(); i++) {
            // 1. ottieni l'oggetto "grezzo"
            // 2. riconvertilo in JSON
            // 3. da JSON ri-riconvertilo in oggetto "effettivo"
            AdminGetSalesQueryResult product = gson.fromJson(gson.toJson(rawList.get(i)), AdminGetSalesQueryResult.class);
            // 4. Aggiungilo alla lista di oggetti effettivi
            sales.add(product);
        }

        return sales;
    }
}
