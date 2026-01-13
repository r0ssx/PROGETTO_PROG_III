package Server.QueryStrategy;

import Client.RequestCommand.AbstractRequestCommand;
import Server.QueryCommand.QueryResultObject.AdminGetTopSale;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRecommendsQuery extends AbstractQueryStrategy<AdminGetTopSale, Void>{


    @Override
    protected ResultSet concreteQuery(AdminGetTopSale params) throws SQLException {
        String query = "INSERT INTO Raccomanda (EMAIL, CODICE, NOME_UTENTE) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.email);
        statement.setString(2, params.codice);
        statement.setString(3, params.nome_utente);
        statement.executeUpdate();

        return null;
    }

    @Override
    protected Void convertResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
