package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategia di query per ottenere le vendite aggregate per categoria.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query e convertire i risultati in una lista di {@link AdminGetSalesQueryResult}.
 */
public class AdminGetSalesQuery extends AbstractQueryStrategy<Void, List<AdminGetSalesQueryResult>>{

    /**
     * Esegue la query SQL per ottenere il totale delle vendite per categoria.
     * @param params parametro non utilizzato (nessun input richiesto)
     * @return {@link ResultSet} contenente i dati aggregati delle vendite per categoria
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(Void params) throws SQLException {
        String query = "SELECT categoria, SUM(quantità_acquistata) AS totale_vendite\n" +
                "FROM Acquistato JOIN Prodotto ON Acquistato.codice = Prodotto.codice\n" +
                "GROUP BY categoria";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una lista di {@link AdminGetSalesQueryResult}.
     * @param resultSet {@link ResultSet} contenente i dati aggregati delle vendite
     * @return lista di {@link AdminGetSalesQueryResult} con i risultati della query
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
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

