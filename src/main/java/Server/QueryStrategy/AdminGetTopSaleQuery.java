package Server.QueryStrategy;

import Client.RequestCommand.AbstractRequestCommand;
import Server.QueryCommand.AbstractQueryCommand;

import java.sql.*;

/**
 * Strategia di query per ottenere la categoria con il maggior numero di acquisti
 * di un utente specifico.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query e convertire il {@link ResultSet} in un {@link String}.
 */
public class AdminGetTopSaleQuery extends AbstractQueryStrategy<String, String> {

    /**
     * Esegue la query SQL per ottenere la categoria con il maggior numero di acquisti
     * di un utente specifico.
     * @param params email dell'utente di cui ottenere la categoria top sale
     * @return {@link ResultSet} contenente la categoria con il maggior numero di acquisti
     * @throws SQLException se si verifica un errore durante la preparazione o esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(String params) throws SQLException {
        String query = "SELECT categoria " +
                "FROM Acquistato JOIN Prodotto ON Prodotto.codice = Acquistato.codice " +
                "WHERE email = ? " +
                "GROUP BY categoria " +
                "HAVING SUM(quantità_acquistata) = " +
                "(SELECT MAX(totale_acquisti) " +
                "FROM (SELECT SUM(quantità_acquistata) AS totale_acquisti " +
                "FROM Acquistato JOIN Prodotto ON Prodotto.codice = Acquistato.codice " +
                "WHERE email = ? " +
                "GROUP BY categoria) as countacquisti)";

       PreparedStatement statement = connection.prepareStatement(query);
       statement.setString(1, params);
        statement.setString(2, params);

       ResultSet resultSet = statement.executeQuery();

       return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una {@link String}
     * rappresentante la categoria con il maggior numero di acquisti.
     * @param resultSet {@link ResultSet} contenente i dati della query
     * @return categoria con il maggior numero di acquisti, o stringa vuota se non presente
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected String convertResultSet(ResultSet resultSet) throws SQLException {

        String queryResult = "";
        while(resultSet.next()){
            queryResult = resultSet.getString("categoria");
        }
        return queryResult;
    }
}
