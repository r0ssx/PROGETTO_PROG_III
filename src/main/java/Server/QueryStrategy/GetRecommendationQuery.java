package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetRecommendationQuery extends AbstractQueryStrategy<String, List<ProductQueryResult>> {

    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT nome, quantità_scorta, prodotto.codice, costo, descrizione, categoria FROM prodotto join raccomanda ON prodotto.codice where email = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();

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
