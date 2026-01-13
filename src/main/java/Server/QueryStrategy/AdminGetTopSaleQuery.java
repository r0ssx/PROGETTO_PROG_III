package Server.QueryStrategy;

import Client.RequestCommand.AbstractRequestCommand;
import Server.QueryCommand.AbstractQueryCommand;

import java.sql.*;

public class AdminGetTopSaleQuery extends AbstractQueryStrategy<String, String> {

    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT categoria\n" +
                "FROM Acquistato JOIN Prodotto ON Prodotto.codice = Acquistato.codice\n" +
                "GROUP BY categoria\n" +
                "HAVING SUM(quantità_acquistata) =\n" +
                "(SELECT MAX(totale_acquisti) \n" +
                "FROM (SELECT SUM(quantità_acquistata) AS totale_acquisti\n" +
                "FROM Acquistato JOIN Prodotto ON Prodotto.codice = Acquistato.codice\n" +
                "WHERE email = ?\n" +
                "GROUP BY categoria) as countacquisti)";

       PreparedStatement statement = connection.prepareStatement(query);
       statement.setString(1, params);

       ResultSet resultSet = statement.executeQuery();

       return resultSet;
    }

    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("categoria");
        }
        return queryResult;
    }
}
