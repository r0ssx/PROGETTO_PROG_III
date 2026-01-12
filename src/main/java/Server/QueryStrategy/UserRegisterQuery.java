package Server.QueryStrategy;

import Shared.GsonAdapters.AuthPacket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegisterQuery extends AbstractQueryStrategy<AuthPacket, Integer>{

    @Override
    protected ResultSet concreteQuery(AuthPacket params) throws SQLException {
        String query = "INSERT INTO Utente (email, password) VALUES (?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.id);
        statement.setString(2, params.password);
        statement.executeUpdate();

        String query2 = "SELECT * FROM Utente WHERE email = ?";
        PreparedStatement statement2 = connection.prepareStatement(query2);
        statement2.setString(1, params.id);

        ResultSet resultSet = statement2.executeQuery();


        return resultSet;
    }

    @Override
    protected Integer convertResultSet(ResultSet resultSet) throws SQLException {
        Integer queryResult = 0;
        while (resultSet.next()){
            queryResult++;
        }
        return queryResult;
    }
}
