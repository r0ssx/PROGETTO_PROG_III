package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProductListQuery extends AbstractQueryStrategy<Void, List<ProdottiQueryResult>> {

    @Override
    protected ResultSet concreteQuery(Void params) throws SQLException {

        String query = "SELECT * From Prodotto";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    @Override
    protected List<ProdottiQueryResult> convertResultSet(ResultSet resultSet) throws SQLException {

        List<ProdottiQueryResult> queryResultObjectList = new ArrayList<>();

        while(resultSet.next()) {
            ProdottiQueryResult prodottiQueryResult = new ProdottiQueryResult();
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
