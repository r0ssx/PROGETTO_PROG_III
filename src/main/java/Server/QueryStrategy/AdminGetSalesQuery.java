package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminGetSalesQuery extends AbstractQueryStrategy<Void, List<AdminGetSalesQueryResult>>{

    @Override
    protected ResultSet concreteQuery(Void params) throws SQLException {
        String query = "SELECT categoria, SUM(quantità_acquistata) AS totale_vendite\n" +
                "FROM Acquistato JOIN Prodotto ON Acquistato.codice = Prodotto.codice\n" +
                "GROUP BY categoria";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    @Override
    protected List<AdminGetSalesQueryResult> convertResultSet(ResultSet resultSet) throws SQLException {

        List<AdminGetSalesQueryResult> queryResultList = new ArrayList<>();

        while(resultSet.next()){
            AdminGetSalesQueryResult adminGetSalesQueryResult = new AdminGetSalesQueryResult();
            adminGetSalesQueryResult.categoria = resultSet.getString("categoria");
            adminGetSalesQueryResult.totale_vendite = resultSet.getInt("totale_vendite");
            queryResultList.add(adminGetSalesQueryResult);
        }

        return queryResultList;
    }
}

