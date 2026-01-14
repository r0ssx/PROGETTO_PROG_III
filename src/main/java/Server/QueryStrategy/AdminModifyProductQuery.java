package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModifyProductQuery extends AbstractQueryStrategy<ProductQueryResult, Boolean>{

    @Override
    protected ResultSet concreteQuery(ProductQueryResult params) throws SQLException {
        String query = "UPDATE prodotto\n" +
                "SET nome = ?, quantità_scorta = ?, codice = ?, costo = ?, descrizione = ?, categoria = ?\n" +
                "WHERE codice = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, params.nome);
        statement.setString(2, params.quantità_scorta);
        statement.setString(3, params.codice);
        statement.setString(4, params.costo);
        statement.setString(5, params.descrizione);
        statement.setString(6, params.categoria);
        statement.setString(7, params.codice);

        statement.executeUpdate();

        String query2 = "SELECT * FROM Prodotto WHERE prodotto.codice = ?";
        PreparedStatement statement1 = connection.prepareStatement(query2);
        statement1.setString(1, params.codice);

        ResultSet resultSet = statement1.executeQuery();

        return resultSet;

    }

    @Override
    protected Boolean convertResultSet(ResultSet resultSet) throws SQLException {
        Boolean exists = false;
        while(resultSet.next()){
            exists = true;
        }
        return exists;
    }
}
