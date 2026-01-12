package Server.QueryStrategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginQuery extends AbstractQueryStrategy<String, String> {

    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT password FROM Amministratore WHERE nome_utente = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();

        return resultSet;
    }

    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("password");
        }
        return queryResult;
    }
}
