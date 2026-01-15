package Server.QueryStrategy;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategia di query per ottenere l'elenco completo dei prodotti dal database.
 * Estende {@link AbstractQueryStrategy} e implementa i metodi concreti per
 * eseguire la query e convertire i risultati in una lista di {@link ProductQueryResult}.
 */
public class GetProductListQuery extends AbstractQueryStrategy<Void, List<ProductQueryResult>> {

    /**
     * Esegue la query SQL per ottenere tutti i prodotti dal database.
     * @param params parametro non utilizzato (nessun input richiesto)
     * @return {@link ResultSet} contenente tutti i prodotti
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    protected ResultSet concreteQuery(Void params) throws SQLException {

        String query = "SELECT * From Prodotto";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    /**
     * Converte il {@link ResultSet} ottenuto dalla query in una lista di {@link ProductQueryResult}.
     * @param resultSet {@link ResultSet} contenente i dati dei prodotti
     * @return lista di {@link ProductQueryResult} con i risultati della query
     * @throws SQLException se si verifica un errore durante la lettura dei dati dal {@link ResultSet}
     */
    @Override
    protected List<ProductQueryResult> convertResultSet(ResultSet resultSet) throws SQLException {

        List<ProductQueryResult> queryResultObjectList = new ArrayList<>();

        while(resultSet.next()) {
            ProductQueryResult prodottiQueryResult = new ProductQueryResult();
            prodottiQueryResult.nome = resultSet.getString("nome");
            prodottiQueryResult.quantità_scorta = resultSet.getString("quantità_scorta");
            prodottiQueryResult.codice = resultSet.getString("codice");
            prodottiQueryResult.costo = resultSet.getString("costo");
            prodottiQueryResult.descrizione = resultSet.getString("descrizione");
            prodottiQueryResult.categoria = resultSet.getString("categoria");
            queryResultObjectList.add(prodottiQueryResult);
        }

        return queryResultObjectList;
    }
}
