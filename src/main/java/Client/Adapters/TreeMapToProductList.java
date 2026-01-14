package Client.Adapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

public class TreeMapToProductList {
    public static List<ProductQueryResult> convert(List<ProductQueryResult> rawList) {
        Gson gson = new Gson();

        // crea una lista che sarà la lista di oggetti effettivi
        List<ProductQueryResult> products = new ArrayList<>();

        // per ogni oggetto nella lista "grezza"
        for (int i = 0; i < rawList.size(); i++) {
            // 1. ottieni l'oggetto "grezzo"
            // 2. riconvertilo in JSON
            // 3. da JSON ri-riconvertilo in oggetto "effettivo"
            ProductQueryResult product = gson.fromJson(gson.toJson(rawList.get(i)), ProductQueryResult.class);
            // 4. Aggiungilo alla lista di oggetti effettivi
            products.add(product);
        }

        return products;
    }
}
