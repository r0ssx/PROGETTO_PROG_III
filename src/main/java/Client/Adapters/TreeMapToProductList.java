package Client.Adapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

public class TreeMapToProductList {
    public static List<ProductQueryResult> convert(List<ProductQueryResult> rawList) {
        Gson gson = new Gson();
        List<ProductQueryResult> products = new ArrayList<>();
        for (int i = 0; i < rawList.size(); i++) {
            ProductQueryResult product = gson.fromJson(gson.toJson(rawList.get(i)), ProductQueryResult.class);
            products.add(product);
        }
        return products;
    }
}
