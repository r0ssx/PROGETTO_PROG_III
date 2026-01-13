package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProductListQuery extends AbstractQueryStrategy<Void, List<ProductQueryResult>> {

    @Override
    protected ResultSet concreteQuery(Void params) throws SQLException {

        String query = "SELECT * From Prodotto";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    @Override
    protected List<ProductQueryResult> convertResultSet(ResultSet resultSet) throws SQLException {

        List<ProductQueryResult> queryResultObjectList = new ArrayList<>();

        while(resultSet.next()) {
            ProductQueryResult prodottiQueryResult = new ProductQueryResult();
            prodottiQueryResult.nome = resultSet.getString("nome");
            prodottiQueryResult.quantità_scorta = resultSet.getString("quantità_scorta");
            prodottiQueryResult.codice = resultSet.getString("codice");
            prodottiQueryResult.costo = resultSet.getString("costo");
            prodottiQueryResult.descrizione = resultSet.getString("descrizione");
            prodottiQueryResult.categoria = resultSet.getString("categoria");
            queryResultObjectList.add(prodottiQueryResult);
        }

        return queryResultObjectList;
    }
}
