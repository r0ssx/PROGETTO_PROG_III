package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProdottiQueryResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog extends QueryCommand<List<ProdottiQueryResult>> {

    public ProductCatalog() throws SQLException {
    }

    @Override
    public List<ProdottiQueryResult> execute() throws SQLException {
        Connection connection = db.createConnection();
        String query = "SELECT * From Prodotto";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);


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

        connection.close();

        return queryResultObjectList;
    }
}
