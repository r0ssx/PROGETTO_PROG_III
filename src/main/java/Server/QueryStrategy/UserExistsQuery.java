package Server.QueryStrategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExistsQuery extends AbstractQueryStrategy<String, String>{

    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT * FROM Utente WHERE email = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params);

        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }

    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("email");
        }
        return queryResult;
    }
}
